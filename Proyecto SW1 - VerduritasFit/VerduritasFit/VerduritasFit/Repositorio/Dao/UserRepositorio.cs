using AutoMapper;

using Microsoft.Data.SqlClient;
using Microsoft.IdentityModel.Tokens;

using System.Data;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;

using VerduritasFit.Data;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Repositorio.Dao
{
    public class UserRepositorio : IUserRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;
        private readonly IConfiguration _configuration;

        public UserRepositorio(IMapper mapper, IConfiguration configuration)
        {
            _mapper = mapper;
            _configuration = configuration;
            _conexion = new Conexion();
        }

        private Usuario getUser(string username, SqlConnection conexion)
        {
            Usuario usuario = new Usuario();
            SqlCommand cmd = new SqlCommand("usp_getUsuarioByUserName", conexion);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@userName", username);
            SqlDataReader dr = cmd.ExecuteReader();
            if (dr.Read())
            {
                usuario.userName = dr.GetString(0);
                usuario.PasswordHash = (byte[])dr[1];
                usuario.PasswordSalt = (byte[])dr[2];
            }
            else
            {
                usuario = null;
            }
            return usuario;
        }
        private bool UserExiste(string username, SqlConnection conexion)
        {
            try
            {
                SqlCommand cmd = new SqlCommand("SELECT dbo.validarExisteUserName(@username)", conexion);
                cmd.Parameters.AddWithValue("@username", username);
                bool ejecucion = (bool)cmd.ExecuteScalar();
                if (ejecucion is true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch (Exception ex) { return false; }
        }
        private bool VerificarPasswordHash(string password, byte[] passwordHash, byte[] passwordSalt)
        {
            using (var hmac = new System.Security.Cryptography.HMACSHA512(passwordSalt))
            {
                var computedHash = hmac.ComputeHash(System.Text.Encoding.UTF8.GetBytes(password));
                for (int i = 0; i < computedHash.Length; i++)
                {
                    if (computedHash[i] != passwordHash[i])
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        private void CrearPasswordHash(string password, out byte[] passwordHash, out byte[] passwordSalt)
        {
            using (var hmac = new System.Security.Cryptography.HMACSHA512())
            {
                passwordSalt = hmac.Key;
                passwordHash = hmac.ComputeHash(System.Text.Encoding.UTF8.GetBytes(password));
            }
        }
        private string CrearToken(string userName)
        {
            var claims = new List<Claim>
            {
                new Claim(ClaimTypes.NameIdentifier, userName),
                new Claim(ClaimTypes.Name, userName)
            };

            var key = new SymmetricSecurityKey(System.Text.Encoding.UTF8.
                                        GetBytes(_configuration.GetSection("AppSettings:Token").Value));


            var creds = new SigningCredentials(key, SecurityAlgorithms.HmacSha512Signature);

            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(claims),
                Expires = System.DateTime.Now.AddDays(1),
                SigningCredentials = creds
            };

            var tokenHandler = new JwtSecurityTokenHandler();
            var token = tokenHandler.CreateToken(tokenDescriptor);

            return tokenHandler.WriteToken(token);

        }

        public async Task<string> Register(UsuarioDto usuario)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    if (!UserExiste(usuario.userName, conexion))
                    {
                        CrearPasswordHash(usuario.clave, out byte[] passwordHash, out byte[] passwordSalt);
                        SqlCommand cmd = new SqlCommand("usp_insertarUsuario", conexion);
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@userName", usuario.userName);
                        cmd.Parameters.AddWithValue("@passwordHash", passwordHash);
                        cmd.Parameters.AddWithValue("@passwordSalt", passwordSalt);
                        int c = cmd.ExecuteNonQuery();
                        if (c > 0)
                        {
                            return CrearToken(usuario.userName);
                        }
                        else
                        {
                            mensaje = "error";
                        }
                    }
                    else
                    {
                        mensaje = "existe";
                    }
                }
                catch (Exception ex) { mensaje = ex.Message; }
                finally { conexion.Close(); }
            }
            return mensaje;
        }
        public async Task<string> Login(string userName, string password)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    Usuario user = getUser(userName, conexion);
                    if (user == null)
                    {
                        mensaje = "noinicio";
                    }
                    else if (!VerificarPasswordHash(password, user.PasswordHash, user.PasswordSalt))
                    {
                        return "noinicio";
                    }
                    else
                    {
                        return CrearToken(userName);
                    }
                }
                catch (Exception ex) { mensaje = ex.Message; }
                finally { conexion.Close(); }
            }
            return mensaje;
        }
        public async Task<string> ActualizarPassword(string username, string oldPassword, string newPassword)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    Usuario user = getUser(username, conexion);
                    if (user == null)
                    {
                        mensaje = "nocoincide";
                    }
                    else if (!VerificarPasswordHash(oldPassword, user.PasswordHash, user.PasswordSalt))
                    {
                        return "nocoincide";
                    }
                    else
                    {
                        CrearPasswordHash(newPassword, out byte[] passwordHash, out byte[] passwordSalt);
                        SqlCommand cmd = new SqlCommand("usp_actualizaPassword", conexion);
                        cmd.CommandType = CommandType.StoredProcedure;
                        cmd.Parameters.AddWithValue("@userName", username);
                        cmd.Parameters.AddWithValue("@passwordHash", passwordHash);
                        cmd.Parameters.AddWithValue("@passwordSalt", passwordSalt);
                        int succes = cmd.ExecuteNonQuery();
                        if (succes == 1)
                        {
                            return "succes";
                        }
                    }
                }
                catch (Exception ex) { mensaje = ex.Message; }
                finally { conexion.Close(); }
            }
            return mensaje;
        }
    }
}

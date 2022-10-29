using AutoMapper;

using Microsoft.Data.SqlClient;

using System.Data;

using VerduritasFit.Data;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.IDao;

using System.Diagnostics;

namespace VerduritasFit.Repositorio.Dao
{
    public class ClienteRepositorio : IClienteRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;

        public ClienteRepositorio(IMapper mapper)
        {
            _mapper = mapper;
            _conexion = new Conexion();
        }
        public async Task<List<ClienteDto>> listarCliente()
        {
            List<Cliente>? listaCliente = new List<Cliente>();
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_listarClientes", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        listaCliente.Add(new Cliente()
                        {
                            id_cliente = (string)dr[0],
                            nombre = (string)dr[1],
                            apellido = (string)dr[2],
                            fechaNacimiento = (DateTime)dr[3],
                            estatura = (decimal)dr[4],
                            peso = (decimal)dr[5],
                            correo = (string)dr[6],
                            telefono = (string)dr[7],
                            id_objetivo = (int)dr[8],
                            userName = (string)dr[9],
                            activo = (bool)dr[10],
                        });
                    }
                }
                catch (Exception ex) { listaCliente = null; Debug.WriteLine("Error: " + ex.Message); }
                finally { conexion.Close(); }
            }
            return _mapper.Map<List<ClienteDto>>(listaCliente);
        }

        public async Task<string> insertarCliente(ClienteDto cliente)
        {
            string mensaje = "";
            ClienteDto validar = listarCliente().Result.Where(c => c.userName.Equals(cliente.userName)).FirstOrDefault();
            if (validar != null) return "Cliente ya existe";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_insertarCliente", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@nombre",cliente.nombre);
                    cmd.Parameters.AddWithValue("@apellido", cliente.apellido);
                    cmd.Parameters.AddWithValue("@fechaNacimiento", cliente.fechaNacimiento);
                    cmd.Parameters.AddWithValue("@estatura", cliente.estatura);
                    cmd.Parameters.AddWithValue("@peso", cliente.peso);
                    cmd.Parameters.AddWithValue("@correo", cliente.correo);
                    cmd.Parameters.AddWithValue("@telefono", cliente.telefono);
                    cmd.Parameters.AddWithValue("@id_objetivo", cliente.id_objetivo);
                    cmd.Parameters.AddWithValue("@userName", cliente.userName);
                    int success = cmd.ExecuteNonQuery();
                    if (success > 0)
                    {
                        mensaje = "success";
                    }
                    else
                    {
                        mensaje = "errorsql";
                    }
                }
                catch (Exception ex) { mensaje = ex.Message; }
                finally { conexion.Close(); }
            }
            return mensaje;
        }

        public async Task<string> desactivarCliente(string id_Cliente)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_desactivarCliente", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_cliente", id_Cliente);
                    int success = cmd.ExecuteNonQuery();
                    if (success > 0)
                    {
                        mensaje = "success";
                    }
                    else
                    {
                        mensaje = "errorsql";
                    }
                }
                catch (Exception ex) { mensaje = ex.Message; }
                finally { conexion.Close(); }
            }
            return mensaje;
        }

        public async Task<string> actualizarObjetivo(ClienteDto cliente)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_actualizarCliente", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_cliente", cliente.id_cliente);
                    cmd.Parameters.AddWithValue("@estatura", cliente.estatura);
                    cmd.Parameters.AddWithValue("@peso", cliente.peso);
                    cmd.Parameters.AddWithValue("@correo", cliente.correo);
                    cmd.Parameters.AddWithValue("@telefono", cliente.telefono);
                    cmd.Parameters.AddWithValue("@id_objetivo", cliente.id_objetivo);
                    int success = cmd.ExecuteNonQuery();
                    if (success > 0)
                    {
                        mensaje = "success";
                    }
                    else
                    {
                        mensaje = "errorsql";
                    }
                }
                catch (Exception ex) { mensaje = ex.Message; }
                finally { conexion.Close(); }
            }
            return mensaje;
        }

        public async Task<ClienteDto> buscarClientePorUsername(string username)
        {
            return listarCliente().Result.FirstOrDefault(x => x.userName.Equals(username));
        }
    }
}

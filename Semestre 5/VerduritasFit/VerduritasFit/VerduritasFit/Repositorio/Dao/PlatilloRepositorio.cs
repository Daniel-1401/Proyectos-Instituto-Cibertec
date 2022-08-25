using AutoMapper;

using Microsoft.Data.SqlClient;

using System.Data;
using System.Diagnostics;

using VerduritasFit.Data;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Repositorio.Dao
{
    public class PlatilloRepositorio : IPlatilloRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;


        protected IWebHostEnvironment _entorno;
        protected string RUTA_WWWROOT => _entorno.WebRootPath;
        protected string RUTA_QR => @$"{RUTA_WWWROOT}/images/";

        public PlatilloRepositorio(IMapper mapper, IWebHostEnvironment webHostEnviroment)
        {
            _mapper = mapper;
            _entorno = webHostEnviroment;
            _conexion = new Conexion();
        }

        public async Task<List<PlatilloDto>> listarPlatillos()
        {
            List<Platillo> listaPlatillo = new List<Platillo>();
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_listarPlatillos", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        listaPlatillo.Add(new Platillo()
                        {
                            id_platillo = (int)dr[0],
                            nombre = (string)dr[1],
                            descripcion = (string)dr[2],
                            ingrediente = (string)dr[3],
                            id_categoria = (int)dr[4],
                            precio = (decimal)dr[5],
                            calorias = (int)dr[6],
                        });
                    }
                }
                catch (Exception ex) { listaPlatillo = null; Debug.WriteLine("Error: " + ex.Message); }
                finally { conexion.Close(); }
            }
            return _mapper.Map<List<PlatilloDto>>(listaPlatillo);
        }

        public async Task<PlatilloDto> buscarPlatilloPorId(int id_platillo)
        {
            return listarPlatillos().Result.FirstOrDefault(P => P.id_platillo.Equals(id_platillo));
        }

        public async Task<string> insertarPlatillo(PlatilloDto platillo)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    string urlImagen = this.SaveImage(platillo.imagen64, platillo.id_platillo, platillo.id_imagen);
                    SqlCommand cmd = new SqlCommand("usp_insertaPlatillo", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@nombre", platillo.nombre);
                    cmd.Parameters.AddWithValue("@descripcion", platillo.descripcion);
                    cmd.Parameters.AddWithValue("@ingrediente", platillo.ingrediente);
                    cmd.Parameters.AddWithValue("@id_categoria", platillo.id_categoria);
                    cmd.Parameters.AddWithValue("@precio", platillo.precio);
                    cmd.Parameters.AddWithValue("@caloria", platillo.calorias);
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

        public async Task<string> actualizarPlatillo(PlatilloDto platillo)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_actualizarPlatillo", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_platillo", platillo.id_platillo);
                    cmd.Parameters.AddWithValue("@nombre", platillo.nombre);
                    cmd.Parameters.AddWithValue("@descripcion", platillo.descripcion);
                    cmd.Parameters.AddWithValue("@ingrediente", platillo.ingrediente);
                    cmd.Parameters.AddWithValue("@id_categoria", platillo.id_categoria);
                    cmd.Parameters.AddWithValue("@precio", platillo.precio);
                    cmd.Parameters.AddWithValue("@caloria", platillo.calorias);
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

        public async Task<string> eliminarPlatillo(int id_platillo)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_eliminarPlatillo", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_platillo", id_platillo);
                    int success = cmd.ExecuteNonQuery();
                    if (success > 0)
                    {
                        //busco el directorio de las imagenes del platillo y lo elimino si es que existe
                        String path = RUTA_QR + "platillos/platillo_" + id_platillo;
                        bool existeDirectorio = Directory.Exists(path);

                        if (existeDirectorio)
                        {
                            Directory.Delete(path, true);
                        }
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
        private string SaveImage(string imagen, int? fileName_idPlatillo, string imgName_idImagen)
        {
            String RUTA = RUTA_QR;
            String urlInit = "platillos/platillo_" + Convert.ToString(fileName_idPlatillo);
            String path = RUTA + urlInit;

            //Check if directory exist
            if (!System.IO.Directory.Exists(path))
            {
                System.IO.Directory.CreateDirectory(path);
            }
            string imageName = imgName_idImagen + ".jpg";

            string imgPath = Path.Combine(path, imageName);
            string urlImagen = Path.Combine("images/" + urlInit, imageName);

            byte[] imageBytes = Convert.FromBase64String(imagen);

            File.WriteAllBytes(imgPath, imageBytes);

            return urlImagen;
        }
        private void DeleteImagen(int id_platillo, string id_imagen)
        {
            String path = RUTA_QR + "platillos/platillo_" + Convert.ToString(id_platillo) + "/" + id_imagen + ".jpg";
            bool existeImagen = File.Exists(path);

            if (existeImagen)
            {
                Debug.WriteLine("Existe imagen");
                File.Delete(path);
            }
            else
            {
                Debug.WriteLine("No existe imagen");
            }
        }
    }
}

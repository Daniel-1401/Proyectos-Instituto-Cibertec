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
    public class ImagenRepositorio : IImagenRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;

        protected IWebHostEnvironment _entorno;
        protected string RUTA_WWWROOT => _entorno.WebRootPath;
        protected string RUTA_QR => @$"{RUTA_WWWROOT}/images/";

        public ImagenRepositorio(IMapper mapper, IWebHostEnvironment webHostEnviroment)
        {
            _mapper = mapper;
            _entorno = webHostEnviroment;
            _conexion = new Conexion();
        }
        public async Task<List<ImagenDto>> listarImagenes()
        {
            List<Imagen> listaImagen = new List<Imagen>();
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_listarImagenes", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        listaImagen.Add(new Imagen()
                        {
                            id_platillo = (int)dr[0],
                            id_imagen = (string)dr[1],
                            urlImagen = (string)dr[2],
                        });
                    }
                }
                catch (Exception ex) { listaImagen = null; Debug.WriteLine("Error: " + ex.Message); }
                finally { conexion.Close(); }
            }
            return _mapper.Map<List<ImagenDto>>(listaImagen);
        }

        public async Task<List<ImagenDto>> buscarImagenesPorIdPlatillo(int id_platillo)
        {
            return listarImagenes().Result.Where(I => I.id_platillo.Equals(id_platillo)).ToList();
        }

        public async Task<ImagenDto> buscarImagenesPorIdPlatilloIdImagen(int id_platillo, string id_imagen)
        {
            ImagenDto? imagen = listarImagenes().Result.FirstOrDefault(I => (I.id_platillo.Equals(id_platillo)) &&
                                                                            (I.id_imagen.Equals(id_imagen))); ;
            return imagen;
        }

        public async Task<string> insertarImagen(ImagenDto imagen)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    string urlImagen = this.SaveImage(imagen.imagen64, imagen.id_platillo, imagen.id_imagen);
                    SqlCommand cmd = new SqlCommand("usp_insertarImagen", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_platillo", imagen.id_platillo);
                    cmd.Parameters.AddWithValue("@id_imagen", imagen.id_imagen);
                    cmd.Parameters.AddWithValue("@urlImagen", urlImagen);
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

        public async Task<string> actualizarImagen(ImagenDto imagen)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    string urlImagen = this.SaveImage(imagen.imagen64, imagen.id_platillo, imagen.id_imagen);
                    SqlCommand cmd = new SqlCommand("usp_actualizarImagen", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_platillo", imagen.id_platillo);
                    cmd.Parameters.AddWithValue("@id_imagen", imagen.id_imagen);
                    cmd.Parameters.AddWithValue("@urlImagen", urlImagen);
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

        public async Task<string> eliminarImagen(ImagenDto imagen)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_eliminarImagen", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_platillo", imagen.id_platillo);
                    cmd.Parameters.AddWithValue("@id_imagen", imagen.id_imagen);
                    int success = cmd.ExecuteNonQuery();
                    if (success > 0)
                    {
                        this.DeleteImagen(imagen.id_platillo, imagen.id_imagen);
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
    
        private string SaveImage(string imagen, int fileName_idPlatillo, string imgName_idImagen)
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

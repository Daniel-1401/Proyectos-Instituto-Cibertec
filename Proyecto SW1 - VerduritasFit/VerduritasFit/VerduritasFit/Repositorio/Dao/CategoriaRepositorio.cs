using AutoMapper;
using VerduritasFit.Repositorio.IDao;
using VerduritasFit.Data;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using Microsoft.Data.SqlClient;
using System.Diagnostics;
using System.Data;

namespace VerduritasFit.Repositorio.Dao
{
    public class CategoriaRepositorio : ICategoriaRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;

        public CategoriaRepositorio(IMapper mapper)
        {
            _mapper = mapper;
            _conexion = new Conexion();
        }

        public async Task<List<CategoriaDto>> listarCategorias()
        {
            List<Categoria> listaCategoria = new List<Categoria>();
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_listarCategoria", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        listaCategoria.Add(new Categoria()
                        {
                            id_categoria = (int)dr[0],
                            nombreCategoria = (string)dr[1],
                        });
                    }
                }
                catch (Exception ex) { listaCategoria = null; Debug.WriteLine("Error: " + ex.Message); }
                finally { conexion.Close(); }
            }
            return _mapper.Map<List<CategoriaDto>>(listaCategoria);
        }

        public async Task<CategoriaDto> buscarCategoriaPorId(int id_categoria)
        {
            return listarCategorias().Result.FirstOrDefault(c => c.id_categoria.Equals(id_categoria));
        }

        public async Task<string> insertarCategoria(string descripcion)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_insertarCategoria", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@nombreCategoria", descripcion);
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

        public async Task<string> actualizarCategoria(CategoriaDto categoria)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_actualizarCategoria", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_categoria", categoria.id_categoria);
                    cmd.Parameters.AddWithValue("@nombreCategoria", categoria.nombre_categoria);
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

        public async Task<string> eliminarCategoria(int id_categoria)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_eliminarCategoria", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_categoria", id_categoria);
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
    }
}

using AutoMapper;
using VerduritasFit.Repositorio.IDao;
using VerduritasFit.Data;
using Microsoft.Data.SqlClient;
using System.Data;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using System.Diagnostics;

namespace VerduritasFit.Repositorio.Dao
{
    public class ObjetivoRepositorio : IObjetivoRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;

        public ObjetivoRepositorio(IMapper mapper)
        {
            _mapper = mapper;
            _conexion = new Conexion();
        }
        public async Task<List<ObjetivoDto>> listarObjetivos()
        {
            List<Objetivo>? listaObjetivo = new List<Objetivo>();
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_listarObjetivos", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        listaObjetivo.Add(new Objetivo()
                        {
                            Id_objetivo = (int)dr[0],
                            DecripcionObjetivo = (string)dr[1],
                        });
                    }
                }
                catch (Exception ex) { listaObjetivo = null; Debug.WriteLine(ex.ToString); }
                finally { conexion.Close(); }
            }
            return _mapper.Map<List<ObjetivoDto>>(listaObjetivo);
        }
        
        public async Task<ObjetivoDto> buscarObjetivoPorId(int id_objetivo)
        {
            return listarObjetivos().Result.FirstOrDefault(o => o.Id_objetivo.Equals(id_objetivo));
        }
        
        public async Task<string> insertarObjetivo(string descripcion)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_insertarObjetivo", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@descipcion", descripcion);
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
        
        public async Task<string> eliminarObjetivo(int id_objetivo)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_eliminarObjetivo", conexion);
                    cmd.CommandType= CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_objetivo", id_objetivo);
                    int success = cmd.ExecuteNonQuery();
                    if(success > 0)
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

        public async Task<string> actualizarObjetivo(ObjetivoDto objetivo)
        {
            string mensaje = "";
            using(SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_actualizarObjetivo", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_objetivo", objetivo.Id_objetivo);
                    cmd.Parameters.AddWithValue("@decripcionObjetivo", objetivo.DecripcionObjetivo);
                    int success = cmd.ExecuteNonQuery();
                    if(success > 0)
                    {
                        mensaje ="success";
                    }
                    else
                    {
                        mensaje = "errorsql";
                    }
                }
                catch(Exception ex) { mensaje = ex.Message; }
                finally { conexion.Close(); }
            }
            return mensaje;
        }
    }
}

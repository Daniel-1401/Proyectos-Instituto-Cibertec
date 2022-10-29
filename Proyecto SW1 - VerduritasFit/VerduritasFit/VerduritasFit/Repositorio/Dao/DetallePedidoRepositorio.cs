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
    public class DetallePedidoRepositorio : IDetallePedidoRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;

        public DetallePedidoRepositorio(IMapper mapper)
        {
            _mapper = mapper;
            _conexion = new Conexion();
        }

        public async Task<List<DetallePedidoDto>> listarDetallePedidos()
        {
            List<DetallePedido> listaDetallePedido = new List<DetallePedido>();
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_listarDetallePedidos", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        listaDetallePedido.Add(new DetallePedido()
                    {
                        id_pedido = (string)dr[0],
                        id_platillo = (int)dr[1],
                        cantidad = (int)dr[2],
                        precioVenta = (decimal)dr[3],
                        importe = (decimal)dr[4],
                        });
                    }
                }
                catch (Exception ex) { listaDetallePedido = null; Debug.WriteLine("Error: " + ex.Message); }
                finally { conexion.Close(); }
            }
            return _mapper.Map<List<DetallePedidoDto>>(listaDetallePedido);
        }

        public async Task<List<DetallePedidoDto>> BuscarDetallePedidoPorIdPedido(string id_pedido)//, int id_platillo)
        {
            return listarDetallePedidos().Result.Where(x => x.id_pedido == id_pedido).ToList();
        }

        public async Task<string> ActualizarDetallePedido(DetallePedidoDto detallePedido)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_actualizarDetallePedido ", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_pedido", detallePedido.id_pedido);
                    cmd.Parameters.AddWithValue("@old_idplatillo", detallePedido.old_idplatillo);
                    cmd.Parameters.AddWithValue("@new_idplatillo", detallePedido.new_idplatillo);
                    cmd.Parameters.AddWithValue("@cantidad", detallePedido.cantidad);
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

        public async Task<DetallePedidoDto> BuscarDetallePedidoPorIdPedidoIdPlatillo(string id_pedido, int? id_platillo)
        {
            DetallePedidoDto? detallePedido = listarDetallePedidos().Result.Where(dp => dp.id_pedido.Equals(id_pedido) &&
                                                                                        dp.id_platillo.Equals(id_platillo)).FirstOrDefault();
            return detallePedido;
        }
    }
}

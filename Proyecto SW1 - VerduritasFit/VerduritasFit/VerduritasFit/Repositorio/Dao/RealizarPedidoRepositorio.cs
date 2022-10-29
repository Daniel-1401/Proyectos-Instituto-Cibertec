using AutoMapper;

using Microsoft.Data.SqlClient;

using System.Data;

using VerduritasFit.Data;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Repositorio.Dao
{
    public class RealizarPedidoRepositorio: IRealizarPedidoRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;

        public RealizarPedidoRepositorio(IMapper mapper)
        {
            _mapper = mapper;
            _conexion = new Conexion();
        }

        public async Task<string> insertarPedido(RealizarPedidoDto pedidoDto)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                SqlTransaction tran = conexion.BeginTransaction(IsolationLevel.Serializable);
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_insertarCabeceraPedido ", conexion, tran);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.Add("@id_pedido", SqlDbType.VarChar, 5).Direction = ParameterDirection.Output;
                    cmd.Parameters.AddWithValue("@fechaPedido", pedidoDto.CabeceraPedido.fechaPedido);
                    cmd.Parameters.AddWithValue("@fechaEntrega", pedidoDto.CabeceraPedido.fechaEntrega);
                    cmd.Parameters.AddWithValue("@id_cliente", pedidoDto.CabeceraPedido.id_cliente);
                    cmd.Parameters.AddWithValue("@totalBoleta", pedidoDto.CabeceraPedido.total_bol);
                    int success1 = cmd.ExecuteNonQuery();
                    if(success1 == 1)
                    {
                        string id_pedido = cmd.Parameters["@id_pedido"].Value.ToString();

                        foreach (DetallePedidoDto detallePedido in pedidoDto.DetallePedido)
                        {
                            cmd = new SqlCommand("usp_insertarDetallePedido", conexion, tran);
                            cmd.CommandType = CommandType.StoredProcedure;
                            cmd.Parameters.AddWithValue("@id_pedido", id_pedido);
                            cmd.Parameters.AddWithValue("@id_platillo", detallePedido.id_platillo);
                            cmd.Parameters.AddWithValue("@cantidad", detallePedido.cantidad);
                            cmd.Parameters.AddWithValue("@precioVenta", detallePedido.precioVenta);
                            int success2 = cmd.ExecuteNonQuery();
                            if (success2 == 0)
                            {
                                mensaje = "ErrorInsertarDetallePedido";
                                conexion.Close();
                                tran.Rollback();
                                return mensaje;
                            }
                        }
                        tran.Commit();
                        mensaje = "success";
                    }
                    else
                    {
                        mensaje = "ErrorInsertarCabeceraPedido";
                        conexion.Close();
                        tran.Rollback();
                        return mensaje;
                    }
                }
                catch (Exception ex) { mensaje = ex.Message; tran.Rollback(); }
                finally { conexion.Close();}
            }
            return mensaje;
        }
    }
}

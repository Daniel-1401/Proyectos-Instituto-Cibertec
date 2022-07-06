using AutoMapper;
using VerduritasFit.Repositorio.IDao;
using VerduritasFit.Data;
using Microsoft.Data.SqlClient;
using System.Data;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using System.Diagnostics;
using System.Collections.Generic;

namespace VerduritasFit.Repositorio.Dao
{
    public class CabeceraPedidoRepositorio : ICabeceraPedidoRepositorio
    {
        private IMapper _mapper;
        private readonly Conexion _conexion;
        private IClienteRepositorio _clienteRepositorio;
        private IDetallePedidoRepositorio _detallePedidoRepositorio;

        public CabeceraPedidoRepositorio(IMapper mapper, IClienteRepositorio clienteRepositorio, IDetallePedidoRepositorio detallePedidoRepositorio)
        {
            _mapper = mapper;
            _conexion = new Conexion();
            _clienteRepositorio = clienteRepositorio;
            _detallePedidoRepositorio = detallePedidoRepositorio;
        }

        public async Task<List<CabeceraPedidoDto>> listarCabeceraPedido()
        {
            List<CabeceraPedido>? listaCabeceraPedido = new List<CabeceraPedido>();
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_listarCabeceraPedidos", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    SqlDataReader dr = cmd.ExecuteReader();
                    while (dr.Read())
                    {
                        listaCabeceraPedido.Add(new CabeceraPedido()
                        {
                            id_pedido = (string)dr[0],
                            fechaPedido = (DateTime)dr[1],
                            fechaEntrega = (DateTime)dr[2],
                            id_cliente = (string)dr[3],
                            total_bol = (decimal)dr[4],
                        });
                    }
                }
                catch (Exception ex) { listaCabeceraPedido = null; Debug.WriteLine("Error: " + ex.Message); }
                finally { conexion.Close(); }
            }
            return _mapper.Map<List<CabeceraPedidoDto>>(listaCabeceraPedido);
        }

        public async Task<CabeceraPedidoDto> BuscarCabeceraPedidoPorId(string codigo)
        {
            return listarCabeceraPedido().Result.FirstOrDefault(cp => cp.id_pedido.Equals(codigo));
        }

        public async Task<List<CabeceraPedidoDto>> BuscarCabeceraPedidoPorIdCliente(string id_cliente)
        {
            List<CabeceraPedidoDto> listaCabeceraPedido = listarCabeceraPedido().Result.Where(cp => cp.id_cliente.Equals(id_cliente)).ToList();
            return listaCabeceraPedido;
        }

        public async Task<string> actualizarCabeceraPedido(CabeceraPedidoDto cabeceraPedido)
        {
            string mensaje = "";
            using (SqlConnection conexion = _conexion.getcn)
            {
                conexion.Open();
                try
                {
                    SqlCommand cmd = new SqlCommand("usp_actualizaCabeceraPedido ", conexion);
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.AddWithValue("@id_pedido", cabeceraPedido.id_pedido);
                    cmd.Parameters.AddWithValue("@fechaPedido", cabeceraPedido.fechaPedido);
                    cmd.Parameters.AddWithValue("@fechaEntrega", cabeceraPedido.fechaEntrega);
                    cmd.Parameters.AddWithValue("@totalBoleta", cabeceraPedido.total_bol);
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

        public async Task<List<CabeceraPedidoDto>> listarCabeceraPedidoCompleto()
        {
            List<ClienteDto> listaClientes = await _clienteRepositorio.listarCliente();
            List<CabeceraPedidoDto> listaCabeceraPedido = await listarCabeceraPedido();
            List<DetallePedidoDto> listaDetallePedido = await _detallePedidoRepositorio.listarDetallePedidos();

            var lista = from cabeceraPedido in listaCabeceraPedido
                        join cliente in listaClientes
                        on cabeceraPedido.id_cliente equals cliente.id_cliente
                        select new { cabeceraPedido, cliente };

            List<CabeceraPedidoDto> listaCabeceraConCliente = new List<CabeceraPedidoDto>();

            foreach (var cabeceraPedido in lista)
            {
                listaCabeceraConCliente.Add(new CabeceraPedidoDto()
                {
                    id_pedido = cabeceraPedido.cabeceraPedido.id_pedido,
                    fechaPedido = cabeceraPedido.cabeceraPedido.fechaPedido,
                    fechaEntrega = cabeceraPedido.cabeceraPedido.fechaEntrega,
                    id_cliente = cabeceraPedido.cabeceraPedido.id_cliente,
                    total_bol = cabeceraPedido.cabeceraPedido.total_bol,
                    cliente = cabeceraPedido.cliente
                });
            }

            var lista2 = from cabeceraPedido in lista
                         join detallePedido in listaDetallePedido
                         on cabeceraPedido.cabeceraPedido.id_pedido equals detallePedido.id_pedido
                         select new { cabeceraPedido, detallePedido };

            var lista3 = lista2.GroupBy(x => x.cabeceraPedido).ToList();

            var joinlst = listaCabeceraPedido.GroupJoin(listaDetallePedido,
                                                   cabeceraPedido => cabeceraPedido.id_pedido,
                                                   detallePedido => detallePedido.id_pedido,
                                                   (cabeceraPedido, detallePedido) => cabeceraPedido);

            return listaCabeceraConCliente;
        }
    }
}

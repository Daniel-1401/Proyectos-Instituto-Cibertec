using Azure;

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Data.SqlClient;
using System.Data;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.Dao;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize]
    public class DetallePedidoController : ControllerBase
    {

        private IDetallePedidoRepositorio _detallePedidoRepositorio;
        protected ResponseDto _response;

        public DetallePedidoController(IDetallePedidoRepositorio detallepedidoRepositorio)
        {
            _detallePedidoRepositorio = detallepedidoRepositorio;
            _response = new ResponseDto();
        }


        [HttpGet]
        [Route("listarDetallesPedidos")]
        public async Task<ActionResult<List<DetallePedidoDto>>> listarDetallesPedidos()
        {
            try
            {
                List<DetallePedidoDto> listadetallePedido = await _detallePedidoRepositorio.listarDetallePedidos();
                if (listadetallePedido.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listadetallePedido;
                    _response.DisplayMessage = "Lista de detalle pedido es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listadetallePedido;
                    _response.DisplayMessage = "Lista de detalle Pedido";
                    return Ok(_response);
                }
            }
            catch (Exception ex)
            {
                _response.IsSuccess = false;
                _response.ErrorMessages = new List<string> { ex.Message };
                return BadRequest(_response);
            }
        }

        [HttpGet]
        [Route("BuscarDetallePedidoPorIdPedido/{id_pedido}")]
        public async Task<ActionResult<List<DetallePedidoDto>>> BuscarDetallePedidoPorIdPedido(string id_pedido)
        {
            try
            {
                List<DetallePedidoDto> listadetallepedido = await _detallePedidoRepositorio.BuscarDetallePedidoPorIdPedido(id_pedido);
                if(listadetallepedido.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listadetallepedido;
                    _response.DisplayMessage = "Lista de cabecera pedido es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listadetallepedido;
                    _response.DisplayMessage = "Lista de detalle pedido";
                    return Ok(_response);
                }
            }
            catch (Exception ex)
            {
                _response.IsSuccess = false;
                _response.ErrorMessages = new List<string> { ex.Message };
                return BadRequest(_response);
            }
        }

        [HttpGet]
        [Route("BuscarDetallePedidoPorIdPedidoIdPlatillo")]
        public async Task<ActionResult<DetallePedidoDto>> BuscarDetallePedidoPorIdPedidoIdPlatillo(string id_pedido, int id_platillo)
        {
            try
            {
                DetallePedidoDto listadetallepedido = await _detallePedidoRepositorio.BuscarDetallePedidoPorIdPedidoIdPlatillo(id_pedido, id_platillo);
                if (listadetallepedido == null)
                {
                    _response.IsSuccess = true;
                    _response.Result = listadetallepedido;
                    _response.DisplayMessage = "Lista de cabecera pedido es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listadetallepedido;
                    _response.DisplayMessage = "Lista de detalle pedido";
                    return Ok(_response);
                }
            }
            catch (Exception ex)
            {
                _response.IsSuccess = false;
                _response.ErrorMessages = new List<string> { ex.Message };
                return BadRequest(_response);
            }
        }

        [HttpPut]
        [Route("actualizarDetallePedido")]
        public async Task<ActionResult<DetallePedidoDto>> actualizarDetallePedido(DetallePedidoDto detallePedido)
        {
            try
            {
                string actualizado = await _detallePedidoRepositorio.ActualizarDetallePedido(detallePedido);
                if (actualizado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Detalle Pedido actualizado";
                    return Ok(_response);
                }
                else if (actualizado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al actualizar Detalle Pedido";
                    return BadRequest(_response);
                }
                else
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = actualizado;
                    return BadRequest(_response);
                }
            }
            catch (Exception ex)
            {
                _response.IsSuccess = false;
                _response.ErrorMessages = new List<string> { ex.Message };
                return BadRequest(_response);
            }
        }


    }
}
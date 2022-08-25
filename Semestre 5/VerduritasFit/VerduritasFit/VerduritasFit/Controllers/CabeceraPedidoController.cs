using Microsoft.AspNetCore.Mvc;

using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    //[Authorize]
    public class CabeceraPedidoController : ControllerBase
    {
        private readonly ICabeceraPedidoRepositorio _cabeceraPedidoRepositoripo;
        protected ResponseDto _response;

        public CabeceraPedidoController(ICabeceraPedidoRepositorio cabeceraPedidoRepositorio)
        {
            _cabeceraPedidoRepositoripo = cabeceraPedidoRepositorio;
            _response = new ResponseDto();
        }

        [HttpGet]
        [Route("listarCabecerasPedido")]
        public async Task<ActionResult<List<CabeceraPedidoDto>>> listarCabecerasPedido()
        {
            try
            {
                List<CabeceraPedidoDto> listaCabeceraPedido = await _cabeceraPedidoRepositoripo.listarCabeceraPedido();
                if (listaCabeceraPedido.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listaCabeceraPedido;
                    _response.DisplayMessage = "Lista de cabecera pedido es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaCabeceraPedido;
                    _response.DisplayMessage = "Lista de Cabeceras Pedido";
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
        [Route("BuscarCabeceraPedidoPorId/{codigo}")]
        public async Task<ActionResult> BuscarCabeceraPedidoPorId(string codigo)
        {
            try
            {
                CabeceraPedidoDto cabeceraPedido = await _cabeceraPedidoRepositoripo.BuscarCabeceraPedidoPorId(codigo);
                if (cabeceraPedido == null)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Cabecera Pedido no existe";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = cabeceraPedido;
                    _response.DisplayMessage = "Cabecera Pedido";
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
        [Route("BuscarCabeceraPedidoPorIdCliente/{id_cliente}")]
        public async Task<ActionResult> BuscarCabeceraPedidoPorIdCliente(string id_cliente)
        {
            try
            {
                List<CabeceraPedidoDto> cabeceraPedido = await _cabeceraPedidoRepositoripo.BuscarCabeceraPedidoPorIdCliente(id_cliente);
                if (cabeceraPedido == null)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Cabecera Pedido no existe";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = cabeceraPedido;
                    _response.DisplayMessage = "Cabecera Pedido";
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
        [Route("actualizarCabeceraPedido")]
        public async Task<ActionResult> actualizarCabeceraPedido(CabeceraPedidoDto cabeceraPedido)
        {
            try
            {
                string actualizado = await _cabeceraPedidoRepositoripo.actualizarCabeceraPedido(cabeceraPedido);
                if (actualizado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Cabecera Pedido actualizado";
                    return Ok(_response);
                }
                else if (actualizado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al actualizar Cabecera Pedido";
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
        
        [HttpGet]
        [Route("listarCabeceraPedidoCompleto")]
        public async Task<ActionResult<List<CabeceraPedidoDto>>> listarCabeceraPedidoCompleto()
        {
            try
            {
                List<CabeceraPedidoDto> listaCabeceraPedido = await _cabeceraPedidoRepositoripo.listarCabeceraPedidoCompleto();
                if (listaCabeceraPedido.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listaCabeceraPedido;
                    _response.DisplayMessage = "Lista de cabecera pedido es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaCabeceraPedido;
                    _response.DisplayMessage = "Lista de Cabeceras Pedido";
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
    }
}

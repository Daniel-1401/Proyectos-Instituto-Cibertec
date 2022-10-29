using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.Dao;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    //[Authorize]
    public class RealizarPedidoController : ControllerBase
    {
        private readonly IRealizarPedidoRepositorio _realizarPedidoRepositorio;
        protected ResponseDto _response;

        public RealizarPedidoController(IRealizarPedidoRepositorio realizarPedidoRepositorio)
        {
            _realizarPedidoRepositorio = realizarPedidoRepositorio;
            _response = new ResponseDto();
        }

        [HttpPost]
        [Route("insertarPedido")]
        public async Task<ActionResult<string>> insertarPedido(RealizarPedidoDto realizarPedido)
        {
            try
            {
                string eliminado = await _realizarPedidoRepositorio.insertarPedido(realizarPedido);
                if (eliminado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Cliente insertado";
                    return Ok(_response);
                }
                else if (eliminado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al insertar";
                    return BadRequest(_response);
                }
                else
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = eliminado;
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

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.Dao;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize]
    public class ClienteController : ControllerBase
    {
        private readonly IClienteRepositorio _clienteRepositorio;
        protected ResponseDto _response;

        public ClienteController(IClienteRepositorio clienteRepositorio)
        {
            _clienteRepositorio = clienteRepositorio;
            _response = new ResponseDto();
        }

        [HttpGet]
        [Route("listarClientes")]
        public async Task<ActionResult<List<ClienteDto>>> listarClientes()
        {
            try
            {
                List<ClienteDto> listaCliente = await _clienteRepositorio.listarCliente();
                if (listaCliente.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listaCliente;
                    _response.DisplayMessage = "Lista de clientes vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaCliente;
                    _response.DisplayMessage = "Lista de Clientes";
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
        [Route("buscarClientePorUsername/{username}")]
        public async Task<ActionResult<ClienteDto>> buscarClientePorUsername(string username)
        {
            try
            {
                ClienteDto Cliente = await _clienteRepositorio.buscarClientePorUsername(username);
                if (Cliente == null)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Clientes no existe";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = Cliente;
                    _response.DisplayMessage = "Cliente";
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

        [HttpPost]
        [Route("insertarCliente")]
        public async Task<ActionResult<string>> insertarCliente(ClienteDto cliente)
        {
            try
            {
                string insertar = await _clienteRepositorio.insertarCliente(cliente);
                if (insertar == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Cliente insertado";
                    return Ok(_response);
                }
                else if (insertar == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al insertar";
                    return BadRequest(_response);
                }
                else
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = insertar;
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

        [HttpPut]
        [Route("actualizarCliente")]
        public async Task<ActionResult<string>> actualizarCliente(ClienteDto cliente)
        {
            try
            {
                string actualizado = await _clienteRepositorio.actualizarObjetivo(cliente);
                if (actualizado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Cliente actualizado";
                    return Ok(_response);
                }
                else if (actualizado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al actualizar";
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

        [HttpDelete]
        [Route("desactivarCliente/{idCliente}")]
        public async Task<ActionResult<string>> desactivarCliente(string idCliente)
        {
            try
            {
                string eliminado = await _clienteRepositorio.desactivarCliente(idCliente);
                if (eliminado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Cliente desactivado";
                    return Ok(_response);
                }
                else if (eliminado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al desactivar cliente";
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

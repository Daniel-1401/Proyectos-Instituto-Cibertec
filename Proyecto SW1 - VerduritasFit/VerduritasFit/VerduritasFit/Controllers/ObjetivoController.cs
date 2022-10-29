using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

using System.Collections.Generic;

using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.IDao;

namespace VerduritasFit.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    //[Authorize]
    public class ObjetivoController : ControllerBase
    {
        private readonly IObjetivoRepositorio _objetivoRepositorio;
        protected ResponseDto _response;

        public ObjetivoController(IObjetivoRepositorio objetivoRepositorio)
        {
            _objetivoRepositorio = objetivoRepositorio;
            _response = new ResponseDto();
        }

        [HttpGet]
        [Route("listarObjetivos")]
        public async Task<ActionResult<List<ObjetivoDto>>> listarObjetivos()
        {
            try
            {
                List<ObjetivoDto> listaObjetivo = await _objetivoRepositorio.listarObjetivos();
                if (listaObjetivo.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Lista de Objetivos vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaObjetivo;
                    _response.DisplayMessage = "Lista de Objetivos";
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
        [Route("buscarObjetivoPorId/{id_objetivo}")]
        public async Task<ActionResult<ObjetivoDto>> buscarObjetivoPorId(int id_objetivo)
        {
            try
            {
                var Objetivo = await _objetivoRepositorio.buscarObjetivoPorId(id_objetivo);
                if (Objetivo == null)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Objetivo no existe";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = Objetivo;
                    _response.DisplayMessage = "Objetivos";
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
        [Route("insertarObjetivo")]
        public async Task<ActionResult<string>> insertarObjetivo(ObjetivoDto objetivo)
        {
            try
            {
                string insertado = await _objetivoRepositorio.insertarObjetivo(objetivo.DecripcionObjetivo);
                if(insertado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Objetivo insertado";
                    return Ok(_response);
                }
                else if(insertado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al insertar Objetivo";
                    return BadRequest(_response);
                }
                else
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = insertado;
                    return BadRequest(_response);
                }
            }
            catch(Exception ex)
            {
                _response.IsSuccess = false;
                _response.ErrorMessages= new List<string> { ex.Message };
                return BadRequest(_response);
            }
        }

        [HttpPut]
        [Route("actualizarObjetivo")]
        public async Task<ActionResult<string>> actualizarObjetivo(ObjetivoDto objetivo)
        {
            try
            {
                string actualizado = await _objetivoRepositorio.actualizarObjetivo(objetivo);
                if (actualizado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Objetivo actualizado";
                    return Ok(_response);
                }
                else if (actualizado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al actulizar";
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
        [Route("eliminarObjetivo")]
        public async Task<ActionResult<string>> eliminarObjetivo(int id_objetivo)
        {
            try
            {
                string eliminado = await _objetivoRepositorio.eliminarObjetivo(id_objetivo);
                if (eliminado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Objetivo eliminado";
                    return Ok(_response);
                }
                else if (eliminado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al eliminar";
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

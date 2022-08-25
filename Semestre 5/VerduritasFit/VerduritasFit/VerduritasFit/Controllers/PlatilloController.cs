using Microsoft.AspNetCore.Authorization;
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
    public class PlatilloController : ControllerBase
    {
        private IPlatilloRepositorio _platilloRepositorio;
        private IImagenRepositorio _imagenRepositorio;
        protected ResponseDto _response;

        public PlatilloController(IPlatilloRepositorio platilloRepositorio, IImagenRepositorio imagenRepositorio)
        {
            _platilloRepositorio = platilloRepositorio;
            _imagenRepositorio = imagenRepositorio;
            _response = new ResponseDto();
        }

        [HttpGet]
        [Route("listarPlatillos")]
        public async Task<ActionResult<List<PlatilloDto>>> listarPlatillos()
        {
            try
            {
                List<PlatilloDto> listaPlatillos = await _platilloRepositorio.listarPlatillos();
                if (listaPlatillos.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listaPlatillos;
                    _response.DisplayMessage = "Lista de categoria es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaPlatillos;
                    _response.DisplayMessage = "Lista de Categoria";
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
        [Route("buscarPlatilloPorId/{id_platillo}")]
        public async Task<ActionResult<PlatilloDto>> buscarPlatilloPorId(int id_platillo)
        {
            try
            {
                PlatilloDto Platillo = await _platilloRepositorio.buscarPlatilloPorId(id_platillo);
                if (Platillo == null)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Categoria no existe";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = Platillo;
                    _response.DisplayMessage = "Categoria";
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
        [Route("insertarPlatillo")]
        public async Task<ActionResult<string>> insertarPlatillo(PlatilloDto platillo)
        {
            try
            {
                string insertado = await _platilloRepositorio.insertarPlatillo(platillo);
                if (insertado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Platillo insertado";
                    return Ok(_response);
                }
                else if (insertado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al insertar Platillo";
                    return BadRequest(_response);
                }
                else
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = insertado;
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
        [Route("actualizarPlatillo")]
        public async Task<ActionResult<string>> actualizarPlatillo(PlatilloDto platillo)
        {
            try
            {
                string actualizado = await _platilloRepositorio.actualizarPlatillo(platillo);
                if (actualizado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Platillo actualizada";
                    return Ok(_response);
                }
                else if (actualizado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al actulizar platillo";
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
        [Route("eliminarPlatillo")]
        public async Task<ActionResult<string>> eliminarPlatillo(int id_platillo)
        {
            try
            {
                string eliminado = await _platilloRepositorio.eliminarPlatillo(id_platillo);
                if (eliminado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Platillo eliminado";
                    return Ok(_response);
                }
                else if (eliminado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al eliminar platillo";
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

        [HttpGet]
        [Route("listarImagenes")]
        public async Task<ActionResult<List<ImagenDto>>> listarImagenes()
        {
            try
            {
                List<ImagenDto> listaImagenes = await _imagenRepositorio.listarImagenes();
                if (listaImagenes.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listaImagenes;
                    _response.DisplayMessage = "Lista de imagenes es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaImagenes;
                    _response.DisplayMessage = "Lista de Imagenes";
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
        [Route("buscarImagenesPorIdPlatillo/{id_platillo}")]
        public async Task<ActionResult<List<ImagenDto>>> listarbuscarImagenesPorIdPlatilloImagenes(int id_platillo)
        {
            try
            {
                List<ImagenDto> listaImagenes = await _imagenRepositorio.buscarImagenesPorIdPlatillo(id_platillo);
                if (listaImagenes.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listaImagenes;
                    _response.DisplayMessage = "Lista de imagenes es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaImagenes;
                    _response.DisplayMessage = "Lista de Imagenes";
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
        [Route("buscarImagenesPorIdPlatilloIdImagen")]
        public async Task<ActionResult<ImagenDto>> buscarImagenesPorIdPlatilloIdImagen(int id_platillo, string id_imagen)
        {
            try
            {
                ImagenDto objImagen = await _imagenRepositorio.buscarImagenesPorIdPlatilloIdImagen(id_platillo, id_imagen);
                if (objImagen == null)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Imagen no existe";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = objImagen;
                    _response.DisplayMessage = "Imagen";
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
        [Route("insertarImagen")]
        public async Task<ActionResult<string>> insertarImagen(ImagenDto imagen)
        {
            try
            {
                string insertado = await _imagenRepositorio.insertarImagen(imagen);
                if (insertado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Imagen insertado";
                    return Ok(_response);
                }
                else if (insertado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al insertar Imagen";
                    return BadRequest(_response);
                }
                else
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = insertado;
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
        [Route("actualizarImagen")]
        public async Task<ActionResult<string>> actualizarImagen(ImagenDto imagen)
        {
            try
            {
                string actualizado = await _imagenRepositorio.actualizarImagen(imagen);
                if (actualizado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Imagen actualizada";
                    return Ok(_response);
                }
                else if (actualizado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al actulizar imagen";
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
        [Route("eliminarImagen")]
        public async Task<ActionResult<string>> eliminarImagen(ImagenDto imagen)
        {
            try
            {
                string eliminado = await _imagenRepositorio.eliminarImagen(imagen);
                if (eliminado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Platillo eliminado";
                    return Ok(_response);
                }
                else if (eliminado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al eliminar platillo";
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

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
    [Authorize]
    public class CategoriaController : ControllerBase
    {
        private ICategoriaRepositorio _categoriaRepositorio;
        protected ResponseDto _response;

        public CategoriaController(ICategoriaRepositorio categoriaRepositorio)
        {
            _categoriaRepositorio = categoriaRepositorio;
            _response = new ResponseDto();
        }
        

        [HttpGet]
        [Route("listarCategorias")]
        public async Task<ActionResult<List<CategoriaDto>>> listarCategorias()
        {
            try
            {
                List<CategoriaDto> listaCategorias = await _categoriaRepositorio.listarCategorias();
                if (listaCategorias.Count == 0)
                {
                    _response.IsSuccess = true;
                    _response.Result = listaCategorias;
                    _response.DisplayMessage = "Lista de categoria es vacia";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = listaCategorias;
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
        [Route("buscarCategoriaPorId/{id_categoria}")]
        public async Task<ActionResult<CategoriaDto>> buscarCategoriaPorId(int id_categoria)
        {
            try
            {
                CategoriaDto Categoria = await _categoriaRepositorio.buscarCategoriaPorId(id_categoria);
                if (Categoria == null)
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Categoria no existe";
                    return Ok(_response);
                }
                else
                {
                    _response.Result = Categoria;
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
        [Route("insertarCategoria")]
        public async Task<ActionResult<string>> insertarCategoria(CategoriaDto categoria)
        {
            try
            {
                string insertado = await _categoriaRepositorio.insertarCategoria(categoria.nombre_categoria);
                if (insertado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Categoria insertado";
                    return Ok(_response);
                }
                else if (insertado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al insertar Categoria";
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
        [Route("actualizarCategoria")]
        public async Task<ActionResult<string>> actualizarCategoria(CategoriaDto categoria)
        {
            try
            {
                string actualizado = await _categoriaRepositorio.actualizarCategoria(categoria);
                if (actualizado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Categoria actualizada";
                    return Ok(_response);
                }
                else if (actualizado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al actulizar categoria";
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
        [Route("eliminarCategoria/{id_categoria}")]
        public async Task<ActionResult<string>> eliminarCategoria(int id_categoria)
        {
            try
            {
                string eliminado = await _categoriaRepositorio.eliminarCategoria(id_categoria);
                if (eliminado == "success")
                {
                    _response.IsSuccess = true;
                    _response.DisplayMessage = "Categoria eliminado";
                    return Ok(_response);
                }
                else if (eliminado == "errorsql")
                {
                    _response.IsSuccess = false;
                    _response.DisplayMessage = "Error al eliminar categoria";
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

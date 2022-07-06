using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
using VerduritasFit.Repositorio.Dao;
using VerduritasFit.Repositorio.IDao;
using Microsoft.AspNetCore.Authorization;

namespace VerduritasFit.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize]
    public class UserController : ControllerBase
    {
        private readonly IUserRepositorio _userRepositorio;
        protected ResponseDto _response;

        public UserController(IUserRepositorio userRepositorio)
        {
            _userRepositorio = userRepositorio;
            _response = new ResponseDto();
        }

        [HttpPost("Register")]
        [AllowAnonymous]
        public async Task<ActionResult> Register(UsuarioDto usuario)
        {
            var respuesta = await _userRepositorio.Register(usuario);
            if (respuesta == "existe")
            {
                _response.IsSuccess = false;
                _response.DisplayMessage = "Usuario ya existe";
                return BadRequest(_response);
            }
            if (respuesta == "error")
            {
                _response.IsSuccess = false;
                _response.DisplayMessage = "Error al Crear el Usuario";
                return BadRequest(_response);
            }
            _response.DisplayMessage = "Usuario Creado con Exito!";
            JwTPackage jtp = new JwTPackage();
            jtp.UserName = usuario.userName;
            jtp.Token = respuesta;
            _response.Result = jtp;
            return Ok(_response);
        }

        [HttpPost("Login")]
        [AllowAnonymous]
        public async Task<ActionResult> Login(UsuarioDto user)
        {
            var respuesta = await _userRepositorio.Login(user.userName, user.clave);

            if (respuesta == "noinicio")
            {
                _response.IsSuccess = false;
                _response.DisplayMessage = "Error con el usuario o contraseña";
                return BadRequest(_response);
            }
            JwTPackage jtp = new JwTPackage();
            jtp.UserName = user.userName;
            jtp.Token = respuesta;
            _response.Result = jtp;
            _response.DisplayMessage = "Usuario Conectado";
            return Ok(_response);
        }

        [HttpPut("actualizarContraseña")]
        public async Task<ActionResult> actualizarContraseña(NewPasswordDto user)
        {
            var respuesta = await _userRepositorio.ActualizarPassword(user.user_name, user.OldPassword, user.NewPassword);

            if (respuesta == "nocoincide")
            {
                _response.IsSuccess = false;
                _response.DisplayMessage = "Error con el usuario o contraseña";
                return BadRequest(_response);
            }
            else if(respuesta == "succes")
            {
                _response.DisplayMessage = "Contraseña actualizado con exito!";
                _response.Result = respuesta;
                return Ok(_response);
            }
            else
            {
                _response.IsSuccess = false;
                _response.DisplayMessage = respuesta;
                return BadRequest(_response);
            }
            
        }
    }
    public class JwTPackage
    {
        public string UserName { get; set; }
        public string Token { get; set; }
    }
}

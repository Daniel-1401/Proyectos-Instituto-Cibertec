using VerduritasFit.Models.Dto;

namespace VerduritasFit.Repositorio.IDao
{
    public interface IUserRepositorio
    {
        Task<string> Register(UsuarioDto usuario);
        Task<string> Login(string userName, string password);
        Task<string> ActualizarPassword(string username, string oldPassword, string newPassword);
    }
}

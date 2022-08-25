using VerduritasFit.Models.Dto;

namespace VerduritasFit.Repositorio.IDao
{
    public interface IPlatilloRepositorio
    {
        Task<List<PlatilloDto>> listarPlatillos();
        Task<PlatilloDto> buscarPlatilloPorId(int id_platillo);
        Task<string> insertarPlatillo(PlatilloDto platillo);
        Task<string> actualizarPlatillo(PlatilloDto platillo);
        Task<string> eliminarPlatillo(int id_platillo);
    }
}

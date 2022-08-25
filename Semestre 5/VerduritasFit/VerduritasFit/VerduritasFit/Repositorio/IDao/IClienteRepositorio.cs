using VerduritasFit.Models.Dto;

namespace VerduritasFit.Repositorio.IDao
{
    public interface IClienteRepositorio
    {
        Task<List<ClienteDto>> listarCliente();
        Task<ClienteDto> buscarClientePorUsername(string username);
        Task<string> insertarCliente(ClienteDto cliente);
        Task<string> desactivarCliente(string id_Cliente);
        Task<string> actualizarObjetivo(ClienteDto cliente);
    }
}

using VerduritasFit.Models.Dto;

namespace VerduritasFit.Repositorio.IDao
{
    public interface IRealizarPedidoRepositorio
    {
        Task<string> insertarPedido(RealizarPedidoDto pedidoDto);
    }
}

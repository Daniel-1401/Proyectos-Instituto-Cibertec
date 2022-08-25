using VerduritasFit.Models.Dto;
namespace VerduritasFit.Repositorio.IDao
{
    public interface ICabeceraPedidoRepositorio
    {
        Task<List<CabeceraPedidoDto>> listarCabeceraPedido();
        Task<List<CabeceraPedidoDto>> listarCabeceraPedidoCompleto();
        Task<CabeceraPedidoDto> BuscarCabeceraPedidoPorId(string codigo);
        Task<List<CabeceraPedidoDto>> BuscarCabeceraPedidoPorIdCliente(string id_cliente);
        Task<string> actualizarCabeceraPedido(CabeceraPedidoDto cabeceraPedido);
    }
}

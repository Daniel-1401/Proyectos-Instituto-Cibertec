using VerduritasFit.Models;
using VerduritasFit.Models.Dto;
namespace VerduritasFit.Repositorio.IDao
{
    public interface IDetallePedidoRepositorio
    {
        Task<List<DetallePedidoDto>> listarDetallePedidos();
        Task<List<DetallePedidoDto>> BuscarDetallePedidoPorIdPedido(string id_pedido);//, int id_platillo);
        Task<DetallePedidoDto> BuscarDetallePedidoPorIdPedidoIdPlatillo(string id_pedido, int? id_platillo);

        Task<string> ActualizarDetallePedido(DetallePedidoDto detallePedido);
    }


}

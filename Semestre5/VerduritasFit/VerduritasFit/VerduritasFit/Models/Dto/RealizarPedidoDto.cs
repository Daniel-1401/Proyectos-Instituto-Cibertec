namespace VerduritasFit.Models.Dto
{
    public class RealizarPedidoDto
    {
        public CabeceraPedidoDto CabeceraPedido { get; set; }

        public ICollection<DetallePedidoDto> DetallePedido { get; set; }
    }
}

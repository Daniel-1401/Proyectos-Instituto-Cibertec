namespace VerduritasFit.Models.Dto
{
    public class CabeceraPedidoDto
    {
        public string id_pedido { get; set; }
        public DateTime? fechaPedido { get; set; }
        public DateTime? fechaEntrega { get; set; }
        public string? id_cliente { get; set; }
        public decimal? total_bol { get; set; }
        public ClienteDto? cliente { get; set; }
        public ICollection<DetallePedidoDto>? DetallePedido { get; set; }
    }
}

namespace VerduritasFit.Models.Dto
{
    public class DetallePedidoDto
    {
        public string id_pedido { get; set; }
        public int? id_platillo { get; set; }
        public PlatilloDto? platillo { get; set; }
        public int? cantidad { get; set; }
        public decimal? precioVenta { get; set; }
        public decimal? importe { get; set; }
        public int? old_idplatillo { get; set; }
        public int? new_idplatillo { get; set; }
    }
}

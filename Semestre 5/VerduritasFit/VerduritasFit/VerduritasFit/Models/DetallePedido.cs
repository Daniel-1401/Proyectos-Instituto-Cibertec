using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class DetallePedido
    {
        [Required, Display(Name = "ID del pedido")]
        public string id_pedido { get; set; }

        [Required, Display(Name = "ID del plato")]
        public int id_platillo { get; set; }

        [Required, Display(Name = "Cantidad del plato")]
        public int cantidad { get; set; }

        [Required, Display(Name = "Precio de venta")]
        public decimal precioVenta { get; set; }

        [Required, Display(Name = "Importe")]
        public decimal importe { get; set; }
    }
}

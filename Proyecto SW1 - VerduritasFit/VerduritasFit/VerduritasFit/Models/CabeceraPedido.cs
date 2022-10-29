using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class CabeceraPedido
    {
        [Required(AllowEmptyStrings = true)]
        public string id_pedido { get; set; }

        [Required(AllowEmptyStrings = true)]
        public DateTime fechaPedido { get; set; }
        
        [Required(AllowEmptyStrings = true)]
        public DateTime fechaEntrega { get; set; }

        [Required, Display(Name = "ID del usuario")]
        public string id_cliente { get; set; }

        [Required, Display(Name = "ID del plato")]
        public decimal total_bol { get; set; }
    }
}

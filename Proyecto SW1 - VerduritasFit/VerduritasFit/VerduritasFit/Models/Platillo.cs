using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class Platillo
    {
        [Required(AllowEmptyStrings = true)]
        public int id_platillo { get; set; }

        [Required, Display(Name = "Nombre del plato")]
        public string nombre { get; set; }

        [Required, Display(Name = "Descripcion del plato")]
        public string descripcion { get; set; }

        [Required, Display(Name = "Ingrediente del plato")]
        public string ingrediente { get; set; }

        [Required, Display(Name = "ID de la Categoria")]
        public int id_categoria { get; set; }

        [Required, Display(Name = "Precio del Plato")]
        public decimal precio { get; set; }

        [Required, Display(Name = "Calorias del Plato")]
        public int calorias { get; set; }

        public string imagen { get; set; }

    }
}

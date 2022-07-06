using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class Categoria
    {
        [Required(AllowEmptyStrings = true)]
        public int id_categoria { get; set; }

        [Required, Display(Name = "Nombre de Categoria")]
        public string nombreCategoria { get; set; }
    }
}

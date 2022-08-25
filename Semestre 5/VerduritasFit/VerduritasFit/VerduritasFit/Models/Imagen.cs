using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class Imagen
    {

        [Required, Display(Name = "Id del plato")]
        public int id_platillo { get; set; }

        [Required, Display(Name = "Id de la imagen")]
        public string id_imagen { get; set; }

        public string urlImagen { get; set; }
    }
}

using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class Objetivo
    {
        [Required(AllowEmptyStrings = true)] 
        public int Id_objetivo { get; set; }

        [Required,Display(Name = "Objetivo")]
        public string DecripcionObjetivo { get; set; }
    }
}

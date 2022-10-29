using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class Cliente
    {
        public string id_cliente { get; set; }

        [Required, Display(Name = "Nombre del Cliente es requerido")] 
        public string nombre { get; set; }

        [Required, Display(Name = "Apellido del Cliente es requerido")]
        public string apellido { get; set; }

        [Required, Display(Name = "Fecha de Nacimiento del Cliente es requerido")]
        public DateTime fechaNacimiento { get; set; }

        [Required, Display(Name = "Estatura del Cliente es requerido")]
        public decimal estatura { get; set; }

        [Required, Display(Name = "Peso del Cliente es requerido")]
        public decimal peso { get; set; }

        [Required, Display(Name = "Correo del Cliente es requerido")]
        public string correo { get; set; }

        [Required, Display(Name = "Telefono del Cliente es requerido")]
        public string telefono { get; set; }

        [Required, Display(Name = "Id objetivo del Cliente es requerido")]
        public int id_objetivo { get; set; }
        public string userName { get; set; }
        public bool activo { get; set; }
    }
}

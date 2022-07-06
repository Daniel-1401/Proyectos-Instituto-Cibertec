using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models
{
    public class Usuario
    {

        [Required, Display(Name = "userName del Cliente es requerido")]
        public string userName { get; set; }

        public Byte[] PasswordHash { get; set; }

        public Byte[] PasswordSalt { get; set; }

        [Required(AllowEmptyStrings = true)]
        public int tipo { get; set; }
    }
}

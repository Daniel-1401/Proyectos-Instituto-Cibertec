using System.ComponentModel.DataAnnotations;

namespace VerduritasFit.Models.Dto
{
    public class ClienteDto
    {
        public string? id_cliente { get; set; }
        public string? nombre { get; set; }
        public string? apellido { get; set; }
        public DateTime? fechaNacimiento { get; set; }
        public decimal? estatura { get; set; }
        public decimal? peso { get; set; }
        public string? correo { get; set; }
        public string? telefono { get; set; }
        public int? id_objetivo { get; set; }
        public ObjetivoDto? objetivo { get; set; }
        public bool? activo { get; set; }
        public string? userName { get; set; }
    }
}

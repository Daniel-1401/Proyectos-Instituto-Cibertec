namespace VerduritasFit.Models.Dto
{
    public class PlatilloDto
    {
        public int? id_platillo { get; set; }
        public string? nombre { get; set; }
        public string? descripcion { get; set; }
        public string? ingrediente { get; set; }
        public int? id_categoria { get; set; }
        public CategoriaDto? categoria { get; set; }
        public decimal? precio { get; set; }
        public int? calorias { get; set; }
        public string? Imagen { get; set; }
        public string? id_imagen { get; set; }
        public string? imagen64 { get; set; }
        public string? urlImagen { get; set; }
    }
}

using VerduritasFit.Models.Dto;

namespace VerduritasFit.Repositorio.IDao
{
    public interface IImagenRepositorio
    {
        Task<List<ImagenDto>> listarImagenes();
        Task<List<ImagenDto>> buscarImagenesPorIdPlatillo(int id_platillo);
        Task<ImagenDto> buscarImagenesPorIdPlatilloIdImagen(int id_platillo, string id_imagen);
        Task<string> insertarImagen(ImagenDto imagen);
        Task<string> actualizarImagen(ImagenDto imagen);
        Task<string> eliminarImagen(ImagenDto imagen);
    }
}

using VerduritasFit.Models;
using VerduritasFit.Models.Dto;

namespace VerduritasFit.Repositorio.IDao
{
    public interface ICategoriaRepositorio
    {
        Task<List<CategoriaDto>> listarCategorias();
        Task<CategoriaDto> buscarCategoriaPorId(int id_categoria);
        Task<string> insertarCategoria(string descripcion);
        Task<string> actualizarCategoria(CategoriaDto categoria);
        Task<string> eliminarCategoria(int id_categoria);
    }
}

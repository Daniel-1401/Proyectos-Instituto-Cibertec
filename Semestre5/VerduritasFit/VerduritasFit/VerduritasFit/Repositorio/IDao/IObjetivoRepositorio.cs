using VerduritasFit.Models.Dto;

namespace VerduritasFit.Repositorio.IDao
{
    public interface IObjetivoRepositorio
    {
        Task<List<ObjetivoDto>> listarObjetivos();
        Task<ObjetivoDto> buscarObjetivoPorId(int id_objetivo);
        Task<string> insertarObjetivo(string descripcion);
        Task<string> eliminarObjetivo(int id_objetivo);
        Task<string> actualizarObjetivo(ObjetivoDto objetivo);
    }
}

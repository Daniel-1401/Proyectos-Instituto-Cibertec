using AutoMapper;
using VerduritasFit.Models;
using VerduritasFit.Models.Dto;

namespace VerduritasFit
{
    public class MappingConfig
    {
        public static MapperConfiguration RegisterMaps()
        {
            var mappingConfig = new MapperConfiguration(config =>
            {
                config.CreateMap<CabeceraPedidoDto, CabeceraPedido>();
                config.CreateMap<CabeceraPedido, CabeceraPedidoDto>();

                config.CreateMap<CategoriaDto, Categoria>();
                config.CreateMap<Categoria, CategoriaDto>();

                config.CreateMap<ClienteDto, Cliente>();
                config.CreateMap<Cliente, ClienteDto>();

                config.CreateMap<DetallePedidoDto, DetallePedido>();
                config.CreateMap<DetallePedido, DetallePedidoDto>();

                config.CreateMap<ImagenDto, Imagen>();
                config.CreateMap<Imagen, ImagenDto>();
                
                config.CreateMap<ObjetivoDto, Objetivo>();
                config.CreateMap<Objetivo, ObjetivoDto>();

                config.CreateMap<PlatilloDto, Platillo>();
                config.CreateMap<Platillo, PlatilloDto>();

                config.CreateMap<UsuarioDto, Usuario>();
                config.CreateMap<Usuario, UsuarioDto>();
            });

            return mappingConfig;
        }
    }
}

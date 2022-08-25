using AutoMapper;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.IdentityModel.Tokens;
using Microsoft.OpenApi.Models;

using Swashbuckle.AspNetCore.Filters;

using System.Text;

using VerduritasFit;
using VerduritasFit.Repositorio.Dao;
using VerduritasFit.Repositorio.IDao;

var builder = WebApplication.CreateBuilder(args);


// Add services to the container.
IMapper mapper = MappingConfig.RegisterMaps().CreateMapper();
builder.Services.AddSingleton(mapper);
builder.Services.AddAutoMapper(AppDomain.CurrentDomain.GetAssemblies());

builder.Services.AddControllers();
builder.Services.AddScoped<ICabeceraPedidoRepositorio, CabeceraPedidoRepositorio>();
builder.Services.AddScoped<ICategoriaRepositorio, CategoriaRepositorio>();
builder.Services.AddScoped<IClienteRepositorio, ClienteRepositorio>();
builder.Services.AddScoped<IDetallePedidoRepositorio, DetallePedidoRepositorio>();
builder.Services.AddScoped<IImagenRepositorio, ImagenRepositorio>();
builder.Services.AddScoped<IObjetivoRepositorio, ObjetivoRepositorio>();
builder.Services.AddScoped<IPlatilloRepositorio, PlatilloRepositorio>();
builder.Services.AddScoped<IRealizarPedidoRepositorio, RealizarPedidoRepositorio>();
builder.Services.AddScoped<IUserRepositorio, UserRepositorio>();

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddAuthentication(x =>
                                    {
                                       x.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
                                       x.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
                                    }).AddJwtBearer(x =>
                                    {
                                       x.RequireHttpsMetadata = false;
                                       x.SaveToken = true;
                                       x.TokenValidationParameters = new TokenValidationParameters
                                       {
                                           IssuerSigningKey = new SymmetricSecurityKey(Encoding.ASCII.GetBytes(builder.Configuration.GetSection("AppSettings:Token").Value)),
                                           ValidateAudience = false,
                                           ValidateIssuerSigningKey = true,
                                           ValidateIssuer = false
                                       };
                                    });
builder.Services.AddAuthorization();

builder.Services.AddSwaggerGen(c =>
{
    c.OperationFilter<SecurityRequirementsOperationFilter>();
    c.AddSecurityDefinition("oauth2", new OpenApiSecurityScheme
    {
        Description = "Autorizacion Standar, Usar Bearer. Ejemplo \"bearer {token}\"",
        In = ParameterLocation.Header,
        Name = "Authorization",
        Type = SecuritySchemeType.ApiKey,
        Scheme = "Bearer"
    });
});

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

//para poder usar wwwroot/images
app.UseStaticFiles();

app.UseAuthentication();
app.UseAuthorization();
app.UseCors(x => x.AllowAnyOrigin()
                .AllowAnyMethod()
                .AllowAnyHeader());


app.MapControllers();

app.Run();

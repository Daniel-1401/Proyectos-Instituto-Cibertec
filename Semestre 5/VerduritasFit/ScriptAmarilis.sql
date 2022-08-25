USE VerduritasFit
GO


/*-----FUNCIONES-----*/
CREATE OR ALTER FUNCTION dbo.autogeneraIdPlatillo() RETURNS INT
AS
BEGIN
	DECLARE @id_platillo INT = (SELECT TOP 1 id_platillo FROM tb_platillo ORDER BY 1 DESC)
	IF(@id_platillo is null)
		SET @id_platillo = 1
	ELSE 
		SET @id_platillo = @id_platillo + 1

	RETURN @id_platillo
END
GO
CREATE OR ALTER FUNCTION dbo.autogeneraIdCategoria() RETURNS INT
AS
BEGIN
	DECLARE @id_categoria INT = (SELECT TOP 1 id_categoria FROM tb_categoria ORDER BY 1 DESC)
	IF(@id_categoria is null)
		SET @id_categoria = 1
	ELSE 
		SET @id_categoria = @id_categoria + 1

	RETURN @id_categoria
END
GO
-----LISTAR-----
create or alter proc usp_listarCategoria
As
	Select * from tb_categoria
go
create or alter proc usp_listarPlatillos
As
	Select * from tb_platillo
go
create or alter proc usp_listarImagenes
As
	Select * from tb_imagen
go
-----INSERTAR-----
create or alter proc usp_insertarCategoria
	@nombreCategoria varchar(45)
As
	begin
		insert into tb_categoria(id_categoria,
								 nombreCategoria)
						 values (dbo.autogeneraIdCategoria(),
								 @nombreCategoria)
	end
go
create or alter proc usp_insertaPlatillo
	@nombre			varchar(45),
	@descripcion	varchar(255),
	@ingrediente	varchar(255),
	@id_categoria	int,
	@precio			decimal(6,2),
	@caloria		int
As
begin
	insert into tb_platillo(id_platillo,
							nombre,
							descripcion,
							ingrediente,
							id_categoria,
							precio,
							calorias)
					values (dbo.autogeneraIdPlatillo(),
							@nombre,
							@descripcion,
							@ingrediente,
							@id_categoria,
							@precio,
							@caloria)
end
go
CREATE OR ALTER PROCEDURE usp_insertarImagen(
	@id_platillo	int,
	@id_imagen		VARCHAR(100),
	@urlImagen		VARCHAR(255)
)
AS
BEGIN
	INSERT INTO tb_imagen(id_platillo,
						  id_imagen,
						  urlImagen)
				   VALUES(@id_platillo,
						  @id_imagen,
						  @urlImagen)
END
GO
-----ELIMINAR-----
create or alter proc usp_eliminarCategoria
	@id_categoria int
	As
	Delete from tb_categoria  Where id_categoria=@id_categoria
go
create or alter proc usp_eliminarPlatillo
	@id_platillo int
	As
	Delete from tb_platillo  Where id_platillo=@id_platillo
go
CREATE OR ALTER PROCEDURE usp_eliminarImagen(
	@id_platillo	INT,
	@id_imagen		VARCHAR(100)
)
AS
	DELETE FROM tb_imagen
		WHERE tb_imagen.id_platillo = @id_platillo and 
			  tb_imagen.id_imagen   = @id_imagen
GO
-----ACTUALIZAR-----
create or alter proc usp_actualizarCategoria
	@id_categoria		int,
	@nombreCategoria	varchar(45)
As
	begin
		Update tb_categoria
			Set nombreCategoria = @nombreCategoria
		Where id_categoria = @id_categoria

	end
go
create or alter proc usp_actualizarPlatillo
	@id_platillo	int,
	@nombre			varchar(45),
	@descripcion	varchar(900),
	@ingrediente	varchar(900),
	@id_categoria	int,
	@precio			decimal(6,2),
	@caloria		int
As
	begin
		Update tb_platillo
			Set nombre=@nombre, 
				descripcion = @descripcion, 
				ingrediente = @ingrediente, 
				id_categoria = @id_categoria,
				precio=@precio, 
				calorias=@caloria
			Where id_platillo=@id_platillo
	end
go
CREATE OR ALTER PROCEDURE usp_actualizarImagen(
	@id_platillo	int,
	@id_imagen		VARCHAR(100),
	@urlImagen		VARCHAR(255)
)
AS
BEGIN
	UPDATE tb_imagen
		SET urlImagen = @urlImagen
	WHERE tb_imagen.id_platillo = @id_platillo and 
			  tb_imagen.id_imagen   = @id_imagen
END
GO
/*PRUEBAS*/
--EXEC usp_insertaPlatillo 'prueba','prueba','prueba',1,1111.23,345
--GO
--EXEC usp_insertarCategoria 'pruaba'
--GO
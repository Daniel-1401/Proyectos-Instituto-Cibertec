USE VerduritasFit
GO

/*-----FUNCIONES-----*/
CREATE OR ALTER FUNCTION dbo.autogeneraIdObjetivo() RETURNS INT
AS
BEGIN
	DECLARE @id INT = 1
	DECLARE @id_objetivo VARCHAR(8) = (SELECT TOP 1 id_objetivo FROM tb_objetivo ORDER BY 1 DESC)
	IF(@id_objetivo is null)
		SET @id = 1
	ELSE 
		SET @id =CAST(@id_objetivo AS INT) + 1

	RETURN @id
END
GO
CREATE OR ALTER FUNCTION dbo.validarExisteUserName(@username VARCHAR(20)) RETURNS BIT
AS
BEGIN
	DECLARE @existe BIT = 1
	DECLARE @condicion VARCHAR(20) = (SELECT TOP 1 username FROM tb_usuario WHERE tb_usuario.userName = @username )
	IF(@condicion is null)
		SET @existe = 0
	ELSE
		SET @existe = 1

	RETURN @existe
End
GO
CREATE OR ALTER FUNCTION dbo.autogeneraIdCliente() RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @id  INT
	DECLARE @idCliente VARCHAR(7)=(SELECT TOP 1 id_Cliente FROM tb_cliente ORDER BY 1 DESC)
	IF ( @idCliente IS NULL)
		SET @id = 1
	ELSE
		SET @id = CAST(SUBSTRING(@idCliente,2,7) AS INT) + 1

	RETURN CONCAT('V', REPLICATE('0',6-LEN(@id)),@id)
END
GO
-----LISTAR-----
CREATE OR ALTER PROCEDURE usp_listarObjetivos
AS
	SELECT *
	FROM tb_objetivo
GO
CREATE OR ALTER PROCEDURE usp_listarClientes
AS
	SELECT *
	FROM tb_cliente
GO
CREATE OR ALTER PROCEDURE usp_getUsuarioByUserName(
	@userName		VARCHAR(20)
)
AS
BEGIN
	SELECT	tb_usuario.userName,
			tb_usuario.PasswordHash,
			tb_usuario.PasswordSalt
		FROM tb_usuario 
		WHERE tb_usuario.userName = @userName
END
GO
CREATE OR ALTER PROCEDURE usp_getCliente(
	@username VARCHAR(20)
)
AS
BEGIN
	SELECT TOP 1 *
		FROM tb_cliente 
		WHERE userName = @username
END
GO
-----INSERTAR-----
CREATE OR ALTER PROCEDURE usp_insertarObjetivo(
	@descipcion VARCHAR(45)
)
AS
BEGIN
	DECLARE @id_objetivo INT
	SET @id_objetivo = dbo.autogeneraIdObjetivo()
	INSERT 
		INTO tb_objetivo(id_objetivo,decripcionObjetivo) 
		values (@id_objetivo, @descipcion);
End
GO
CREATE OR ALTER PROCEDURE usp_insertarUsuario(
	@userName		VARCHAR(20),
	@passwordHash	VARBINARY(max),
	@passwordSalt	VARBINARY(max)
)
AS
BEGIN
	INSERT INTO tb_usuario(userName, 
						   PasswordHash, 
						   PasswordSalt)
			VALUES (@userName,
					@passwordHash,
					@passwordSalt)	
END
GO
CREATE OR ALTER PROCEDURE usp_insertarCliente(
	@nombre				VARCHAR(45),
	@apellido			VARCHAR(45),
	@fechaNacimiento	DATE,
	@estatura			DECIMAL(5,2),
	@peso				DECIMAL(5,2),
	@correo				VARCHAR(45),
	@telefono			VARCHAR(9),
	@id_objetivo		INT,
	@userName			VARCHAR(20)
)
AS
BEGIN
	DECLARE @id_Cliente VARCHAR(7)
	SET @id_Cliente = dbo.autogeneraIdCliente()
	INSERT INTO tb_cliente(id_cliente,
						nombre,
						apellido,
						fechaNacimiento,
						estatura,
						peso,
						correo,
						telefono,
						id_objetivo,
						userName)
			VALUES (@id_cliente,
					@nombre,
					@apellido,
					@fechaNacimiento,
					@estatura,
					@peso,
					@correo,
					@telefono,
					@id_objetivo,
					@userName);
END
GO
-----ELIMINAR-----
CREATE OR ALTER PROCEDURE usp_eliminarObjetivo(
	@id_objetivo INT
)
AS
	DELETE FROM tb_objetivo WHERE id_objetivo=@id_objetivo
GO
CREATE OR ALTER PROCEDURE usp_desactivarCliente(
	@id_cliente VARCHAR(7)
)
AS
BEGIN
	UPDATE tb_cliente
		SET activo = 0
	WHERE id_cliente = @id_cliente
END
GO
-----ACTUALIZAR-----
CREATE OR ALTER PROCEDURE usp_actualizarObjetivo(
	@id_objetivo		INT,
	@decripcionObjetivo	VARCHAR(45)
)
AS
	UPDATE tb_objetivo
		SET decripcionObjetivo = @decripcionObjetivo
	WHERE id_objetivo = @id_objetivo
GO
CREATE OR ALTER PROCEDURE usp_actualizaPassword(
	@userName		VARCHAR(20),
	@passwordHash	VARBINARY(max),
	@passwordSalt	VARBINARY(max)
)
AS
	UPDATE tb_usuario
		SET passwordHash = @passwordHash,
			PasswordSalt = @passwordSalt
	WHERE userName = @userName
GO
CREATE OR ALTER PROCEDURE usp_actualizarCliente(
	@id_cliente			VARCHAR(7),
	@estatura			DECIMAL(5,2),
	@peso				DECIMAL(5,2),
	@correo				VARCHAR(45),
	@telefono			VARCHAR(9),
	@id_objetivo		INT
)
AS
BEGIN
	UPDATE tb_cliente
		SET estatura	= @estatura,
			peso		= @peso,
			correo		= @correo,
			telefono	= @telefono,
			id_objetivo = @id_objetivo

	WHERE id_cliente = @id_cliente
END
GO
----PRUEBAS----
--EXEC usp_insertarCliente 'prueba', 'prueba', '2020-01-01',134.12,99.99,'prueba','prueba',1,'string'
--GO
--exec usp_listarClientes
--select * from tb_platillo
--select * from tb_imagen
--select * from tb_cab_pedido
--select * from tb_det_pedido
--select * from tb_categoria

USE VerduritasFit
GO

/*DETALLE PEDIDO*/

/*-----FUNCIONES-----*/
CREATE OR ALTER FUNCTION dbo.autogeneraIdPedido() RETURNS CHAR(6)
AS
BEGIN
	DECLARE @id  INT
	DECLARE @idPedido CHAR(5)=(SELECT TOP 1 id_pedido FROM tb_cab_pedido ORDER BY 1 DESC)
	IF ( @idPedido IS NULL)
		SET @id = 1
	ELSE
		SET @id = CAST(SUBSTRING(@idPedido,2,5) AS INT) + 1

	RETURN CONCAT('P', REPLICATE('0',4-LEN(@id)),@id)
END
GO
-----LISTAR-----
CREATE OR ALTER PROCEDURE usp_listarCabeceraPedidos
As
Select * from tb_cab_pedido
go
CREATE OR ALTER PROCEDURE usp_listarDetallePedidos
As
Select * from tb_det_pedido
go
-----INSERTAR-----
create or alter proc usp_insertarCabeceraPedido
@id_pedido		varchar(5) output,
@fechaPedido	datetime,
@fechaEntrega	datetime = NULL,
@id_cliente		varchar(7),
@totalBoleta	decimal(8,2)
As
Begin
	SET @id_pedido = dbo.autogeneraIdPedido()
	IF(@fechaEntrega is null)
		SET @fechaEntrega = (@fechaPedido + 1)

	INSERT INTO tb_cab_pedido(id_pedido,
						 fechaPedido,
						 fechaEntrega,
						 id_cliente,
						 totalBoleta) 
			 VALUES(@id_pedido,
					@fechaPedido,
					@fechaEntrega,
					@id_cliente,
					@totalBoleta)
End
go
create or alter proc usp_insertarDetallePedido(
@id_pedido		char(5),
@id_platillo    int,
@cantidad		int,
@precioVenta	decimal(8,2)
)
As
Begin
	DECLARE @precioPlato DECIMAL(6,2) = (SELECT precio FROM tb_platillo WHERE id_platillo = @id_platillo)
	DECLARE @importe DECIMAL(7,2) = @cantidad * @precioPlato
	Insert into tb_det_pedido(id_pedido,
							  id_platillo,
							  cantidad,
							  precioVenta,
							  importe)
					 values(@id_pedido,
							@id_platillo,
							@cantidad,
							@precioVenta,
							@importe)
End
go
-----ACTUALIZAR-----
create or alter proc usp_actualizaCabeceraPedido
@id_pedido char(5),
@fechaPedido	datetime,
@fechaEntrega	datetime = NULL,
@totalBoleta	decimal(8,2)
As
BEGIN
	IF(@fechaEntrega is null)
		SET @fechaEntrega = (@fechaPedido + 1)
	Update tb_cab_pedido
	Set fechaPedido = @fechaPedido, 
		fechaEntrega = @fechaEntrega, 
		totalBoleta = @totalBoleta
	Where id_pedido = @id_pedido
END
go
create or alter proc usp_actualizarDetallePedido(
@id_pedido char(5),
@old_idplatillo int,
@new_idplatillo int = NULL,
@cantidad int
)
As
BEGIN
	IF(@new_idplatillo IS NULL) SET @new_idplatillo = @old_idplatillo

	DECLARE @precioPlato DECIMAL(6,2) = (SELECT precio FROM tb_platillo WHERE id_platillo = @new_idplatillo)
	DECLARE @importe DECIMAL(7,2) = @cantidad * @precioPlato

	Update tb_det_pedido
		Set id_platillo = @new_idplatillo, 
			cantidad	= @cantidad, 
			precioVenta = @importe, 
			importe		= @importe

	Where id_pedido = @id_pedido and id_platillo = @old_idplatillo
END
go

----PRUEBAS--
--EXEC usp_insertarCabeceraPedido @fechaPedido='2020-04-05',@id_cliente='V000001',@totalBoleta=123.12
--GO
--EXEC usp_actualizaCabeceraPedido 'P0001','2020-04-05','2020-05-05',123.12
--GO
--EXEC usp_actualizarDetallePedido @idpedido='P0001',@old_idplato=1,@cantidad=2
--GO
--EXEC usp_actualizarDetallePedido @idpedido='P0001',@old_idplato=1,@new_idplato=3,@cantidad=2
--GO
--EXEC usp_insertarDetallePedido 'P0001', 1, 2,123.12
--GO
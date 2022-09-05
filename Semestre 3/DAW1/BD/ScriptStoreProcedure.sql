-- ---PROCEDURES-----
USE ciberimpacto;

-- USUARIO
DELIMITER $$
create procedure sp_insertar_registro_usuario
	(
	   codUsuario						VARCHAR(5),
       email						    VARCHAR(100), 
       contraseña				        VARCHAR(16), 
       nombreUsuario					VARCHAR(45),
	   apellidoUsuario					VARCHAR(45)
)
BEGIN
	INSERT INTO tb_usuarios
	(	
		codUsuario,
		email,
		contraseña,
		nombreCompleto,
		apellidoCompleto
	)
	VALUES
	(
		codUsuario,                
		email,                   
		contraseña,				
		nombreUsuario,
		apellidoUsuario
	);
END$$

DELIMITER $$
CREATE PROCEDURE sp_update_registro_usuario
	(
		codUsuario						VARCHAR(5),
		codTipoDocumento			 	VARCHAR(45),
		numeroDocumento			 		VARCHAR(9),
		numeroTelefonico			 	VARCHAR(9),
		codPais			 			    VARCHAR(2),
		codCiudad			 			VARCHAR(3),
		numeroRUC			 			VARCHAR(11),
		direccion			 			VARCHAR(45)
	)
BEGIN
	UPDATE tb_usuarios	
	SET 	codTipoDocumento	= codTipoDocumento,
			numeroDocumento		= numeroDocumento,
			numeroTelefonico	= numeroTelefonico,
			codPais				= codPais,
			codCiudad			= codCiudad,
			numeroRUC			= numeroRUC,
			direccion			= direccion
	WHERE tb_usuarios.codUsuario = codUsuario;
END$$


-- PRODUCTO
DELIMITER $$
create procedure sp_insertarProducto
	(
		codProducto				VARCHAR(5),
		modeloProducto			VARCHAR(45),
		Categoria		 	VARCHAR(45),
		Marca		 		VARCHAR(45),
		descripcionPantalla		VARCHAR(15),
		CPUU		 			VARCHAR(45),
		GPU		 			VARCHAR(45),
		DiscoDuro		 	VARCHAR(45),
		SistemaOperativo		VARCHAR(45),
		precioVenta		 		DECIMAL(7,2)
--        imagen					LONGBLOB
)
BEGIN
	INSERT INTO tb_producto
	(
		codProducto,
		modeloProducto,
		Categoria,
		Marca,
		descripcionPantalla,
		CPUU,
		GPU,
		DiscoDuro,
		SistemaOperativo,
		precioVenta
	)
	VALUES
	(
		codProducto,
		modeloProducto,
		Categoria,
		Marca,
		descripcionPantalla,
		CPUU,
		GPU,
		DiscoDuro,
		SistemaOperativo,
		precioVenta
	);
    /*
    INSERT INTO imagenesProducto
    (
		codProducto,
        imagen
    )
    VALUES
    (
		codProducto,
        imagen
    );*/
END$$
call sp_insertarProducto('PRO01','LENOVO-RAYO','CategoriaX','MarcaX','PantXpulgadas','CPUX','GPUX','DiscoDuroX','SisX',4900);

DELIMITER $$
CREATE PROCEDURE sp_ActualizarProducto
(
		codProducto				VARCHAR(5),
		DiscoDuro		 		VARCHAR(45),
		SistemaOperativo		VARCHAR(45),
		precioVenta		 		DECIMAL(7,2)
--        imagen					LONGBLOB
)
BEGIN
	UPDATE tb_producto
    SET DiscoDuro = DiscoDuro,
		SistemaOperativo = SistemaOperativo,
        precioVenta = precioVenta
	WHERE tb_producto.codProducto = codProducto;
END$$
call sp_ActualizarProducto('PRO01','DiscoDuroY','SisY',9900);

DELIMITER $$
CREATE PROCEDURE sp_listarProducto()
BEGIN
	SELECT 
			*
	FROM tb_producto;
END$$

CALL sp_listarProducto()

-- PROCEDURE  PARA COMBOX
-- CPU
DELIMiTER $$
create procedure listacpu()
begin
select *
from tb_cpu;
end$$
DELIMiTER ;

call listacpu;




-- PROCEDUR QUE VALIDA ACCESO
DELIMiTER $$
create  procedure usp_validaAcceso (usr char(45), pas char(20))
begin
select * from tb_usuarios where email = usr and contraseña = pas;
end$$
DELIMiTER ;




-- GPU
DELIMiTER $$
create procedure listagpu()
begin
select codGPU,nombre
from tb_gpu;
end$$
DELIMiTER ;

call listacpu;

-- SISTEMA OPERATTIVO
DELIMiTER $$
create procedure listaSistemaOperativo()
begin
select codSistemaOperativo,nombre
from tb_sistemaoperativo;
end$$
DELIMiTER ;

-- DISCO DURO
DELIMiTER $$
create procedure listaDiscoDuro()
begin
select codDiscoDuro,capacidad
from tb_discoduro;
end$$
DELIMiTER ;

call listaDiscoDuro


-- CATEGORIA
DELIMiTER $$
create procedure listaCategoria()
begin
select codCategoria,nombreCategoria
from tb_categoria;
end$$
DELIMiTER ;

call listacategoria

nombre , codigo marca , capacidad
-- MARCA
DELIMiTER $$
create procedure listaMARCAXCAPACIDAD()
begin
select   d.codMarca,nombreMarca , capacidad
from tb_marca t
inner join tb_discoduro d
on t.codMarca = d.codMarca;
end$$
DELIMiTER ;

call  listaMARCAXCAPACIDAD

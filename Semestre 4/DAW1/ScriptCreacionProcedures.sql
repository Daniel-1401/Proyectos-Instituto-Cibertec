

/**************************** Procedure de usuario ***************************/

/***********************  Listado  *************************/

delimiter $$
create procedure LISTADO_USUARIO()
begin
	SELECT * FROM Usuario;
end $$
delimiter ;

call LISTADO_USUARIO();



/**************************** Insertar ***************************/

delimiter $$
CREATE PROCEDURE INSERTUSUARIO(
codusu char(6),
username varchar(15),
apellido varchar(15),
tipo  int,
usuario varchar(15),
clave varchar(15),
telefono  char(9),
fechareg  date,
fechanac  date)
BEGIN
INSERT INTO Usuario VALUES (codusu,username,apellido,tipo,usuario,clave,telefono,fechareg,fechanac);
END$$ 

drop procedure INSERTUSUARIO;


CALL INSERTUSUARIO('US0010','Ana','Cardenas lana',2,'an8@gmail.com','123456','936455358','2021-02-19','2000-03-25');
SELECT * FROM Usuario;

/**** Insertar 1 usuario *****/


/***********************  Actualizar  *************************/

delimiter $$
CREATE PROCEDURE ACTUALIZAR_USUARIO(
codusu char(6),
username varchar(15),
apellido varchar(15),
tipo  int,
email varchar(15),
clave varchar(15),
telefono  char(9),
fechareg  date,
fechanac  date)
BEGIN
UPDATE Usuario SET nom_usuario=username,ape_usuario=apellido,cod_tipo=tipo,email=email,clave=clave,tele_usuario=telefono,fecha_reg=fechareg,fecha_nac=fechanac where cod_usuario=codusu;
END$$


/***********************  Eliminar  *************************/

delimiter $$
CREATE PROCEDURE ELIMINAR_USUARIO(
codusu CHAR(6))
BEGIN
DELETE from Usuario where cod_Usuario=codusu;
END$$


/******************************************************************/




/************************************** CRUD PRODUCTOS *************************************/


/*******  Listado  *******/

delimiter $$
create procedure LISTADO_PRODUCTOS()
begin
	SELECT * FROM Productos;
end $$
delimiter ;


/******* Insertar *******/

delimiter $$
CREATE PROCEDURE INSERTPRODUCTO(
idpro int,
nompro varchar(80),
despro text,
preuni  decimal(10,0),
stockpro smallint,
unienpe smallint,
imagen  varchar(100),
codtipo  int)
BEGIN
INSERT INTO Productos VALUES (idpro,nompro,despro,preuni,stockpro,unienpe,imagen,codtipo);
END$$ 



/*******  Actualizar  *******/

delimiter $$
CREATE PROCEDURE ACTUALIZAR_PRODUCTOS(
idpro int,
nompro varchar(80),
despro text,
preuni  decimal(10,0),
stockpro smallint,
unienpe smallint,
img  varchar(100),
codtipo  int)
BEGIN
UPDATE Productos SET Nom_Producto=nompro,Des_Producto=despro,PrecioUnidad=preuni,Stock_Producto=stockpro,UnidadesEnPedido=unienpe,imagen=img,cod_Categoria=codtipo where Id_Producto=idpro;
END$$



CALL ACTUALIZAR_PRODUCTOS(50, 'Pollossss ','Pollo saltado, papas y arroz.',25.90,10,0,'https://cdn.rusticadelivery.com/images/products/71/71-1613268300-6028854c734b8.png',8);

SELECT * FROM Productos;


/*******  Eliminar  *******/


delimiter $$
CREATE PROCEDURE ELIMINAR_Productos(
idpro CHAR(6))
BEGIN
DELETE from Productos where Id_Producto=idpro;
END$$




/************************************** CRUD CATEGORIA *************************************/



/*******  Listado  *******/

delimiter $$
create procedure LISTADO_Categoria()
begin
	SELECT * FROM categoria;
end $$
delimiter ;





/******* Insertar *******/



delimiter $$
CREATE PROCEDURE INSERTCATEGORIA(
codcate int,
nomcate varchar(15))
BEGIN
INSERT INTO Categoria VALUES (codcate,nomcate);
END$$ 


/** **/
/*******  Actualizar  *******/

delimiter $$
CREATE PROCEDURE ACTUALIZAR_Categoria(
codcate int,
nomcate varchar(15))
BEGIN
UPDATE Categoria SET nom_Categoria=nomcate where cod_Categoria=codcate;
END$$



/*******  Eliminar  *******/


delimiter $$
CREATE PROCEDURE ELIMINAR_Categoria(
codcate int)
BEGIN
DELETE from Categoria where cod_Categoria=codcate;
END$$




/************************************** lISTADOS SIN Y CON FILTROS *************************************/



/*******  Listado Usuario con filtro  *******/

delimiter $$
create procedure Listado_filtro_usuario(
codusu char(6))
begin
SELECT * FROM Usuario where cod_Usuario=codusu;
end $$
delimiter ;



/*******  Listado de Detalle de Boleta  *******/


delimiter $$
create procedure Listado_detalleboleta()
begin
	SELECT * FROM DetalleBoleta;
end $$
delimiter ;

call  Listado_detalleboleta();



/*******  Listado de Detalle de Boleta  *******/


delimiter $$
create procedure Listado_boleta()
begin
	SELECT * FROM Boleta;
end $$
delimiter ;

call  Listado_boleta();


/*******  Listado Boleta con filtro  *******/


delimiter $$
create procedure Listado_Filtroboleta(
idbo CHAR(6))
begin
	SELECT * FROM Boleta where IdBoleta=idbo;
end $$
delimiter ;


call  Listado_Filtroboleta('DF0003');


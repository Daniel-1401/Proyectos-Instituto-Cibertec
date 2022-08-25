-- PROCEDIMIENTOS ALMACENADOS
use `ciberimpacto`;
use ciberimpacto;
-- MOSTRAR TABLAS EN CIBERIMPACTO
SHOW tables;

-- INSERCCIONES -------------------------------------------------------------------------------------------------------------------------------------------------------
-- TB_MARCA
insert into tb_marca values('MAR01', 'SAMSUNG');
insert into tb_marca values('MAR02', 'HP');
insert into tb_marca values('MAR03', 'DELL');
insert into tb_marca values('MAR04', 'SONY');
select * from tb_marca;

-- TB_CPU
insert into tb_CPU values('CPU01','MAR03','CPU RAPIDA','Barabone');
insert into tb_CPU values('CPU02','MAR02','CPU A PRUEBA DE VIRUS','Minitorre');
select * from tb_CPU;

-- TB_GPU
insert into tb_GPU values('GPU01','MAR01', 'Radeon RX Vega 56','2GB');
insert into tb_GPU values('GPU02','MAR04', 'Radeon RX Vega 56','6GB');
select * from tb_GPU;

-- TB_TIPODISCODURO
insert into tb_tipoDiscoDuro values('DIS01','Disco duro SAS');
select * from tb_tipodiscoduro;

-- TB_DISCODURO
insert into tb_discoDuro values ('DIS01','MAR01','600MB','DIS01');
insert into tb_discoDuro values ('DIS02','MAR02','1 TB','DIS01');
select* from tb_discoduro;

-- TB_CATEGORIA
insert into tb_categoria values('CAT01', 'LAPTOP GAMER');
insert into tb_categoria values('CAT02', 'LAPTOP DISEÑO');
insert into tb_categoria values('CAT03', 'LAPTOP DESARROLLO SOFTWARE');
select * from tb_categoria;

-- TB_SISTEMAOPERATIVO
 insert into tb_sistemaoperativo values ('SIS01','WINDOWS 10');
  insert into tb_sistemaoperativo values ('SIS02','WINDOWS 7');
  select * from tb_sistemaoperativo;


----- PROCEDIMIENTO PRODUCTO INSERTAR -------------------------------------------------------------------------------------------------------------------------------------------------------

DELIMiTER $$
create procedure usp_insertaproducto(cod varchar(5), nom varchar(50), codmarca varchar(5), modelo varchar(50), 
codcpu varchar(5), descripcion varchar(50), coddisco varchar(5), codgpu varchar(5), codcategoria varchar(5),
 codsistema varchar(5),precio DECIMAL(5,2)) 
begin
insert into tb_produtcto values(cod, nom, codmarca, modelo, codcpu, descripcion, 
coddisco, codgpu, codcategoria, codsistema, precio);
end$$
DELIMiTER ;

-- EJECUTAMOS USP_INSERTAPRODUCTO
call usp_insertaproducto('PRO01','Laptop LENOVO-RAYO','MAR02','Gamer','CPU01','Pantalla Gorila Glass','DIS01','GPU01','CAT01','SIS01',900);
call usp_insertaproducto('PRO02','Laptop HP-PAVILION','MAR03','Gamer X4','CPU02','Pantalla Gorila Glass','DIS01','GPU01','CAT01','SIS01',789);
call usp_insertaproducto('PRO03','Laptop SONY','MAR04','Gamer X904','CPU01','PANTALLA TACTIL','DIS01','GPU02','CAT03','SIS01',989);
select * from tb_produtcto;

show tables;

-- TIPO USUARIO
insert into tb_tipousuario values (1,'CLIENTE');
insert into tb_tipousuario values (2,'Administrador');

-- USUARIO
insert into tb_usuarios values ('Usu01', 1,'carlos@hotmail.com','ingenierodiablo','CAR001','Avalos');
insert into tb_usuarios values ('Usu02', 1,'javier@hotmail.com','123','	Jav001','Vasconcelos');
insert into tb_usuarios values ('Usu03', 1,'will@hotmail.com','987','	Will008','Criollo');
-- procedure VALIDA ACCESO
DELIMiTER $$
create  procedure usp_validaAcceso (usr char(45), pas char(20))
begin
select * from tb_usuarios where email = usr and contraseña = pas;
end$$
DELIMiTER ;

-- PROCEDURE QUE REGISTRA
select * from tb_usuarios

-- PROCEDURE  PARA COMBOX


-- CPU
DELIMiTER $$
create procedure listacpu()
begin
select codCPU,nombreCPU
from tb_cpu;
end$$
DELIMiTER ;

call listacpu

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
Use Master
go
if exists(Select * from sys.databases  Where name='VerduritasFit')
Begin
	Drop Database VerduritasFit
End
go

create database VerduritasFit
go

USE VerduritasFit
go

create table tb_objetivo(
id_objetivo			int primary key,
decripcionObjetivo	varchar(45)
);

create table tb_usuario(
userName		varchar(20) primary key,
PasswordHash	varbinary(max),
PasswordSalt	varbinary(max),
tipo			int DEFAULT 0
);

create table tb_cliente(
id_cliente		varchar(7) primary key,
nombre			varchar(45),
apellido	    varchar(45),
fechaNacimiento	date,
estatura		decimal(5,2),
peso			decimal(5,2),
correo			varchar(45),
telefono		varchar(9),
id_objetivo		int,
userName		varchar(20) unique,
activo			bit default 1
foreign key(id_objetivo) references tb_objetivo(id_objetivo),
foreign key(userName) references tb_usuario(userName)
);

create table tb_categoria(
id_categoria	int primary key,
nombreCategoria varchar(45)
);

create table tb_platillo(
id_platillo		int primary key,
nombre			varchar(45),
descripcion		varchar(900),
ingrediente		varchar(900),
id_categoria	int,
precio			decimal(6,2),
calorias		int,
imagen			varchar(200),
foreign key(id_categoria) references tb_categoria(id_categoria)
);
 
create table tb_imagen(
	id_platillo		int		NOT NULL,
	id_imagen		varchar(100),
	urlImagen		varchar(255),
	primary key (id_platillo, id_imagen),
	foreign key (id_platillo) references tb_platillo(id_platillo) ON DELETE CASCADE
);

create table tb_cab_pedido(
id_pedido	  char(5)	  not null	primary key,
fechaPedido	  datetime	  default	getDate(),
fechaEntrega  datetime	  default	(getDate() + 1),
id_cliente	  varchar(7) not null,
totalBoleta	  decimal(8,2),
foreign key(id_cliente) references tb_cliente(id_cliente)
)

create table tb_det_pedido(
id_pedido		char(5) not null,
id_platillo     int not null,
cantidad		int,
precioVenta		decimal(8,2),
importe			decimal(8,2),
primary key (id_pedido, id_platillo),
foreign key (id_pedido) references tb_cab_pedido(id_pedido),
foreign key (id_platillo) references tb_platillo(id_platillo)
);

insert into tb_objetivo values (1,'Perder peso');
insert into tb_objetivo values (2,'Subir peso');
insert into tb_objetivo values (3,'Mantenerse Saludable');

insert into tb_categoria values (1,'desayuno');
insert into tb_categoria values (2,'almuerzo');
insert into tb_categoria values (3,'cena');
insert into tb_categoria values (4,'intercomida');
insert into tb_categoria values (5,'ensaladas');
insert into tb_categoria values (6,'bebidas');
insert into tb_categoria values (7,'adicionales');

insert into tb_platillo values (1,'arroz con pollo', 'grasa: 7g, proteina:10 g,carboidrato: 8g', 'Ingredientes: arroz integral, una presa de pollo, alberja y zanahoraia', 2, 1234.12, 600)
insert into tb_platillo values (2,'lomo saltado', 'grasa: 7g, proteina:10 g,carboidrato: 8g', 'Ingredientes: arroz integral, una presa de pollo, alberja y zanahoraia', 2, 1234.12, 600)
insert into tb_platillo values (3,'aji de gallina', 'grasa: 7g, proteina:10 g,carboidrato: 8g', 'Ingredientes: arroz integral, una presa de pollo, alberja y zanahoraia', 2, 12, 600)
insert into tb_platillo values (4,'carapulcra', 'grasa: 7g, proteina:10 g,carboidrato: 8g', 'Ingredientes: xxxxx', 2, 12, 600)
insert into tb_platillo values (5,'tallarines verdes con bisteck', 'grasa: 7g, proteina:10 g,carboidrato: 8g', 'Ingredientes: xxx', 2, 12, 600)
insert into tb_platillo values (6,'pollo en salda de champiñones', 'grasa: 7g, proteina:10 g,carboidrato: 8g', 'Ingredientes: xxxx', 2, 12, 600)
insert into tb_platillo values (7,'procion de camote', 'grasa: 0g, proteina:0g,carboidrato: g', 'Ingredientes: xxxx', 7, 2, 90)


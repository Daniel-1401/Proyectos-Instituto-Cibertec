USE ciberimpacto;

-- TB_MARCA
insert into tb_marca values (01, 'SAMSUNG');
insert into tb_marca values (02, 'HP');
Insert into tb_marca values (03, 'DELL');
Insert into tb_marca values (04, 'MSI');
Insert into tb_marca values (05, 'HUAWEI');
Insert into tb_marca values (06, 'ACER');
Insert into tb_marca values (07, 'Kingston');
Insert into tb_marca values (08, 'Nvidia');
Insert into tb_marca values (09, 'AMD');
Insert into tb_marca values (10, 'Intel');
Insert into tb_marca values (11, 'ASUS');
Insert into tb_marca values (12, 'APPLE');

-- TB_CPU
Insert into tb_CPU values (01,10,'Intel Core'      ,'i7 10ma Gen.'  );
Insert into tb_CPU values (02,10,'Intel Core'      ,'i5 10ma Gen.'  );
Insert into tb_CPU values (03,10,'Intel Core'      ,'i9 11va Gen.'   );
Insert into tb_CPU values (04,09,'Procesador AMD'  ,'Ryzen 5 5900X' );
Insert into tb_CPU values (05,09,'Procesador AMD'  ,'Ryzen 7 5700X' );
Insert into tb_CPU values (06,09,'Procesador AMD'  ,'Ryzen 9 3600'  );
Insert into tb_CPU values (07,09,'Procesador AMD'  ,'Ryzen 9 5950X' );
Insert into tb_CPU values (09,09,'Procesador AMD'  ,'Ryzen 9 3900X ');
Insert into tb_CPU values (10,12,'Apple Chip'      ,'M1'            );

-- TB_GPU
Insert into tb_GPU values (01,08, 'RTX 3090'         ,'24 GB');
Insert into tb_GPU values (02,08, 'RTX 3080'         ,'20 GB');
Insert into tb_GPU values (03,08, 'RTX 3070'         ,'8 GB' );
insert into tb_GPU values (04,09, 'RADEON RX Vega 56','2 GB' );
insert into tb_GPU values (05,09, 'RADEON RX Vega 56','6 GB' );
Insert into tb_GPU values (06,09, 'RADEON RX 6900 XT','16 GB');
Insert into tb_GPU values (07,09, 'RADEON RX 6800 XT','8 GB' );
Insert into tb_GPU values (08,09, 'RADEON RX 6800'   ,'16 GB');
Insert into tb_GPU values (09,12, 'APPLE'            ,'7 Nucleos');


-- TB_TIPODISCODURO
Insert into tb_tipoDiscoDuro values (1, 'SSD');
Insert into tb_tipoDiscoDuro values (2, 'HDD');

-- TB_DISCODURO
Insert into tb_discoDuro values (01,01,'512 GB',2);
insert into tb_discoDuro values (02,01,'512 GB',1);
insert into tb_discoDuro values (03,01,'1 TB'  ,1);
Insert into tb_discoDuro values (04,07,'256 GB',1);
Insert into tb_discoDuro values (05,07,'516 GB',1);
Insert into tb_discoDuro values (06,07,'1 TB'  ,1);
Insert into tb_discoDuro values (07,12,'512 GB',1);
Insert into tb_discoDuro values (08,12,'2 TB'  ,1);

-- TB_CATEGORIA
insert into tb_categoria values (01, 'LAPTOP GAMER');
insert into tb_categoria values (02, 'LAPTOP DISEÑO');
Insert into tb_categoria values (03, 'LAPTOP TRABAJO');
Insert into tb_categoria values (04, 'NOTEBOOKS');
Insert into tb_categoria values (05, 'PC GAMER');

-- TB_SISTEMAOPERATIVO
insert into tb_sistemaoperativo values (01,'WINDOWS 10');
Insert into tb_SistemaOperativo values (02,'MAC OS');

-- TB_PRODUCTO
Insert into tb_producto values ('P0001','GP65 LEOPARD 10SEK','Categoria1','Marca1','15.6 pulgadas','GPU1','GPU1','Disco1','Sistema1',7699.59);
Insert into tb_producto values ('P0002','ZENBOOK DUO'       ,'Categoria1','Marca1','14 pulgadas'  ,'GPU1','GPU1','Disco1','Sistema1',7999.99);
Insert into tb_producto values ('P0003','PAVILION GAMING'   ,'Categoria1','Marca1','15.6 pulgadas','GPU1','GPU1','Disco1','Sistema1',4199.29);
Insert into tb_producto values ('P0004','VOSTRO 3400'       ,'Categoria1','Marca1','14 pulgadas'  ,'GPU1','GPU1','Disco1','Sistema1',3259.00);
Insert into tb_producto values ('P0005','MATEBOOK X PRO'    ,'Categoria1','Marca1','13.9 pulgadas','GPU1','GPU1','Disco1','Sistema1',5799.99);
Insert into tb_producto values ('P0006','AIR'               ,'Categoria1','Marca1','13 pulgadas'  ,'GPU1','GPU1','Disco1','Sistema1',5199.79);

-- TB_TIPOUSUARIO
Insert into tb_TipoUsuario values (1,'Administrador');
Insert into tb_TipoUsuario values (2,'Cliente');

-- TB_PAIS
Insert into tb_pais values ('PE', 'Peru');
-- Insert into tb_pais values ('US', 'USA');
-- Insert into tb_pais values ('DE', 'Alemania');
-- Insert into tb_pais values ('CN', 'China');
-- Insert into tb_pais values ('CL', 'Chile');


-- TB_CIUDAD
INSERT INTO tb_ciudad VALUES ('AMA','Amazonas');
INSERT INTO tb_ciudad VALUES ('ANC','Ancash');
INSERT INTO tb_ciudad VALUES ('APU','Apurimac');
INSERT INTO tb_ciudad VALUES ('ARE','Arequipa');
INSERT INTO tb_ciudad VALUES ('AYA','Ayacucho');
INSERT INTO tb_ciudad VALUES ('CAJ','Cajamarca');
INSERT INTO tb_ciudad VALUES ('CAL','Callao');
INSERT INTO tb_ciudad VALUES ('CUS','Cusco');
INSERT INTO tb_ciudad VALUES ('HUC','Huanuco');
INSERT INTO tb_ciudad VALUES ('ICA','Ica');
INSERT INTO tb_ciudad VALUES ('JUN','Junin');
INSERT INTO tb_ciudad VALUES ('LAL','La Libertad');
INSERT INTO tb_ciudad VALUES ('LAM','Lambayeque');
INSERT INTO tb_ciudad VALUES ('LIM','Lima departamento');
INSERT INTO tb_ciudad VALUES ('LMA','Lima provincia');
INSERT INTO tb_ciudad VALUES ('LOR','Loreto');
Insert into tb_ciudad values ('MDD','Madre de dios');
Insert into tb_ciudad values ('PIU','Piura');
Insert into tb_ciudad values ('PUN','Puno');

-- TB_ TIPODOCUMENTO
Insert into tb_TipoDocumento values (01,'DNI');
Insert into tb_TipoDocumento values (02,'Pasaporte');

-----------------------------------------------------------------------------

-- TB_USUARIOS
Insert into tb_usuarios values ('US001',1,'admin1@hotmail.com' ,'admin'  ,'Bad'  ,'Bunny' ,1,'82658429','975312468','PE','LIM','10826584299','direccion 1');
Insert into tb_usuarios values ('US002',2,'cliente@hotmail.com','cliente','J'    ,'Balvin',1,'72882226','924007726','PE','LIM','10728822267','direccion Balvin');
INSERT INTO tb_usuarios(codUsuario,codTipoUsuario,email,contraseña,nombreCompleto,apellidoCompleto) VALUES ('US003',2,'usuario@hotmail.com','usuario','Setch','ElPepe');

-- TB_FACTURA
Insert into tb_Factura values ('FC00000001','US002','2020-01-01',13499.58,15.50);

-- TB_CARRITO
Insert into tbCarrito values ('US003',1,'P0006',1,5199.79);

-- TB DETALLEFACTURA
INSERT INTO tb_DetalleFactura VALUES ('FC00000001',1,'P0005',1,5799.99);
INSERT INTO tb_DetalleFactura VALUES ('FC00000001',2,'P0001',1,7699.59);
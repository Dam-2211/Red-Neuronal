-- use red_neuronal;
-- CREACION DE LAS TABLAS --
/*
CREATE TABLE `red_neuronal`.`historial` (
	id_historial int not null primary key
    ,fecha date
    ,nom_usuario varchar(200)
    ,ambientes int
    ,baño int
    ,sp_total int
    ,sp_cubierta int
    ,amenities int
    ,cochera int
    ,precio int
);

create table `red_neuronal`.`Barrio`(
	id_barrio int not null auto_increment
    ,idhistorial int not null
    ,identificador int
    ,nombre varchar(500)
    ,primary key (id_barrio)
);
create table `red_neuronal`.`parametros`(
	id_param int not null auto_increment
    ,desc_param varchar(500)
    ,identificador varchar(20)
    ,primary key(id_param)
);

create table `red_neuronal`.`red.Rel_usu_his`(
	id_rel_usu_his int not null auto_increment
    ,id_usuario int not null
    ,id_historial int not null
    ,primary key(id_rel_usu_his)
);

create table `red_neuronal`.`Usuario`(
	id_usuario int not null auto_increment
    ,nickname varchar(200)
    ,contraseña varchar(200)
    ,primary key(id_usuario)
);
*/
--  INSERT DE LA TABLA DE HISTORIAL --
/*
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('1',date_format('2022/11/16', '%Y/%m/%d'),'Lucax','1','1','35','30','1','0','105000');
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('2',date_format('2022/11/15','%Y/%m/%d'),'Dam','2','1','51','46','1','1','150000');
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('3',date_format('2022/11/14','%Y/%m/%d'),'muñaño','1','1','30','30','1','0','139000');
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('4',date_format('2022/11/10','%Y/%m/%d'),'espi','1','1','34','34','0','0','98000');
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('5',date_format('2022/10/25','%Y/%m/%d'),'godel','2','1','83','42','1','1','142000');
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('6',date_format('2022/12/19','%Y/%m/%d'),'mellamohernan','2','1','31','30','1','0','115000');
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('7',date_format('2022/9/2','%Y/%m/%d'),'El saez','2','1','45','44','1','1','255000');
insert into historial (id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio) 
values ('8',date_format('2022/8/16','%Y/%m/%d'),'izi','2','1','52','49','1','0','200000');

-- INSERT DE LA TABLA BARRIO --
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('1','1','1','Palermo');
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('2','2','1','Palermo');
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('3','3','1','Palermo');
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('4','4','2','Saavedra');
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('5','5','3','Coghlan');
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('6','6','1','Palermo');
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('7','7','1','Palermo');
insert into barrio (id_barrio, idhistorial, identificador, nombre) 
values ('8','8','1','Palermo');

-- INSERT DE LA TABLA PARAMETROS -- 
insert into parametros(id_param, desc_param, identificador)
values('1','fecha de inicio','2022/01/21');
insert into parametros(id_param, desc_param, identificador)
values('2','fecha de fin','2022/12/31');
insert into parametros(id_param, desc_param, identificador)
values('3','fecha de borrar','2022/10/25');
insert into parametros(id_param, desc_param, identificador)
values('4','Ordenamiento de los registros','1');
*/
--  PROCEDURE QUE ORDENA LOS PRECIOS DE MENOR A MAYOR --
/*
DELIMITER $$
create procedure sp_menor_mayor()
BEGIN
declare param varchar(500);
declare orde varchar(2);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    set param = 'Ocurrio un Error interno';
END;
set orde :=  (select identificador from parametros where id_param = 4);
start transaction;
	if orde = 1 then
    select fecha,nom_usuario,precio 
	from historial 
	order by precio desc;
    else
		select fecha,nom_usuario,precio 
	from historial 
	order by precio asc;
    end if;
END$$

-- call sp_menor_mayor
*/
-- PROCEDURE QUE ORDENA DE FORMA ASCENDENTE O DESCENDENTE --
/*
DELIMITER $$
create procedure sp_modif_fech_asc (
	fecha1 varchar(20))
BEGIN
declare param varchar(500);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
  ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
	start transaction;
		update parametros set identificador = fecha1 where id_param = 4;
        commit;
END $$

-- call sp_modif_fech_asc('1');
-- drop procedure sp_modif_fech_asc
*/
-- PROCEDURE DE RANGO DE FECHAS --
/*DELIMITER $$
create procedure sp_order_fecha()
BEGIN
declare param varchar(500);
declare fecha1 datetime;
declare fecha2 datetime;

DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
  ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
	set fecha1 = (select date_format (identificador, '%Y/%m/%d') from parametros where id_param = 1);
	set fecha2 = (select date_format (identificador, '%Y/%m/%d') from parametros where id_param = 2);
    
	select fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio
	from
		historial
	where
		date_format (fecha, '%Y/%m/%d') between fecha1 and fecha2;
END $$

-- call sp_order_fecha
*/
--  PRODEDURE DONDE MODIFICA EL RANGO DE FECHAS  --
/*DELIMITER $$
create procedure sp_modif_fech (
	fecha1 date
    ,fecha2 date)
BEGIN
declare param varchar(500);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
  ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
	start transaction;
		update parametros set identificador = date_format(fecha1, '%Y/%m/%d') where id_param = 1;
		update parametros set identificador = date_format(fecha2, '%Y/%m/%d') where id_param = 2;
        commit;
END $$

-- call sp_modif_fech('2022/1/31', '2023/12/31');
-- drop procedure sp_modif_fech
*/
--  PRODEDURE DONDE MODIFICA LA FECHA A BORRAR  --
/*DELIMITER $$
create procedure sp_modif_fech_br (
	fecha1 date)
BEGIN
declare param varchar(500);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
  ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
	start transaction;
		update parametros set identificador = fecha1 where id_param = 3;
        commit;
END $$

-- call sp_modif_fech_br('2022-11-10');*/

--  PROCEDURE PARA BORRAR PASADA UNA FECHA  --
/*DELIMITER $$
create procedure sp_borrar_reg()
BEGIN
declare param varchar(500);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
  ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
    set   @fecha1 := (select date_format(identificador, '%Y/%m/%d') from parametros where id_param = 3);
 start transaction;
	DELETE from historial where date_format(fecha,'%Y/%m/%d') < date_format(@fecha1,'%Y/%m/%d');
end$$

-- call  sp_borrar_reg;
-- drop procedure sp_borrar_reg*/

-- BORRA TABLA BARRIO --
DELIMITER $$
create procedure sp_borrar_reg_barrio()
BEGIN
declare param varchar(500);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
  ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
    set   @fecha1 := (select date_format(identificador, '%Y/%m/%d') from parametros where id_param = 3);
 start transaction;
	DELETE from historial where date_format(fecha,'%Y/%m/%d') < date_format(@fecha1,'%Y/%m/%d');
end$$

-- PROCEDURE PARA CARGAR LOS REGISTROS --
/*delimiter &&
create procedure sp_agregar_registro( id_historial_in int, fecha_in date, nom_usuario_in varchar(200),
ambientes_in int, baño_in int, sp_total_in int, sp_cubierta_in int, amenities_in int, cochera_in int, precio_in int)
begin
declare param varchar(200);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
insert into red_neuronal.historial(id_historial, fecha, nom_usuario, ambientes, baño, sp_total, sp_cubierta, amenities, cochera, precio)
values(id_historial_in, fecha_in, nom_usuario_in, ambientes_in, baño_in, sp_total_in, sp_cubierta_in, amenities_in, cochera_in, precio_in);
commit;
end &&

call sp_agregar_registro("9","2022/09","","","","","","")*/

-- PROCEDURE PARA REGISTRAR LOS USUARIOS --
/*delimiter &&
create procedure sp_registrar_usuario(nick varchar(200), pass varchar(200))
begin
declare param varchar(200);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
insert into red_neuronal.Usuario(nickname, contraseña)
values(nick, pass);
commit;
end &&

-- call sp_registrar_usuario('lucax','1234');
-- drop procedure sp_registrar_usuario*/

-- PROCEDURE PARA VER LOS USUARIO --
/*delimiter &&
create procedure sp_ver_usuarios()
begin
declare param varchar(200);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
	select nickname, contraseña from usuario;
commit;
end &&

-- call sp_ver_usuarios*/

-- PROCEDURE PARA VER EL HISTORIAL UNA VEZ BORRADO --
/*delimiter &&
create procedure sp_ver_historial_br()
begin
declare param varchar(200);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
	select * from historial;
commit;
end &&

call sp_ver_historial_br*/

-- PROCEDURE PARA SABER LE PK --
/*delimiter &&
create procedure sp_saber_pk()
begin
declare param varchar(200);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
	select id_historial from historial;
commit;
end &&

call sp_saber_pk*/

-- PROCEDURE PARA SABER EL PK DE BARRIO --
/*delimiter &&
create procedure sp_saber_pk_barrio()
begin
declare param varchar(200);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
	select id_barrio from barrio;
commit;
end &&

call sp_saber_pk_barrio*/

-- PROCEDURE PARA CARGAR LOS BARRIOS CON LOS REGISTROS --
/*delimiter &&
create procedure sp_agregar_barrio( id_barrio_in int, idhistorial_in int,identificador_in int,nombre_in varchar(500))
begin
declare param varchar(200);
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    set param = 'Ocurrio un Error interno';
END;
start transaction;
	insert into red_neuronal.barrio( id_barrio, idhistorial,identificador,nombre)
	values(id_barrio_in, idhistorial_in,identificador_in,nombre_in);
commit;
end &&*/
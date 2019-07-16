

alter table usuario rename column password_web to password_app;

alter table empresa add column prefijo character varying(3);

insert into empresa (prefijo ,  codigo , descripcion, ruc, estado) values ('iw' , '123456789' , 'Ideas Web' , '4800301-8' , true);

alter table sucursal add column estado boolean default true;

alter table familia rename column procentaje_ganancia to porcentaje_ganancia;

alter table unidad_medida add column id_empresa integer;

alter table articulo DROP column id_sucursal;

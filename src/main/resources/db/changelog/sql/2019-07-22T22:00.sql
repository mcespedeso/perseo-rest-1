

alter table usuario add column id_caja integer;

alter table usuario 
add constraint Fk_usuario_caja
foreign key (id_caja) 
references caja (id_caja);

alter table factura DROP COLUMN estado;

alter table factura 
add constraint uk_factura_caja
unique (id_caja);







alter table cliente RENAME COLUMN usuario_log TO id_usuario;
ALTER TABLE cliente ALTER COLUMN id_usuario TYPE integer;

-- insertar datos en las tablas parametrizadas










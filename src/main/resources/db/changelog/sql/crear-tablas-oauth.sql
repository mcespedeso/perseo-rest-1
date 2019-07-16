
CREATE TABLE roles (
	  id_role bigserial PRIMARY KEY,
	  role character varying (50)
);

INSERT INTO roles (role) values ('ROLE_ADMIN');
INSERT INTO roles (role) values ('ROLE_USER');

CREATE TABLE usuario_x_role (
	  id_usuario_x_role bigserial PRIMARY KEY,
	  id_usuario bigint,
	  id_role bigint
);

alter table usuario_x_role 
add constraint Fk_usuario_x_role_role
foreign key (id_role) 
references roles (id_role);



-- Este script crea las tablas para almacenar las  autenticaciones oauth2 --

create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);

create table oauth_client_token (
  token_id VARCHAR(255),
  token bytea,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table oauth_access_token (
  token_id VARCHAR(255),
  token bytea,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication bytea,
  refresh_token VARCHAR(255)
);

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token bytea,
  authentication bytea
);

create table oauth_code (
  code VARCHAR(255), authentication bytea
);

create table oauth_approvals (
	userId VARCHAR(255),
	clientId VARCHAR(255),
	scope VARCHAR(255),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

insert into oauth_client_details (
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types, 
	access_token_validity, 
	refresh_token_validity, 
	autoapprove)
values ('perseoAppClientIdPassword', 
		'$2a$10$Zf2d4V78s1LM6Q4IwrN4oOSRJTrHHfp1AvG3s4qguT7NSSdTCpkQ.',
		'bar,read,write',
		'password,authorization_code,refresh_token',
		36000,
		36000,
		'true'
);

insert into oauth_client_details (
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types, 
	access_token_validity, 
	refresh_token_validity, 
	autoapprove)
values ('perseoWebClientIdPassword', 
		'$2a$10$Zf2d4V78s1LM6Q4IwrN4oOSRJTrHHfp1AvG3s4qguT7NSSdTCpkQ.',
		'bar,read,write',
		'password,authorization_code,refresh_token',
		36000,
		36000,
		'true'
);




--Se inicializa el usuario admin/admin por defecto para desarrollo (cambiar para produccion)
insert into public.usuario (login, password, password_app, activo, nombre_apellido, nro_documento, id_empresa) 
values ('admin', '$2a$10$.5WP2FoCDb9HMVVVmlyTdeM7Pk5/GQ5U23wUZFC39C3hMXqOI2AC2', '21232f297a57a5a743894a0e4a801fc3', true , 'admin', '9999999' , 1);

--Se inserta el role USER para el ADMIN
INSERT INTO usuario_x_role (id_usuario, id_role)
  VALUES (
    (SELECT id_usuario FROM usuario WHERE login = 'admin'),
    (SELECT id_role FROM roles WHERE role = 'ROLE_USER'));

    --Se inserta el role ADMIN para el ADMIN
INSERT INTO public.usuario_x_role (id_usuario, id_role)
  VALUES (
    (SELECT id_usuario FROM usuario WHERE login = 'admin'),
    (SELECT id_role FROM roles WHERE role = 'ROLE_ADMIN'));



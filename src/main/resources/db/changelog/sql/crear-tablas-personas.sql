-- Tabla cliente
CREATE TABLE cliente
(
  id_cliente serial NOT NULL,
  nombre_apellido character varying(150) NOT NULL,
  cod_tipo_doc character varying(4) NOT NULL DEFAULT 'CI'::character varying,
  nrodoc character varying(20) NOT NULL,
  sexo character varying(1),
  fecha_nacimiento date,
  lugar_nacimiento character varying(100),
  nacionalidad character varying(100),
  direccion character varying(100),
  telefono character varying(50),
  telefono1 character varying(50),
  telefono2 character varying(50),
  correo character varying(100),
  id_barrio integer,
  id_distrito integer,
  id_departamento integer,
  estado boolean DEFAULT true,
  id_empresa integer NOT NULL,
  id_sucursal integer,
  fecha_log timestamp without time zone DEFAULT now(),
  usuario_log character varying(100),
  CONSTRAINT pk_cliente PRIMARY KEY (id_cliente),
  CONSTRAINT fk_cliente_departamento FOREIGN KEY (id_departamento)
      REFERENCES departamento (id_departamento) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_cliente_distrito FOREIGN KEY (id_distrito)
      REFERENCES distrito (id_distrito) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_cliente_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_cliente_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_cliente_tipo_docu FOREIGN KEY (cod_tipo_doc)
      REFERENCES tipo_documento (cod_tipo_doc) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT ckc_sexo_cliente CHECK (sexo IS NULL OR (sexo::text = ANY (ARRAY['M'::character varying::text, 'F'::character varying::text])))
);


-- Tabla: proveedor
CREATE TABLE proveedor
(
  id_proveedor serial NOT NULL,
  cod_tipo_doc character varying(4),
  nro_doc character varying(20),
  descripcion character varying(100),
  telefono1 character varying(50),
  telefono2 character varying(50),
  fax character varying(50),
  direccion character varying(100),
  sitioweb character varying(100),
  email character varying(100),
  fecha_log timestamp without time zone,
  estado boolean default true,
  timbrado character varying(100),
  venc_timbrado date,
  id_empresa integer NOT NULL,
  usuario_log character varying(100),
  CONSTRAINT pk_proveedor PRIMARY KEY (id_proveedor),
  CONSTRAINT fk_proveedor_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_proveedor_tipodoc FOREIGN KEY (cod_tipo_doc)
      REFERENCES tipo_documento (cod_tipo_doc) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Tabla: usuario
CREATE TABLE usuario
(
  id_usuario serial NOT NULL,
  login character varying(50),
  password character varying(256),
  password_web character varying(256),
  activo boolean default true,
  nombre_apellido character varying(150),
  nro_documento character varying(150),
  direccion character varying(150),
  telefono character varying(150),
  correo character varying(150),
  id_sucursal integer,
  id_deposito integer,
  id_empresa integer not null,
  usuario_log character varying(100),
  fecha_log timestamp without time zone DEFAULT now(),
 
  CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario),
 CONSTRAINT fk_usuario_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT fk_usuario_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Tabla perfil usuario
CREATE TABLE perfilusuario
(
  id serial NOT NULL,
  id_usuario integer NOT NULL,
  id_perfil integer NOT NULL,
  
  CONSTRAINT pf_perfil_usuario PRIMARY KEY (id),
CONSTRAINT fk_perfilusuario_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
CONSTRAINT fk_perfilusuario_perfil FOREIGN KEY (id_perfil)
      REFERENCES perfil (id_perfil) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);




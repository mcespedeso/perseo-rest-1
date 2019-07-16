-- Table: empresa
CREATE TABLE empresa
(
  id_empresa serial NOT NULL,
  codigo character varying(50),
  descripcion character varying(100),
  direccion character varying(200),
  telefono1 character varying(50),
  telefono2 character varying(50),
  sitioweb character varying(50),
  email character varying(100),
  ruc character varying(20),
  estado boolean NOT NULL DEFAULT true,
  fecha_log timestamp without time zone DEFAULT now(),
  CONSTRAINT pk_empresa PRIMARY KEY (id_empresa)
);


-- Table: banco
CREATE TABLE banco
(
  id_banco serial NOT NULL,
  descripcion character varying(50) NOT NULL,
  telefono character varying(100),
  direccion character varying(100),
  sitioweb character varying(100),
  email character varying(100),
  estado boolean default true,
  id_empresa integer,
  CONSTRAINT pk_banco PRIMARY KEY (id_banco),
  CONSTRAINT fk_banco_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


-- Table: claseempleado
CREATE TABLE clase_empleado
(
  id_clase_empleado serial NOT NULL,
  descripcion character varying(100) NOT NULL,
  id_empresa integer,
  CONSTRAINT pk_clase_empleado PRIMARY KEY (id_clase_empleado),
  CONSTRAINT fk_banco_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


-- Table: conceptomov
CREATE TABLE concepto_mov
(
  id_concepto_mov serial NOT NULL,
  descripcion character varying(100),
  tipo character varying(1),
  CONSTRAINT pk_concepto_mov PRIMARY KEY (id_concepto_mov)
);

-- Table: departamento
CREATE TABLE departamento
(
  id_departamento serial NOT NULL,
  descripcion character varying(100),
  estado boolean default true,
  capital character varying(100),
  CONSTRAINT pk_departamento PRIMARY KEY (id_departamento)
);



-- Table: distrito
CREATE TABLE distrito
(
  id_distrito serial NOT NULL,
  descripcion character varying(100),
  id_departamento integer,
  estado boolean default true,
  CONSTRAINT pk_distrito PRIMARY KEY (id_distrito),
  CONSTRAINT fk_distrito_departamento FOREIGN KEY (id_departamento)
      REFERENCES departamento (id_departamento) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);



-- Table: estadocompra
CREATE TABLE estado_compra
(
  id_estado_compra serial NOT NULL,
  descripcion character varying(50) NOT NULL,
  CONSTRAINT pk_estado_compra PRIMARY KEY (id_estado_compra)
);


-- Table: estadoventa
CREATE TABLE estado_venta
(
  id_estado_venta serial NOT NULL,
  descripcion character varying(100),
  CONSTRAINT estado_venta_pkey PRIMARY KEY (id_estado_venta)
);


-- Table: familia
CREATE TABLE familia
(
  id_familia serial NOT NULL,
  descripcion character varying(100),
  estado boolean default true,
  procentaje_ganancia numeric(21,6),
  id_empresa integer,
  CONSTRAINT pk_familia PRIMARY KEY (id_familia),
  CONSTRAINT fk_familia_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);



-- Table: formapago
CREATE TABLE forma_pago
(
  id_forma_pago serial NOT NULL,
  descripcion character varying(100),
  estado boolean default true,
  tipo character varying(2),
  CONSTRAINT pk_formapago PRIMARY KEY (id_forma_pago)
);



-- Table: lineaarticulo
CREATE TABLE linea_articulo
(
  id_linea_articulo serial NOT NULL,
  id_familia integer NOT NULL,
  descripcion character varying(100),
  id_empresa integer,
  CONSTRAINT pk_linea_articulo PRIMARY KEY (id_linea_articulo),
  CONSTRAINT fk_linea_familia FOREIGN KEY (id_familia)
      REFERENCES familia (id_familia) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_linea_articulo_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


-- Table: marca
CREATE TABLE marca
(
  id_marca serial NOT NULL,
  descripcion character varying(100),
  id_empresa integer,
  CONSTRAINT pk_marca PRIMARY KEY (id_marca),
  CONSTRAINT fk_marca_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


-- Table: moneda
CREATE TABLE moneda
(
  cod_moneda serial NOT NULL,
  nombre character varying(100) NOT NULL,
  codigo character varying(10) NOT NULL,
  valor_decimal numeric(21,6) NOT NULL,
  CONSTRAINT pk_moneda PRIMARY KEY (cod_moneda)
);

-- Table: perfil
CREATE TABLE perfil
(
  id_perfil serial NOT NULL,
  descripcion character varying(100),
  estado boolean default true,
  CONSTRAINT pk_perfil PRIMARY KEY (id_perfil)
);


-- Table: clase
CREATE TABLE clase
(
  id_clase serial NOT NULL,
  descripcion character varying(100),
  clase character varying(100),
  estado boolean default true,
  url text,
  activity text,
  CONSTRAINT pk_clase PRIMARY KEY (id_clase)
);



-- Table: menu
CREATE TABLE menu
(
  id_menu serial NOT NULL,
  descripcion character varying(100),
  estado boolean default true,
  tipo character varying(1),
  mnemonic character varying(1),
  id_perfil integer,
  id_clase integer,
  menu_anterior integer,
  orden integer,
  CONSTRAINT pk_menu PRIMARY KEY (id_menu),
  CONSTRAINT fk_menu_clase FOREIGN KEY (id_clase)
      REFERENCES clase (id_clase) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_menu_menuanterior FOREIGN KEY (menu_anterior)
      REFERENCES menu (id_menu) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_menu_perfil FOREIGN KEY (id_perfil)
      REFERENCES perfil (id_perfil) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);


-- Table: sucursal
CREATE TABLE sucursal
(
  id_sucursal serial NOT NULL,
  descripcion character varying(100),
  codigo character varying(50),
  telefono1 character varying(50),
  telefono2 character varying(50),
  direccion character varying(100),
  id_empresa integer NOT NULL,
  ciudad character varying(100),
  matriz boolean,
  CONSTRAINT pk_sucursal PRIMARY KEY (id_sucursal)
);


-- Table: tipobajaarticulo
CREATE TABLE tipo_baja_articulo
(
  id_tipobaja_articulo serial NOT NULL,
  descripcion text,
  estado boolean default true,
  CONSTRAINT tipo_bajaa_rticulo_pkey PRIMARY KEY (id_tipobaja_articulo)
);


-- Table: tipodocumento
CREATE TABLE tipo_documento
(
  cod_tipo_doc character varying(4) NOT NULL,
  descripcion character varying(100) NOT NULL,
  estado boolean NOT NULL DEFAULT true,
  CONSTRAINT pk_tipodocumento PRIMARY KEY (cod_tipo_doc)
);


-- Table: tipoimpuesto
CREATE TABLE tipo_impuesto
(
  id_tipo_impuesto serial NOT NULL,
  descripcion character varying(100),
  tasa numeric(21,6),
  dividendo numeric(21,6),
  estado boolean default true,
  CONSTRAINT tipo_impuesto_pkey PRIMARY KEY (id_tipo_impuesto)
);


-- Table: unidadmedida
CREATE TABLE unidad_medida
(
  id_unidad_medida serial NOT NULL,
  descripcion character varying(100),
  estado boolean default true,
  CONSTRAINT pk_unidad_medida PRIMARY KEY (id_unidad_medida)
);


-- Table: user_authority
CREATE TABLE user_authority
(
  id_usuario integer,
  authority character varying(50)
);






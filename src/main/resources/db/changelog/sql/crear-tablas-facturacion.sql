-- Table: deposito
CREATE TABLE deposito
(
  id_deposito serial NOT NULL,
  descripcion text,
  estado boolean NOT NULL DEFAULT true,
  id_sucursal integer NOT NULL,
  id_empresa integer NOT NULL,
  fecha_log timestamp without time zone DEFAULT now(),
  id_usuario integer,
  CONSTRAINT deposito_pkey PRIMARY KEY (id_deposito),
  CONSTRAINT deposito_id_empresa_fkey FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT deposito_idsucursal_fkey FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: articulo
CREATE TABLE articulo
(
  id_articulo serial NOT NULL,
  id_sucursal integer,
  id_usuario integer,
  descripcion character varying(100) NOT NULL,
  codigo_barra character varying(50) NOT NULL,
  id_familia integer,
  id_marca integer NOT NULL DEFAULT 9999,
  cod_moneda integer NOT NULL DEFAULT 1,
  id_unidad_medida integer,
  id_tipo_impuesto integer,
  fecha_log timestamp without time zone DEFAULT now(),
  fecha_estado date,
  estado boolean NOT NULL DEFAULT true,
  id_linea_articulo integer,
  id_empresa integer NOT NULL,
  CONSTRAINT articulo_pkey PRIMARY KEY (id_articulo),
  CONSTRAINT fk_articulo_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_articulo_familia FOREIGN KEY (id_familia)
      REFERENCES familia (id_familia) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_lineaarticulo FOREIGN KEY (id_linea_articulo)
      REFERENCES linea_articulo (id_linea_articulo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_articulo_marca FOREIGN KEY (id_marca)
      REFERENCES marca (id_marca) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_moneda FOREIGN KEY (cod_moneda)
      REFERENCES moneda (cod_moneda) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_articulo_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_timpoimp FOREIGN KEY (id_tipo_impuesto)
      REFERENCES tipo_impuesto (id_tipo_impuesto) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_unidad FOREIGN KEY (id_unidad_medida)
      REFERENCES unidad_medida (id_unidad_medida) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);


CREATE TABLE caja
(
  id_caja serial NOT NULL,
  nro_caja integer NOT NULL,
  descripcion character varying(100),
  estado boolean NOT NULL DEFAULT true,
  id_usuario integer NOT NULL,
  id_sucursal integer NOT NULL,
  id_empresa integer NOT NULL,
  CONSTRAINT pk_caja PRIMARY KEY (id_caja),
  CONSTRAINT fk_caja_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
    CONSTRAINT fk_caja_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


-- Table: turno
CREATE TABLE turno
(
  id_turno serial NOT NULL,
  fecha date,
  fecha_apertura timestamp without time zone,
  fecha_cierre timestamp without time zone,
  id_sucursal integer,
  id_usuario integer,
  id_caja integer,
  fecha_ult_apertura date,
  fecha_ult_cierre date,
  total_efectivo numeric(21,6),
  total_cheque numeric(21,6),
  total_tarjeta numeric(21,6),
  cant_venta numeric(21,6),
  cant_venta_nula numeric(21,6),
  cant_compra numeric(21,6),
  cant_compra_nula numeric(21,6),
  estado boolean default true,
  tipo_turno character varying(5),
  id_empresa integer NOT NULL,
  fecha_log timestamp without time zone DEFAULT now(),
  CONSTRAINT pk_turno PRIMARY KEY (id_turno),
  CONSTRAINT fk_turno_reference_caja FOREIGN KEY (id_caja)
      REFERENCES caja (id_caja) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_turno_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_turno_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_turno_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: articulodeposito
CREATE TABLE articulo_deposito
(
  id_articulo_deposito serial NOT NULL,
  id_usuario integer,
  fecha_log timestamp without time zone DEFAULT now(),
  id_sucursal integer NOT NULL,
  id_articulo integer NOT NULL,
  id_deposito integer NOT NULL,
  cantidad numeric(21,6) NOT NULL DEFAULT 0,
  cantidad_minima numeric(21,6) DEFAULT 0,
  cantidad_bloqueo numeric(21,6) DEFAULT 0,
  inventario_fisico numeric(21,6),
  fecha_ult_inventario date,
  fecha_vencimiento date,
  fecha_ult_compra date,
  fecha_ult_venta date,
  nro_lote integer,
  precio_costo numeric(21,6) DEFAULT 0,
  precio_costo_eq numeric(21,6),
  precio_venta numeric(21,6) DEFAULT 0,
  precio_venta_eq numeric(21,6),
  estado boolean NOT NULL DEFAULT true,
  id_empresa integer NOT NULL,
  CONSTRAINT pk_articulodeposito PRIMARY KEY (id_articulo_deposito),

  CONSTRAINT fk_articulodep_articulo FOREIGN KEY (id_articulo)
      REFERENCES articulo (id_articulo) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulodep_deposito FOREIGN KEY (id_deposito)
      REFERENCES deposito (id_deposito) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulodep_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulodep_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT unique_articulo_deposito UNIQUE (id_articulo, id_deposito),
  CONSTRAINT fk_articulodep_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT check_articulodeposito_cantidad CHECK (cantidad >= 0::numeric)
);


-- Table: compracab
CREATE TABLE compra_cab
(
  id_compra_cab serial NOT NULL,
  fecha date,
  fecha_log timestamp without time zone DEFAULT now(), -- Se registra la fecha/hora de grabado del registro
  tipo character varying(2) DEFAULT 'FA'::character varying, -- FA = Factura...
  comprobante character varying(100),
  id_proveedor integer NOT NULL,
  cod_moneda integer NOT NULL,
  id_sucursal integer,
  id_usuario integer,
  importe numeric(21,6),
  pagado numeric(21,6),
  id_estado_compra integer DEFAULT 1,
  gravada10 numeric(21,6) DEFAULT 0,
  gravada5 numeric(21,6) DEFAULT 0,
  iva10 numeric(21,6) DEFAULT 0,
  iva5 numeric(21,6) DEFAULT 0,
  exenta numeric(21,6) DEFAULT 0,
  condicion character varying(2), -- CO = Contado...
  timbrado character varying(50),
  fec_venc_timbrado date,
  cotizacion numeric(21,6) DEFAULT 0,
  cantidad_cuota integer, -- Cantidad de Cuotas en el caso de que sea a credito y en varios pagos.
  observaciones text,
  id_turno integer NOT NULL,
  id_empresa integer NOT NULL,
  CONSTRAINT pk_compracab PRIMARY KEY (id_compra_cab),
  CONSTRAINT fk_compracab_estado_compra FOREIGN KEY (id_estado_compra)
      REFERENCES estado_compra (id_estado_compra) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_compracab_moneda FOREIGN KEY (cod_moneda)
      REFERENCES moneda (cod_moneda) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_compracab_proveedor FOREIGN KEY (id_proveedor)
      REFERENCES proveedor (id_proveedor) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_compracab_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_compracab_turno FOREIGN KEY (id_turno)
      REFERENCES turno (id_turno) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_compracab_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
 CONSTRAINT fk_compracab_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

COMMENT ON TABLE compra_cab
  IS 'Registra la cabecera de la compra';
COMMENT ON COLUMN compra_cab.fecha_log IS 'Se registra la fecha/hora de grabado del registro';
COMMENT ON COLUMN compra_cab.tipo IS 'FA = Factura
RE = Recibo
BO = Boleta
NC = Nota de Credito
ND = Nota debito';
COMMENT ON COLUMN compra_cab.condicion IS 'CO = Contado
CR = Credito';
COMMENT ON COLUMN compra_cab.cantidad_cuota IS 'Cantidad de Cuotas en el caso de que sea a credito y en varios pagos.';


-- Table: compradet

-- DROP TABLE compradet;

CREATE TABLE compradet
(
  id_compra_det serial NOT NULL,
  id_compra_cab integer,
  concepto character varying(100),
  cantidad integer DEFAULT 1,
  precio numeric(21,6) DEFAULT 0,
  iva_porcentaje numeric(21,6) DEFAULT 0,
  gravada numeric(21,6) DEFAULT 0,
  exenta numeric(21,6) DEFAULT 0,
  iva_importe numeric(21,6) DEFAULT 0,
  tipo_provision text,
  id_articulo_deposito integer NOT NULL,
  CONSTRAINT pk_compradet PRIMARY KEY (id_compra_det),
  CONSTRAINT fk_compradet_compracab FOREIGN KEY (id_compra_cab)
      REFERENCES compra_cab (id_compra_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Table: factura
CREATE TABLE factura
(
  id_factura serial NOT NULL,
  estado character varying(1),
  id_caja integer,
  establecimiento integer,
  punto_expedicion integer,
  nro_actual integer,
  nro_inicial integer,
  nro_final integer,
  valido_desde date,
  valido_hasta date,
  timbrado character varying(10),
  fecha_log timestamp without time zone DEFAULT now(),
  id_empresa integer NOT NULL,
  CONSTRAINT pk_factura PRIMARY KEY (id_factura),
  CONSTRAINT fk_factura_caja FOREIGN KEY (id_caja)
      REFERENCES caja (id_caja) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
 CONSTRAINT fk_factura_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE UNIQUE INDEX idx_factura
  ON factura
  USING btree
  (establecimiento, punto_expedicion, nro_actual);


CREATE TABLE metodocobro
(
  id_metodo_cobro serial NOT NULL,
  descripcion character varying(100) NOT NULL,
  estado boolean NOT NULL DEFAULT true,
  minimo_comision numeric(21,6),
  maximo_comision numeric(21,6),
  id_empresa integer NOT NULL,
  CONSTRAINT pk_metodocobro PRIMARY KEY (id_metodo_cobro),
 CONSTRAINT fk_metodocobro_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE tipo_factura
(
  id_tipo_factura serial NOT NULL,
  descripcion character varying(100),
  CONSTRAINT pk_tipofactura PRIMARY KEY (id_tipo_factura)
);

-- Table: facturacab
CREATE TABLE factura_cab
(
  id_factura_cab serial NOT NULL,
  fecha date NOT NULL,
  fecha_log timestamp without time zone NOT NULL DEFAULT now(),
  id_cliente integer NOT NULL,
  estado boolean NOT NULL DEFAULT true, -- TRUE = ACTIVO...
  cod_moneda integer NOT NULL,
  id_sucursal integer,
  establecimiento integer,
  punto_expedicion integer,
  nro_factura integer NOT NULL,
  importe numeric(21,6) NOT NULL,
  saldo numeric(21,6) NOT NULL DEFAULT 0,
  observacion character varying(150), -- SE REGISTRAN OBSERVACIONES POR EJEMPLO PARA EL CASO DE LAS ANULACIONES.
  impreso boolean,
  id_metodo_cobro integer,
  id_empresa integer NOT NULL,
  id_tipo_factura integer NOT NULL DEFAULT 1,
  cotizacion double precision,
  clase_factura character varying(1) NOT NULL DEFAULT 'F'::character varying,
  id_caja integer,
  id_usuario integer,
  fecha_anulacion timestamp with time zone,
  id_venta_cab integer,
  timbrado integer,
  vigencia_timbrado date,
  id_turno integer NOT NULL,
  CONSTRAINT pk_factura_cab PRIMARY KEY (id_factura_cab),
  CONSTRAINT fk_facturacab_cliente FOREIGN KEY (id_cliente)
      REFERENCES cliente (id_cliente) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_facturacab_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_facturacab_moneda FOREIGN KEY (cod_moneda)
      REFERENCES moneda (cod_moneda) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_facturacab_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

COMMENT ON COLUMN factura_cab.estado IS 'TRUE = ACTIVO
FALSE = ANULADO';
COMMENT ON COLUMN factura_cab.observacion IS 'SE REGISTRAN OBSERVACIONES POR EJEMPLO PARA EL CASO DE LAS ANULACIONES.';


-- Table: facturadet

-- DROP TABLE facturadet;

CREATE TABLE factura_det
(
  id_factura_det serial NOT NULL,
  id_factura_cab integer,
  concepto character varying(100),
  cantidad numeric(21,6) DEFAULT 1,
  exenta numeric(21,6) DEFAULT 0,
  gravada5 numeric(21,6) DEFAULT 0,
  gravada10 numeric(21,6) DEFAULT 0,
  iva5 numeric(21,6) DEFAULT 0,
  iva10 numeric(21,6) DEFAULT 0,
  precio_venta numeric(21,6),
  total numeric(21,6),
  descuento numeric(21,6),
  precio_costo numeric(21,6),
  id_articulo integer,
  CONSTRAINT pk_facturadet PRIMARY KEY (id_factura_det),
  CONSTRAINT fk_facturadet_articulo FOREIGN KEY (id_articulo)
      REFERENCES articulo (id_articulo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_facturadet_factura_cab FOREIGN KEY (id_factura_cab)
      REFERENCES factura_cab (id_factura_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);


-- Table: facturaformacobro
CREATE TABLE facturaformacobro
(
  id_factura_forma_cobro serial NOT NULL,
  importe numeric(21,6),
  estado boolean,
  id_factura_cab integer,
  referencia text,
  CONSTRAINT facturaformacobro_pkey PRIMARY KEY (id_factura_forma_cobro),
  CONSTRAINT fk_facturafc_facturacab FOREIGN KEY (id_factura_cab)
      REFERENCES factura_cab (id_factura_cab) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: articulomovimiento

CREATE TABLE articulo_movimiento
(
  id_articulo_movimiento serial NOT NULL,
  fecha date NOT NULL,
  fecha_log timestamp without time zone DEFAULT now(),
  id_articulo integer NOT NULL,
  id_deposito integer NOT NULL,
  id_concepto_mov integer,
  id_sucursal integer NOT NULL,
  id_usuario integer,
  id_turno integer,
  id_venta_cab integer,
  id_compra_cab integer,
  cantidad numeric(21,6) NOT NULL,
  columna character varying(1) NOT NULL,
  obs text,
  id_empresa integer NOT NULL,
  CONSTRAINT pk_articulomovimiento PRIMARY KEY (id_articulo_movimiento),
  CONSTRAINT fk_articulo_compra_cab FOREIGN KEY (id_compra_cab)
      REFERENCES compra_cab (id_compra_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_idconcepto FOREIGN KEY (id_concepto_mov)
      REFERENCES concepto_mov (id_concepto_mov) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_reference_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_turno FOREIGN KEY (id_turno)
      REFERENCES turno (id_turno) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulomov_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_facturacab_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE articulo_precio_venta_cab
(
  id_articulo_precio_venta_cab serial NOT NULL,
  descripcion text,
  estado boolean default true,
  id_empresa integer,
  CONSTRAINT articulo_precio_venta_cab_pkey PRIMARY KEY (id_articulo_precio_venta_cab),
  CONSTRAINT articuloprecioventacab_idempresa_fkey FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE articulo_precio_venta_det
(
  id_articulo_precio_venta_det serial NOT NULL,
  id_articulo_precio_venta_cab integer NOT NULL,
  id_articulo integer NOT NULL,
  precio double precision,
  CONSTRAINT articuloprecioventadet_pkey PRIMARY KEY (id_articulo_precio_venta_det),
  CONSTRAINT articuloprecioventadet_id_articulo_precio_venta_cab_fkey FOREIGN KEY (id_articulo_precio_venta_cab)
      REFERENCES articulo_precio_venta_cab (id_articulo_precio_venta_cab) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE articulo_transferencia_cab
(
  id_articulo_transferencia_cab serial NOT NULL,
  estado boolean,
  fecha date,
  fecha_log timestamp without time zone DEFAULT now(),
  cantidad_total integer NOT NULL,
  id_usuario integer NOT NULL,
  id_deposito_origen integer NOT NULL,
  id_deposito_destino integer NOT NULL,
  id_empresa integer,
  CONSTRAINT pk_articulotransferenciacab PRIMARY KEY (id_articulo_transferencia_cab),
  CONSTRAINT fk_articulo_transferencia_deposito_destino FOREIGN KEY (id_deposito_destino)
      REFERENCES deposito (id_deposito) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_transferencia_deposito_origen FOREIGN KEY (id_deposito_origen)
      REFERENCES deposito (id_deposito) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_articulo_transferencia_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_articulo_transferencia_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE articulotransferenciadet
(
  id_articulo_transferencia_det serial NOT NULL,
  cantidad_contado integer,
  cantidad_recibido integer,
  id_articulo_transferencia_cab integer NOT NULL,
  id_articulo integer NOT NULL,
  CONSTRAINT pk_articulotransferenciadet PRIMARY KEY (id_articulo_transferencia_det),
  CONSTRAINT fk_articulo_transferenciadet_articulo FOREIGN KEY (id_articulo)
      REFERENCES articulo (id_articulo) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE historico_articulo
(
  id_historico_articulo serial NOT NULL,
  id_deposito integer,
  id_articulo_deposito integer,
  id_turno integer,
  id_sucursal integer,
  id_empresa integer,
  anterior numeric(21,6) NOT NULL,
  entrada numeric(21,6) NOT NULL,
  venta numeric(21,6) NOT NULL,
  actual numeric(21,6) NOT NULL,
  precio_costo numeric(21,6) NOT NULL,
  precio_venta numeric(21,6) NOT NULL,
  CONSTRAINT historicoarticulo_pkey PRIMARY KEY (id_historico_articulo),
  CONSTRAINT fk_histart_artdep FOREIGN KEY (id_articulo_deposito)
      REFERENCES articulo_deposito (id_articulo_deposito) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_histart_deposito FOREIGN KEY (id_deposito)
      REFERENCES deposito (id_deposito) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_histart_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_histart_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_histart_turno FOREIGN KEY (id_turno)
      REFERENCES turno (id_turno) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE historico_precio_costo
(
  id_historico_precio_costo serial NOT NULL,
  fecha date,
  fechal_og timestamp without time zone DEFAULT now(),
  concepto text,
  precio_costo double precision,
  id_articulo integer,
  id_usuario integer,
  id_empresa integer,
  CONSTRAINT pk_historicopreciocosto PRIMARY KEY (id_historico_precio_costo),
  CONSTRAINT fk_historicopreciocosto_articulo FOREIGN KEY (id_articulo)
      REFERENCES articulo (id_articulo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_histprc_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE historico_precio_venta
(
  id_historico_precio_venta serial NOT NULL,
  fecha date,
  fecha_log timestamp without time zone DEFAULT now(),
  concepto text,
  precio_costo double precision,
  precio_venta double precision,
  porcentaje double precision,
  id_articulo_precio_venta_det integer,
  id_usuario integer,
  id_empresa integer,
  CONSTRAINT pk_historicoprecioventa PRIMARY KEY (id_historico_precio_venta),
  CONSTRAINT fk_historicoprecio_articuloprecioventa_det FOREIGN KEY (id_articulo_precio_venta_det)
      REFERENCES articulo_precio_venta_det (id_articulo_precio_venta_det) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_historicopreciocosto_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_histprv_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE caja_cuenta
(
  id_caja_cuenta serial NOT NULL,
  numero integer NOT NULL,
  descripcion character varying(100) NOT NULL,
  estado boolean NOT NULL DEFAULT true,
  tipo character varying(2), -- BA = Banco (Para emsion de cheques x tesoreria)...
  id_caja integer NOT NULL,
  cod_moneda integer NOT NULL,
  id_banco integer,
  cuenta_banco character varying(50),
  CONSTRAINT pk_cajacuenta PRIMARY KEY (id_caja_cuenta),
  CONSTRAINT fk_cajacuenta_banco FOREIGN KEY (id_banco)
      REFERENCES banco (id_banco) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_cajacuenta_caja FOREIGN KEY (id_caja)
      REFERENCES caja (id_caja) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_cajacuenta_moneda FOREIGN KEY (cod_moneda)
      REFERENCES moneda (cod_moneda) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE orden_pago_cab
(
  id_orden_pago_cab serial NOT NULL,
  fecha date,
  beneficiario character varying(200),
  concepto character varying(200),
  comentario character varying(200),
  id_usuario integer,
  tipo character varying(50), -- D = adelanto de proveedor...
  cod_moneda integer,
  importe numeric(21,6),
  cotizacion numeric(21,6),
  id_sucursal integer,
  estado character varying(2),
  fecha_pago date,
  retencion boolean NOT NULL,
  importe_retenido numeric(21,6) NOT NULL,
  id_empresa integer,
  CONSTRAINT pk_ordenpagocab PRIMARY KEY (id_orden_pago_cab),
  CONSTRAINT fk_ordenpagocab_moneda FOREIGN KEY (cod_moneda)
      REFERENCES moneda (cod_moneda) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ordenpagocab_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ordenpagocab_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

COMMENT ON COLUMN orden_pago_cab.tipo IS 'D = adelanto de proveedor
C = liquidacion de credito
T = transferencia bancaria
H = Caja chica
F = Pago de cuota de prestamos (de microsol)
P = Pago a provedeores
R = Sueldo y jornales.';

CREATE TABLE orden_pago_det
(
  id_orden_pago_det serial NOT NULL,
  id_orden_pago_cab integer,
  importe numeric(21,6),
  concepto character varying(200),
  CONSTRAINT pk_ordenpagodet PRIMARY KEY (id_orden_pago_det),
  CONSTRAINT fk_ordenpagodet_orden_pago_cab FOREIGN KEY (id_orden_pago_cab)
      REFERENCES orden_pago_cab (id_orden_pago_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);


CREATE TABLE orden_pago_compra
(
  id_orden_pago_compra serial NOT NULL,
  id_orden_pago_cab integer NOT NULL,
  id_compra_cab integer,
  importe numeric(21,6),
  id_empresa integer,
  CONSTRAINT pk_ordenpagocompra PRIMARY KEY (id_orden_pago_compra),
  CONSTRAINT fk_ordenpagocom_compra_cab FOREIGN KEY (id_orden_pago_cab)
      REFERENCES orden_pago_cab (id_orden_pago_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ordenpagocompra_empresa FOREIGN KEY (id_empresa)
      REFERENCES empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE orden_pago_fp
(
  id_orden_pago_fp serial NOT NULL,
  id_orden_pago_cab integer,
  importe numeric(21,6),
  cotizacion numeric(21,6),
  id_caja_cuenta integer,
  transaccion character varying(100),
  CONSTRAINT pk_ordenpagofp PRIMARY KEY (id_orden_pago_fp),
  CONSTRAINT fk_ordenpagofp_cajacuenta FOREIGN KEY (id_caja_cuenta)
      REFERENCES caja_cuenta (id_caja_cuenta) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ordenpagofp_ordenpagocab FOREIGN KEY (id_orden_pago_cab)
      REFERENCES orden_pago_cab (id_orden_pago_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);







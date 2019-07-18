CREATE TABLE venta_cab
(
  id_venta_cab serial,
  fecha date,
  fecha_log timestamp without time zone DEFAULT now(),
  fecha_facturacion date,
  id_usuario integer,
  id_sucursal integer NOT NULL,
  id_deposito integer,
  id_estado_venta integer,
  id_cliente integer,
  id_forma_pago integer,
  cod_moneda integer,
  importe numeric(21,6),
  impuesto numeric(21,6),
  cantidad_total numeric(21,6),
  nro_lote_venta integer,
  promedio_descuento numeric(21,6),
  observacion character varying(150),
  cantidad_caja integer,
  retenido boolean,
  motivo_retencion character varying(100),
  id_empresa integer,
  id_metodo_cobro integer,
  id_turno integer NOT NULL,
  CONSTRAINT pk_ventacab PRIMARY KEY (id_venta_cab),
  CONSTRAINT fk_ventacab_cliente FOREIGN KEY (id_cliente)
      REFERENCES cliente (id_cliente) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ventacab_estadoven FOREIGN KEY (id_estado_venta)
      REFERENCES estado_venta (id_estado_venta) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ventacab_formapago FOREIGN KEY (id_forma_pago)
      REFERENCES forma_pago (id_forma_pago) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ventacab_moneda FOREIGN KEY (cod_moneda)
      REFERENCES public.moneda (cod_moneda) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ventacab_sucursal FOREIGN KEY (id_sucursal)
      REFERENCES sucursal (id_sucursal) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ventacab_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE venta_det
(
  id_venta_det serial,
  id_venta_cab integer NOT NULL,
  id_articulo integer NOT NULL,
  cantidad numeric(21,6) NOT NULL DEFAULT 1,
  precio_costo numeric(21,6),
  precio_venta numeric(21,6),
  id_tipo_impuesto integer,
  impuesto numeric(21,6),
  tasa_descuento numeric(21,6),
  importe_descuento numeric(21,6),
  total numeric(21,6),
  CONSTRAINT pk_ventadet PRIMARY KEY (id_venta_det),
  CONSTRAINT fk_ventadet_tipoimp FOREIGN KEY (id_tipo_impuesto)
      REFERENCES tipo_impuesto (id_tipo_impuesto) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
 CONSTRAINT fk_ventadet_articulo FOREIGN KEY (id_articulo)
      REFERENCES articulo (id_articulo) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_ventadet_ventacab FOREIGN KEY (id_venta_cab)
      REFERENCES venta_cab (id_venta_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT ck_ventadet_cantidad CHECK (cantidad >= 0::numeric)
);

create table factura_plazo (
 id_factura_plazo serial,
 id_factura_cab integer not null,
 fecha_vencimiento date,
CONSTRAINT pk_factura_plazo PRIMARY KEY (id_factura_plazo),
CONSTRAINT fk_factura_plazo_facturacab FOREIGN KEY (id_factura_cab)
      REFERENCES factura_cab (id_factura_cab) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

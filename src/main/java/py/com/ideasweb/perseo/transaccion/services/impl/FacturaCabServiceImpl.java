package py.com.ideasweb.perseo.transaccion.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.ClienteDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.comunes.services.ClienteService;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloMovimientoDTO;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;
import py.com.ideasweb.perseo.stock.services.ArticuloMovimientoService;
import py.com.ideasweb.perseo.tesoreria.dtos.ConceptoMovDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;
import py.com.ideasweb.perseo.transaccion.dtos.EstadoVentaDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaCabDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaDetDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaFormaCobroDTO;
import py.com.ideasweb.perseo.transaccion.dtos.TipoFacturaDTO;
import py.com.ideasweb.perseo.transaccion.dtos.VentaCabDTO;
import py.com.ideasweb.perseo.transaccion.dtos.VentaDetDTO;
import py.com.ideasweb.perseo.transaccion.mapper.FacturaCabMapper;
import py.com.ideasweb.perseo.transaccion.reports.dataSource.JRDataSourceFactura;
import py.com.ideasweb.perseo.transaccion.reports.dataSource.JRDataSourceLibroIva;
import py.com.ideasweb.perseo.transaccion.repositories.FacturaCabRepository;
import py.com.ideasweb.perseo.transaccion.services.FacturaCabService;
import py.com.ideasweb.perseo.transaccion.services.FacturaDetService;
import py.com.ideasweb.perseo.transaccion.services.FacturaFormaCobroService;
import py.com.ideasweb.perseo.transaccion.services.FacturaService;
import py.com.ideasweb.perseo.transaccion.services.VentaCabService;
import py.com.ideasweb.perseo.utilities.n2tDouble;

@Service
public class FacturaCabServiceImpl extends BaseServiceImpl
        implements FacturaCabService {

    @Autowired
    DataSource dataSource;

    @Autowired
    FacturaCabMapper mapper;

    @Autowired
    FacturaCabRepository repo;

    @Autowired
    VentaCabService ventaCabService;

    @Autowired
    FacturaService facturaService;

    @Autowired
    FacturaFormaCobroService facturaFormaCobroService;

    @Autowired
    FacturaDetService facturaDetService;

    @Autowired
    ArticuloMovimientoService articuloMovimientoService;

    @Autowired
    ArticuloDepositoService articuloDepositoService;

    @Autowired
    ClienteService clienteService;

    @Override
    public List<FacturaCabDTO> getBySucursal(Boolean allEstados, Boolean estado,
            Boolean allTipos, Integer idtipofactura, Integer idSucursal)
            throws Exception {
        // TODO Auto-generated method stub
        List<FacturaCabDTO> list = new ArrayList<>();
        if (allEstados) {
            list = mapper.entityListToDtoList(
                    repo.findBySucursalIdSucursal(idSucursal));
        } else {
            list = mapper.entityListToDtoList(
                    repo.findBySucursalIdSucursalAndEstado(idSucursal, estado));
        }

        if (!allTipos)
            return list.stream().filter(
                    f -> f.getTipoFactura().getIdTipoFactura() == idtipofactura)
                    .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<FacturaCabDTO> getByCliente(Integer idcliente, Boolean all,
            Boolean estado) throws Exception {
        // TODO Auto-generated method stub
        if (all) {
            return mapper.entityListToDtoList(
                    repo.findByClienteIdCliente(idcliente));
        } else {
            return mapper.entityListToDtoList(
                    repo.findByClienteIdClienteAndEstado(idcliente, estado));
        }
    }

    @Override
    public FacturaCabDTO cobrarFactura(Integer idfacturacab,
            UsuarioDTO usuarioDTO) throws Exception {
        // TODO Auto-generated method stub
        FacturaCabDTO factura = getById(idfacturacab);
        factura.setEstado(true);
        factura.setFecha(new Date(System.currentTimeMillis()));

        return grabar(factura);
    }

    @Override
    public List<FacturaCabDTO> getByturno(Integer idturno) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findByTurnoIdTurno(idturno));
    }

    @Override
    public FacturaCabDTO grabar(FacturaCabDTO factura) throws Exception {
        // TODO Auto-generated method stub
        FacturaCabDTO newFactura = mapper
                .entityToDto(repo.save(mapper.dtoToEntity(factura)));

        factura.getDetalleFactura().stream().forEach(d -> {
            try {
                d.setFacturaCab(newFactura);
                facturaDetService.grabar(d);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        return newFactura;
    }

    @Override
    public FacturaCabDTO getById(Integer idFacturaCab) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idFacturaCab).get());
    }

    @Override
    public String registrarVentaRapida(VentaCabDTO ventaCab, UsuarioDTO usuario)
            throws Exception {

        String res = "";

        try {
            ventaCab.setFechaFacturacion(new Date(System.currentTimeMillis()));
            ventaCab.setEstadoVenta(new EstadoVentaDTO(2));
            VentaCabDTO newVenta = ventaCabService.grabar(ventaCab);

            FacturaCabDTO facturacab = new FacturaCabDTO();
            facturacab.setFecha(new Date(System.currentTimeMillis()));
            facturacab.setCliente(newVenta.getCliente());
            facturacab.setTipoFactura(newVenta.getTipoFactura());
            facturacab.setMoneda(newVenta.getMoneda());
            facturacab.setSucursal(newVenta.getSucursal());

            FacturaDTO factura = facturaService
                    .getNumeroSgteByCaja(usuario.getCaja().getIdCaja());
            factura.setNroActual(factura.getNroActual() + 1);

            facturacab.setEstablecimiento(factura.getEstablecimiento());
            facturacab.setPuntoExpedicion(factura.getPuntoExpedicion());
            facturacab.setNroFactura(factura.getNroActual());
            facturacab.setImporte(newVenta.getImporte());
            facturacab.setEmpresa(usuario.getEmpresa());
            facturacab.setObservacion(newVenta.getObservacion());
            facturacab.setSaldo(new Double(0));
            facturacab.setVentaCab(newVenta);
            facturacab.setUsuario(usuario);
            // facturacab.setTurno(login.getTurno());
            facturacab.setTimbrado(Integer.parseInt(factura.getTimbrado()));
            facturacab.setVigencia_Timbrado(factura.getValidoHasta());

            if (ventaCab.getTipoFactura().getIdTipoFactura() == 1) {
                // 1 contado
                facturacab.setEstado(true);
            } else {
                // 2 credito
                facturacab.setEstado(false);
            }

            // insertar las formas de pago
            for (FacturaFormaCobroDTO facturaformacobro : ventaCab
                    .getFormasCobro()) {
                facturaformacobro.setFacturaCab(facturacab);
                facturaFormaCobroService.grabar(facturaformacobro);
            }

            // insertar detalles de la factura
            List<FacturaDetDTO> detalleFactura = new ArrayList<>();
            for (VentaDetDTO element : ventaCab.getDetalles()) {

                FacturaDetDTO facturadet = new FacturaDetDTO();
                facturadet.setArticulo(element.getArticulo());
                facturadet.setCantidad(element.getCantidad());
                facturadet.setPrecioVenta(element.getPrecioVenta());
                facturadet.setPrecioCosto(element.getPrecioCosto());
                facturadet.setTotal(element.getTotal());
                facturadet.setDescuento(element.getImporteDescuento());
                if (element.getTipoImpuesto().getIdTipoImpuesto() == 5) {

                    facturadet.setIva5(element.getImpuesto());
                    facturadet.setGravada5(
                            (element.getTotal() - element.getImpuesto()));
                    facturadet.setIva10(new Double(0));
                    facturadet.setGravada10(new Double(0));
                    facturadet.setExenta(new Double(0));
                } else if (element.getTipoImpuesto()
                        .getIdTipoImpuesto() == 10) {
                    facturadet.setIva10(element.getImpuesto());
                    facturadet.setGravada10(
                            (element.getTotal() - element.getImpuesto()));
                    facturadet.setIva5(new Double(0));
                    facturadet.setGravada5(new Double(0));
                    facturadet.setExenta(new Double(0));
                } else if (element.getTipoImpuesto()
                        .getIdTipoImpuesto() == 100) {
                    facturadet.setExenta(element.getTotal());
                    facturadet.setIva5(new Double(0));
                    facturadet.setGravada5(new Double(0));
                    facturadet.setIva10(new Double(0));
                    facturadet.setGravada10(new Double(0));
                }
                detalleFactura.add(facturadet);

                // registra el movimiento
                ArticuloMovimientoDTO am = new ArticuloMovimientoDTO();
                am.setArticulo(element.getArticulo());
                am.setDeposito(usuario.getDeposito());
                am.setCantidad(element.getCantidad());
                am.setColumna("E");
                am.setConceptoMov(new ConceptoMovDTO(5));
                am.setSucursal(usuario.getSucursal());
                am.setUsuario(usuario);
                // am.setTurno(login.getTurno());
                am.setFecha(new Date(System.currentTimeMillis()));
                am.setVentaCab(newVenta);
                articuloMovimientoService.grabar(am);

                // descuenta el stock
                ArticuloDepositoDTO articulodeposito = articuloDepositoService
                        .getByArticuloAndDeposito(
                                element.getArticulo().getIdArticulo(),
                                usuario.getDeposito().getIdDeposito());
                articulodeposito.setCantidad(
                        articulodeposito.getCantidad() - element.getCantidad());
                articuloDepositoService.grabar(articulodeposito);

            }
            facturacab.setDetalleFactura(detalleFactura);

            // insertar facturacab
            FacturaCabDTO newFactura = grabar(facturacab);
            // actalizar el talonario
            facturaService.grabar(factura);

            res = imprimirTicket(newFactura, usuario);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return res;

    }

    @Override
    public String getLibroIvaVentaContable(String datos, UsuarioDTO usuario)
            throws Exception {

        String res = "";
        OutputStream outputStream = null;
        InputStream in = null;

        JSONObject params = new JSONObject(datos);

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

        Integer idcliente = params.getInt("idcliente");
        Integer puntoexpedicion = params.getInt("puntoexpedicion");
        String string_fechadesde = params.getString("fechadesde");
        Date fechadesde = new Date(sdf.parse(string_fechadesde).getTime());
        String string_fechahasta = params.getString("fechahasta");
        Date fechahasta = new Date(sdf.parse(string_fechahasta).getTime());
        ClienteDTO cliente = clienteService.getById(idcliente);

        Integer suc_desde = params.getInt("idsucursal");
        boolean suc_todas = params.getBoolean("suc_todas");
        boolean factura = params.getBoolean("factura");
        boolean remision = params.getBoolean("remision");
        String doc = params.getString("tipo");

        Connection conn = null;
        List<FacturaCabDTO> col = new ArrayList<FacturaCabDTO>();

        try {

            conn = dataSource.getConnection();

            String select = " select a.estado, a.id_factura_cab, a.fecha, b.nombrea_pellido, a.cod_moneda, a.establecimiento, a.punto_expedicion, ";
            select += " a.nro_factura, a.importe, a.id_tipo_factura, a.id_cliente, b.nrodoc, a.id_sucursal, c.nombre as sucursal, a.cotizacion ";
            select += " from factura_cab a  ";
            select += " join cliente b on b.id_cliente = a.id_cliente ";
            select += " join sucursal c on c.id_sucursal = a.id_sucursal ";
            select += " where a.fecha between ? and ?  ";
            if (!suc_todas) {
                select += " and a.id_sucursal =  " + suc_desde;
            }
            if (factura && remision) {
                select += " and a.clase_factura in( 'F','R','N') ";
            }
            if (remision && !factura) {
                select += " and a.clase_factura = 'R' ";
            }
            if (!remision && factura) {
                select += " and a.clase_factura in ( 'F', 'N' ) ";
            }

            if (puntoexpedicion.intValue() > 0) {
                select += " and a.punto_expedicion = ? ";
            }

            // select += " and a.estado = true ";

            if (idcliente != null) {
                select += " and a.id_cliente = ? ";
            }

            select += " order by a.id_sucursal, a.fecha, a.id_tipo_factura, a.punto_expedicion, a.nro_factura ";

            PreparedStatement ps = conn.prepareStatement(select);
            ps.setDate(1, fechadesde);
            ps.setDate(2, fechahasta);
            // ps.setInt(3, suc_desde);
            int count = 3;
            if (puntoexpedicion.intValue() > 0) {
                ps.setInt(count++, puntoexpedicion);
            }
            if (idcliente != null) {
                ps.setInt(count++, cliente.getIdCliente());
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FacturaCabDTO bean = new FacturaCabDTO();

                bean.setEstado(rs.getBoolean("estado"));
                bean.setIdFacturaCab(rs.getInt("id_factura_cab"));
                bean.setFecha(rs.getDate("fecha"));
                ClienteDTO c = new ClienteDTO();
                c.setNombreApellido(rs.getString("nombrea_pellido"));
                c.setNrodoc(rs.getString("nrodoc"));
                bean.setCliente(c);

                MonedaDTO moneda = new MonedaDTO();
                moneda.setCodMoneda(rs.getInt("cod_moneda"));
                bean.setMoneda(moneda);
                bean.setEstablecimiento(rs.getInt("establecimiento"));
                bean.setPuntoExpedicion(rs.getInt("puntoe_xpedicion"));
                bean.setNroFactura(rs.getInt("nro_factura"));
                TipoFacturaDTO tipofactura = new TipoFacturaDTO();
                tipofactura.setIdTipoFactura(rs.getInt("id_tipo_factura"));
                bean.setTipoFactura(tipofactura);
                SucursalDTO sucursal = new SucursalDTO();
                sucursal.setIdSucursal(rs.getInt("idsucursal"));
                sucursal.setDescripcion(rs.getString("sucursal"));
                bean.setSucursal(sucursal);

                // Busca el detalle
                String detalle = " Select gravada5, iva5, gravada10, iva10, exenta ";
                detalle += " from factura_det ";
                detalle += " where id_factura_cab = ? ";

                PreparedStatement psx = conn.prepareStatement(detalle);
                psx.setInt(1, rs.getInt("id_factura_cab"));
                ResultSet rsx = psx.executeQuery();

                Double gravada10 = new Double(0);
                Double gravada5 = new Double(0);
                Double iva10 = new Double(0);
                Double iva5 = new Double(0);
                Double exenta = new Double(0);

                while (rsx.next()) {
                    if (rs.getInt("cod_moneda") == 1) {
                        iva10 += rsx.getDouble("iva10");
                        gravada10 += rsx.getDouble("gravada10");
                        iva5 += rsx.getDouble("iva5");
                        gravada5 += rsx.getDouble("gravada5");
                        exenta += rsx.getDouble("exenta");
                    } else {
                        iva10 += Math.round((rsx.getDouble("iva10")
                                * rs.getDouble("cotizacion")));
                        gravada10 += Math.round(rsx.getDouble("gravada10")
                                * rs.getDouble("cotizacion"));
                        iva5 += Math.round(rsx.getDouble("iva5")
                                * rs.getDouble("cotizacion"));
                        gravada5 += Math.round(rsx.getDouble("gravada5")
                                * rs.getDouble("cotizacion"));
                        exenta += Math.round(rsx.getDouble("exenta")
                                * rs.getDouble("cotizacion"));
                    }
                }

                psx.close();
                rsx.close();

                bean.setIva10(iva10);
                bean.setIva5(iva5);
                bean.setExenta(exenta);
                bean.setGravada10(gravada10);
                bean.setGravada5(gravada5);

                bean.setImporte(iva10 + iva5 + exenta + gravada10 + gravada5);

                col.add(bean);

            }

            ps.close();
            rs.close();
            InputStream reporte = null;
            JasperPrint print = null;
            Map<String, Object> parameters = new HashMap<String, Object>();

            if (!col.isEmpty()) {

                if (doc.equals("P")) {
                    // jr = (JasperReport)
                    // JRLoader.loadObject(getClass().getResourceAsStream("JRLibroIva.jasper"));
                    reporte = this.getClass().getResourceAsStream(
                            "/py/com/ideasweb/perseo/transaccion/reports/JRLibroIVAVenta.jasper");
                } else if (doc.equals("E")) {
                    // jr = (JasperReport)
                    // JRLoader.loadObject(getClass().getResourceAsStream("LibroVentaExcel.jasper"));
                    reporte = this.getClass().getResourceAsStream(
                            "/py/com/ideasweb/perseo/transaccion/reports/LibroVentaExcel.jasper");
                }
                JasperReport report = (JasperReport) JRLoader
                        .loadObject(reporte);

                String sReporte = report.getName().substring(
                        report.getName().lastIndexOf(".") + 1,
                        report.getName().length());
                parameters.put("sReporte", sReporte);
                parameters.put("dFechadesde", fechadesde);
                parameters.put("dFechahasta", fechahasta);
                parameters.put("sTitulo", "LIBRO VENTAS");
                parameters.put("dFecha", new Date(System.currentTimeMillis()));
                String tipo = "";
                if (factura) {
                    tipo = "Facturas ";
                }
                if (remision) {
                    tipo = tipo + " - Remisiones";
                }

                parameters.put("tipo", tipo);

                print = JasperFillManager.fillReport(report, parameters,
                        new JRDataSourceLibroIva(col));

                byte[] reporteF = null;
                reporteF = JasperExportManager.exportReportToPdf(print);
                File tempFileF = File.createTempFile("Libro-venta", ".pdf",
                        null);
                FileOutputStream fos = new FileOutputStream(tempFileF);
                fos.write(reporteF);

                res = tempFileF.getName();

            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return res;
    }

    @Override
    public String imprimirTicket(FacturaCabDTO facturaCab, UsuarioDTO usuario)
            throws Exception {
        String r = "";
        try {
            JasperReport jr = null;
            InputStream reporte = null;
            JasperPrint print = null;
            if (facturaCab.getTipoFactura().getIdTipoFactura() == 2) {
                reporte = this.getClass().getResourceAsStream(
                        "/py/com/ideasweb/perseo/transaccion/reports/JRFacturaTicketCred.jasper");
                // jr = (JasperReport)
                // JRLoader.loadObject(getClass().getResourceAsStream("/py/com/perseo/venta/reports/JRFacturaTicketCred.jasper"));
            } else {
                // jr = (JasperReport)
                // JRLoader.loadObject(getClass().getResourceAsStream("/py/com/perseo/venta/reports/JRFacturaTicketII.jasper"));
                reporte = this.getClass().getResourceAsStream(
                        "/py/com/ideasweb/perseo/transaccion/reports/JRFacturaTicketII.jasper");
            }
            JasperReport report = (JasperReport) JRLoader.loadObject(reporte);

            Map<String, Object> parameters = new HashMap<String, Object>();
            // datos de la empresa
            parameters.put("empresa", usuario.getEmpresa().getDescripcion());
            parameters.put("rucemp", usuario.getEmpresa().getRuc());
            parameters.put("direccion", usuario.getEmpresa().getDireccion());
            parameters.put("telefono", usuario.getSucursal().getTelefono1());
            parameters.put("timbrado", facturaCab.getTimbrado().toString());
            parameters.put("timbradofin", facturaCab.getVigencia_Timbrado());
            parameters.put("sRazonSocial",
                    facturaCab.getCliente().getNombreApellido());
            parameters.put("sDocumento", facturaCab.getCliente().getNrodoc());
            parameters.put("usuario", usuario);
            String tipo = "";
            if (facturaCab.getTipoFactura().getIdTipoFactura() == 1) {
                tipo = "CONTADO";
            } else if (facturaCab.getTipoFactura().getIdTipoFactura() == 2) {
                tipo = "CREDITO";
            }
            parameters.put("tipo", tipo);
            parameters.put("sFecha", facturaCab.getFecha());
            // format comprobante
            DecimalFormat df = new DecimalFormat("000");
            DecimalFormat dfnro = new DecimalFormat("0000000");
            Integer valor = new Integer(facturaCab.getEstablecimiento());
            String establecimiento = df.format(valor);
            String puntoexpedicion = df.format(facturaCab.getPuntoExpedicion());
            String nrofactura = dfnro.format(facturaCab.getNroFactura());
            parameters.put("sNroFactura", establecimiento + " - "
                    + puntoexpedicion + " - " + nrofactura);
            Double sub_total_10 = new Double(0);
            Double sub_total_5 = new Double(0);
            Double sub_total_Ex = new Double(0);
            Double iva10 = new Double(0);
            Double iva5 = new Double(0);
            Double total_iva = new Double(0);
            for (Iterator iterator = facturaCab.getDetalleFactura()
                    .iterator(); iterator.hasNext();) {
                FacturaDetDTO det = (FacturaDetDTO) iterator.next();
                iva10 += det.getIva10();
                iva5 += det.getIva5();
                sub_total_10 += det.getGravada10() + det.getIva10();
                sub_total_5 += det.getGravada5() + det.getIva5();
                sub_total_Ex += det.getExenta();
            }
            parameters.put("nSubTotalEx", sub_total_Ex);
            parameters.put("nSubTotal5", sub_total_5);
            parameters.put("nSubTotal10", sub_total_10);
            parameters.put("hora", new Timestamp(System.currentTimeMillis()));
            parameters.put("nIva5", iva5);
            parameters.put("nIva10", iva10);
            parameters.put("nTotalIva", iva5 + iva10);
            parameters.put("nTotal", facturaCab.getImporte());
            String res = "";
            n2tDouble numero;
            numero = new n2tDouble();
            String let;
            res = numero.convertirLetras(facturaCab.getImporte().intValue());
            parameters.put("sLetras", res.toUpperCase() + "###");

            print = JasperFillManager.fillReport(report, parameters,
                    new JRDataSourceFactura(facturaCab.getDetalleFactura()));

            byte[] reporteF = null;
            reporteF = JasperExportManager.exportReportToPdf(print);
            File tempFileF = File.createTempFile("Fact", ".pdf", null);
            FileOutputStream fos = new FileOutputStream(tempFileF);
            fos.write(reporteF);

            r = tempFileF.getName();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return r;
    }

    @Override
    public String imprimirNormal(FacturaCabDTO facturaCab) throws Exception {
        String r = "";
        try {

            JasperReport jr = null;
            InputStream reporte = null;
            JasperPrint print = null;
            // jr = (JasperReport)
            // JRLoader.loadObject(getClass().getResourceAsStream("/py/com/perseo/venta/reports/JRFactura.jasper"));

            reporte = this.getClass().getResourceAsStream(
                    "/py/com/ideasweb/perseo/transaccion/reports/JRFactura.jasper");

            JasperReport report = (JasperReport) JRLoader.loadObject(reporte);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("sRazonSocial",
                    facturaCab.getCliente().getNombreApellido());
            parameters.put("sDocumento", facturaCab.getCliente().getNrodoc());

            if (facturaCab.getTipoFactura().getIdTipoFactura() == 1) {
                parameters.put("sCredito", "");
                parameters.put("sContado", "X");
            } else if (facturaCab.getTipoFactura().getIdTipoFactura() == 2) {
                parameters.put("sContado", "");
                parameters.put("sCredito", "X");
            }

            SimpleDateFormat formato = new SimpleDateFormat(
                    "dd ' de ' MMMMM ' de ' yyyy");
            String cadenaFecha = formato.format(facturaCab.getFecha());
            parameters.put("sFecha", cadenaFecha);
            parameters.put("sNroFactura",
                    facturaCab.getEstablecimiento() + "-"
                            + facturaCab.getPuntoExpedicion() + "-"
                            + facturaCab.getNroFactura());

            Double sub_total_10 = new Double(0);
            Double sub_total_5 = new Double(0);
            Double sub_total_Ex = new Double(0);

            Double iva10 = new Double(0);
            Double iva5 = new Double(0);
            Double total_iva = new Double(0);

            for (Iterator iterator = facturaCab.getDetalleFactura()
                    .iterator(); iterator.hasNext();) {
                FacturaDetDTO det = (FacturaDetDTO) iterator.next();
                iva10 += det.getIva10();
                iva5 += det.getIva5();
                sub_total_10 += (det.getGravada10() + det.getIva10());
                sub_total_5 += (det.getGravada5() + det.getIva5());
                sub_total_Ex += det.getExenta();
            }

            parameters.put("nSubTotalEx", sub_total_Ex);
            parameters.put("nSubTotal5", sub_total_5);
            parameters.put("nSubTotal10", sub_total_10);

            parameters.put("nIva5", iva5);
            parameters.put("nIva10", iva10);
            parameters.put("nTotalIva", iva5 + iva10);

            parameters.put("nTotal", facturaCab.getImporte());

            String res = "";
            n2tDouble numero;
            numero = new n2tDouble();
            String let;
            res = numero.convertirLetras(facturaCab.getImporte().intValue());
            parameters.put("sLetras", res.toUpperCase() + "###");

            print = JasperFillManager.fillReport(report, parameters,
                    new JRDataSourceFactura(facturaCab.getDetalleFactura()));

            byte[] reporteF = null;
            reporteF = JasperExportManager.exportReportToPdf(print);
            File tempFileF = File.createTempFile("Fact", ".pdf", null);
            FileOutputStream fos = new FileOutputStream(tempFileF);
            fos.write(reporteF);

            r = tempFileF.getName();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return r;
    }

}

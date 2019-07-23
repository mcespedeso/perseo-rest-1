package py.com.ideasweb.perseo.transaccion.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.ProveedorDTO;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloMovimientoDTO;
import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioCostoDTO;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;
import py.com.ideasweb.perseo.stock.services.ArticuloMovimientoService;
import py.com.ideasweb.perseo.stock.services.ArticuloPrecioVentaDetService;
import py.com.ideasweb.perseo.stock.services.HistoricoPrecioCostoService;
import py.com.ideasweb.perseo.tesoreria.dtos.ConceptoMovDTO;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;
import py.com.ideasweb.perseo.transaccion.dtos.EstadoCompraDTO;
import py.com.ideasweb.perseo.transaccion.mapper.CompraCabMapper;
import py.com.ideasweb.perseo.transaccion.reports.dataSource.JRDataSourceLibroIvaCompra;
import py.com.ideasweb.perseo.transaccion.repositories.CompraCabRepository;
import py.com.ideasweb.perseo.transaccion.services.CompraCabService;
import py.com.ideasweb.perseo.transaccion.services.CompraDetService;

@Service
public class CompraCabServiceImpl extends BaseServiceImpl
        implements CompraCabService {

    @Autowired
    DataSource dataSource;

    @Autowired
    CompraCabMapper mapper;

    @Autowired
    CompraCabRepository repo;

    @Autowired
    CompraDetService compraDetService;

    @Autowired
    ArticuloDepositoService articuloDepositoService;

    @Autowired
    ArticuloMovimientoService articuloMovimientoService;

    @Autowired
    HistoricoPrecioCostoService historicoPrecioCostoService;

    @Autowired
    ArticuloPrecioVentaDetService articuloPrecioVentadetService;

    @Override
    public List<CompraCabDTO> getByturno(Integer idturno) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findByTurnoIdTurno(idturno))
                .stream().peek(c -> {

                    try {
                        c.setDetalles(compraDetService
                                .getByCompraCab(c.getIdCompraCab()));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public String registrarCompra(CompraCabDTO cab, UsuarioDTO usuario)
            throws Exception {

        EstadoCompraDTO ec = new EstadoCompraDTO();
        ec.setIdEstadoCompra(1);
        cab.setEstadoCompra(ec);
        MonedaDTO moneda = new MonedaDTO();
        moneda.setCodMoneda(1);
        cab.setMoneda(moneda);
        cab.setPagado(0.0);
        // cab.setTurno(login.getTurno());
        cab.setSucursal(usuario.getSucursal());
        cab.setUsuario(usuario);
        cab.setEmpresa(usuario.getEmpresa());
        CompraCabDTO newCab = grabar(cab);

        cab.getDetalles().stream().forEach(d -> {

            try {
                d.setCompraCab(newCab);
                compraDetService.grabar(d);

                // controla que no sea un servicio
                if (d.getArticuloDeposito().getIdArticuloDeposito() != null) {

                    // actualizar stock
                    articuloDepositoService.actualizarStock(
                            d.getArticuloDeposito().getIdArticuloDeposito(),
                            Double.valueOf(d.getCantidad()));

                    // registrar el movimiento del articulo
                    ArticuloMovimientoDTO am = new ArticuloMovimientoDTO();
                    am.setArticulo(d.getArticuloDeposito().getArticulo());
                    am.setDeposito(d.getArticuloDeposito().getDeposito());
                    am.setCantidad(Double.valueOf(d.getCantidad()));
                    am.setColumna("I");
                    am.setConceptoMov(new ConceptoMovDTO(6));
                    am.setSucursal(newCab.getSucursal());
                    am.setUsuario(usuario);
                    am.setFecha(new Date(System.currentTimeMillis()));
                    am.setCompraCab(newCab);
                    // am.setTurno(login.getTurno());
                    articuloMovimientoService.grabar(am);

                    // actualizar precio costo
                    // ?

                    // registra el historico precio costo
                    HistoricoPrecioCostoDTO hc = new HistoricoPrecioCostoDTO();
                    hc.setFecha(new Date(System.currentTimeMillis()));
                    hc.setPrecioCosto(d.getPrecio());
                    hc.setArticulo(d.getArticuloDeposito().getArticulo());
                    hc.setUsuario(usuario);
                    hc.setEmpresa(usuario.getEmpresa());
                    historicoPrecioCostoService.grabar(hc);

                    // actualiza el precio de venta
                    articuloPrecioVentadetService
                            .updatePrecioByFamilia(
                                    d.getArticuloDeposito().getArticulo()
                                            .getFamilia().getIdFamilia(),
                                    usuario);

                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        });

        return "Compra registrada correctamente: " + newCab.getIdCompraCab();
    }

    @Override
    public List<CompraCabDTO> getByEmpresaAndFecha(Date fechaDesde,
            Date fechahasta, Integer idEmpresa) throws Exception {

        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresaAndFechaBetween(
                        idEmpresa, fechaDesde, fechahasta))
                .stream().peek(c -> {

                    try {
                        c.setDetalles(compraDetService
                                .getByCompraCab(c.getIdCompraCab()));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public List<CompraCabDTO> getByProveedorAndFecha(Date fechaDesde,
            Date fechahasta, Integer idProveedor) throws Exception {

        return mapper
                .entityListToDtoList(
                        repo.findByProveedorIdProveedorAndFechaBetween(
                                idProveedor, fechaDesde, fechahasta))
                .stream().peek(c -> {

                    try {
                        c.setDetalles(compraDetService
                                .getByCompraCab(c.getIdCompraCab()));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }).collect(Collectors.toList());
    }

    @Override
    public CompraCabDTO getById(Integer idCompraCab) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idCompraCab));
    }

    @Override
    public CompraCabDTO grabar(CompraCabDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public String getLibroIvaCompra(String datos, UsuarioDTO usuarioDTO)
            throws Exception {
        // obtener los parametros del json enviados desde el frontend
        /*
         * { fechadesde: 11/11/2017, fechahasta: 11/11/2017, suc_todas: false,
         * idsucursal: 1 }
         */

        String res = "";

        JSONObject params = new JSONObject(datos);

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String string_fechadesde = params.getString("fechadesde");
        Date fechadesde = new Date(sdf.parse(string_fechadesde).getTime());
        String string_fechahasta = params.getString("fechahasta");
        Date fechahasta = new Date(sdf.parse(string_fechahasta).getTime());

        Integer idsucursal = params.getInt("idsucursal");
        boolean suc_todas = params.getBoolean("suc_todas");
        // boolean factura = params.getBoolean("factura");
        // boolean remision = params.getBoolean("remision");
        // String doc = params.getString("tipo");

        Connection conn = null;
        List<CompraCabDTO> col = new ArrayList<CompraCabDTO>();

        try {

            conn = dataSource.getConnection();

            String select = " select a.idcompracab,a.comprobante,a.idasientocab, a.fecha, a.tipo,  ";
            select += " a.codmoneda, a.cotizacion, a.condicion, a.tipo, a.idproveedor, b.descripcion as proveedor, b.nrodoc, ";
            select += " a.idsucursal, c.nombre as sucursal ";
            select += " from compracab a   ";
            select += " join proveedor b on b.idproveedor = a.idproveedor ";
            select += " join sucursal c on c.idsucursal = a.idsucursal ";
            select += " where fecha between ? and ? and a.idestadocompra in (1,2) and a.tipo in ( 'FA' , 'NC', 'AU' ) ";
            if (!suc_todas) {
                select += " and a.idsucursal =  " + idsucursal;
            }
            select += " order by a.idsucursal, a.tipo, a.fecha, a.comprobante ";

            PreparedStatement ps = conn.prepareStatement(select,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ps.setDate(1, fechadesde);
            ps.setDate(2, fechahasta);

            ResultSet rs = ps.executeQuery();
            rs.beforeFirst();
            int p = 0;
            while (rs.next()) {
                p++;
                CompraCabDTO compra_data = new CompraCabDTO();
                compra_data.setIdCompraCab(rs.getInt("id_compra_cab"));
                compra_data.setComprobante(rs.getString("comprobante"));
                compra_data.setFecha(rs.getDate("fecha"));
                compra_data.setCondicion(rs.getString("condicion"));
                compra_data.setTipo(rs.getString("tipo"));

                ProveedorDTO proveedor = new ProveedorDTO();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setDescripcion(rs.getString("proveedor"));
                proveedor.setNrodoc(rs.getString("nrodoc"));

                compra_data.setProveedor(proveedor);

                // Sucursal
                SucursalDTO sucursal = new SucursalDTO();
                sucursal.setIdSucursal(rs.getInt("idsucursal"));
                sucursal.setDescripcion(rs.getString("sucursal"));
                compra_data.setSucursal(sucursal);

                double importe = 0;
                double gravada10 = 0;
                double gravada5 = 0;
                double iva10 = 0;
                double iva5 = 0;
                double exenta = 0;

                PreparedStatement psx = conn.prepareStatement(
                        "Select * from compradet where idcompracab = ? ");
                psx.setInt(1, rs.getInt("idcompracab"));
                ResultSet rsx = psx.executeQuery();
                int cantidad = 0;

                while (rsx.next()) {
                    if (rsx.getInt("cantidad") > 0) {
                        cantidad += rsx.getInt("cantidad");

                        importe += (rsx.getDouble("precio") * cantidad);
                        if (rsx.getDouble("ivaporcentaje") == 10) {
                            gravada10 += rsx.getDouble("gravada");
                            iva10 += rsx.getDouble("ivaimporte");
                        } else if (rsx.getDouble("ivaporcentaje") == 5) {
                            gravada5 += rsx.getDouble("gravada");
                            iva5 += rsx.getDouble("ivaimporte");
                        } else {
                            exenta += rsx.getDouble("exenta");
                        }
                    }
                }
                psx.close();
                rsx.close();

                compra_data.setImporte(importe);
                compra_data.setGravada10(gravada10);
                compra_data.setGravada5(gravada5);
                compra_data.setIva10(iva10);
                compra_data.setIva5(iva5);
                compra_data.setExenta(exenta);
                if (cantidad > 0) {
                    col.add(compra_data);
                }
            }

            rs.close();
            ps.close();

            InputStream reporte = null;
            JasperPrint print = null;
            Map<String, Object> parameters = new HashMap<String, Object>();

            if (!col.isEmpty()) {

                reporte = this.getClass().getResourceAsStream(
                        "/py/com/ideasweb/perseo/transaccion/reports/JRLibroIvaCompra.jasper");

                JasperReport report = (JasperReport) JRLoader
                        .loadObject(reporte);

                String sReporte = report.getName().substring(
                        report.getName().lastIndexOf(".") + 1,
                        report.getName().length());

                parameters.put("sReporte", sReporte);
                parameters.put("dFechadesde", fechadesde);
                parameters.put("dFechahasta", fechahasta);
                parameters.put("sTitulo", "LIBRO IVA COMPRA");
                parameters.put("dFecha", new Date(System.currentTimeMillis()));

                // res = Utilities.generarReporte("LibroCompra", jr, parameters,
                // new JRDataSourceLibroIvaCompra(col));

                print = JasperFillManager.fillReport(report, parameters,
                        new JRDataSourceLibroIvaCompra(col));

                byte[] reporteF = null;
                reporteF = JasperExportManager.exportReportToPdf(print);
                File tempFileF = File.createTempFile("Libro-Compra", ".pdf",
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
}

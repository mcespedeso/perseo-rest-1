package py.com.ideasweb.perseo.transaccion.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.HistoricoArticuloDTO;
import py.com.ideasweb.perseo.stock.reports.dataSources.JRDataSourceArticulos;
import py.com.ideasweb.perseo.stock.reports.dataSources.JRDataSourceCompras;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;
import py.com.ideasweb.perseo.stock.services.HistoricoArticuloService;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaCabDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaFormaCobroDTO;
import py.com.ideasweb.perseo.transaccion.dtos.TurnoDTO;
import py.com.ideasweb.perseo.transaccion.mapper.TurnoMapper;
import py.com.ideasweb.perseo.transaccion.reports.dataSource.JRDataSourceFP;
import py.com.ideasweb.perseo.transaccion.reports.dataSource.JRDataSourceFacturas;
import py.com.ideasweb.perseo.transaccion.repositories.TurnoRepository;
import py.com.ideasweb.perseo.transaccion.services.CompraCabService;
import py.com.ideasweb.perseo.transaccion.services.FacturaCabService;
import py.com.ideasweb.perseo.transaccion.services.TurnoService;

@Service
public class TurnoServiceImpl extends BaseServiceImpl implements TurnoService {

    @Autowired
    TurnoRepository repo;

    @Autowired
    TurnoMapper mapper;

    @Autowired
    ArticuloDepositoService articuloDepositoService;

    @Autowired
    HistoricoArticuloService historicoArticuloService;
    
    @Autowired
    FacturaCabService facturaCabService;
    
    @Autowired
    CompraCabService compraCabService;

    @Override
    public List<TurnoDTO> getByUsuario(Integer idUsuario, Integer limit)
            throws Exception {
        // TODO Auto-generated method stub
        if (limit == null) {
            return mapper.entityListToDtoList(
                    repo.findByUsuarioIdUsuario(idUsuario));
        } else {
            return mapper.entityListToDtoList(
                    repo.findByUsuarioIdUsuario(idUsuario).stream().limit(limit)
                            .collect(Collectors.toList()));
        }
    }

    @Override
    public TurnoDTO getActivoByUsuario(Integer idusuario) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(
                repo.findByusuarioIdUsuarioAndEstadoTrue(idusuario));
    }

    @Override
    public String generarReporteMovimientoByUsuario(TurnoDTO turno,
            UsuarioDTO usuario) throws Exception {
        String r = "";
        try {
            turno = getById(turno.getIdTurno());
            JasperReport jr = null;
            InputStream reporte = null;
            JasperPrint print = null;
            // jr = (JasperReport)
            // JRLoader.loadObject(getClass().getResourceAsStream("/py/com/perseo/venta/reports/JRFactura.jasper"));

            reporte = this.getClass().getResourceAsStream(
                    "/py/com/ideasweb/perseo/transaccion/reports/JRTurnoMovimiento.jasper");

            JasperReport report = (JasperReport) JRLoader.loadObject(reporte);

            // String reporte = "JRTurnoMovimiento";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("sTitulo", "MOVIMIENTO DE TURNO");
            parameters.put("turno", turno.getIdTurno().toString());
            parameters.put("fechaapertura", turno.getFechaApertura());
            parameters.put("fechacierre", turno.getFechaCierre());

            parameters.put("usuariodes", usuario.getNombreApellido());
            parameters.put("ciuser", usuario.getNroDocumento());

            String responsables = "";

            /*
             * for (int i = 0; i < getJTableResponsables().getRowCount(); i++) {
             * responsables += getJTableResponsables().getValueAt(i, 0) + " - ";
             * }
             */

            // parameters.put("integrantes", responsables);
            parameters.put("integrantes", usuario.getNombreApellido());

            parameters.put("fechacierre", turno.getFechaCierre());

            // traer las facturas por turno
            List<FacturaCabDTO> facturas = facturaCabService
                    .getByturno(turno.getIdTurno());

            List<HistoricoArticuloDTO> listArticulos = articuloDepositoService
                    .getByTurno(turno.getIdTurno(), usuario);

            parameters.put("isfactura", true);
            System.out.println(
                    "imprimiendo la cantidad de fact.  " + facturas.size());
            reporte = this.getClass().getResourceAsStream(
                    "/py/com/ideasweb/perseo/transaccion/reports/JRTurnoMovimiento.jasper");

            InputStream reporte_1 = this.getClass().getResourceAsStream(
                    "/py/com/ideasweb/perseo/transaccion/reports/JRTurnoMovimientoFactura.jasper");
            JasperReport JRSubFacturas = (JasperReport) JRLoader
                    .loadObject(reporte_1);

            parameters.put("JRDataSourceFacturas",
                    new JRDataSourceFacturas(facturas));
            parameters.put("JRSubFacturas", JRSubFacturas);

            // cambiar por movimientos de articulos
            /// JasperReport JRSubArticulos = (JasperReport)
            // JRLoader.loadObject(getClass().getResourceAsStream("/py/com/perseo/venta/reports/JRTurnoMovimientoArticulos.jasper"));

            InputStream reporte_2 = this.getClass().getResourceAsStream(
                    "/py/com/ideasweb/perseo/transaccion/reports/JRTurnoMovimientoArticulos.jasper");
            JasperReport JRSubArticulos = (JasperReport) JRLoader
                    .loadObject(reporte_2);

            parameters.put("JRDataSourceArticulos",
                    new JRDataSourceArticulos(listArticulos));
            parameters.put("JRSubArticulos", JRSubArticulos);

            List<FacturaFormaCobroDTO> listFormaPago = new ArrayList<FacturaFormaCobroDTO>();
            for (FacturaCabDTO element : facturas) {
                for (FacturaFormaCobroDTO facturaformacobro : element
                        .getListFormaPago()) {
                    listFormaPago.add(facturaformacobro);
                }
            }

            InputStream reporte_3 = this.getClass().getResourceAsStream(
                    "/py/com/ideasweb/perseo/transaccion/reports/JRFormapago.jasper");
            JasperReport JRSubFormapago = (JasperReport) JRLoader
                    .loadObject(reporte_3);

            // JasperReport JRSubFormapago = (JasperReport)
            // JRLoader.loadObject(getClass().getResourceAsStream("/py/com/perseo/venta/reports/JRFormapago.jasper"));
            parameters.put("JRDataSourceFP", new JRDataSourceFP(listFormaPago));
            parameters.put("JRSubFormapago", JRSubFormapago);

            List<CompraCabDTO> listGastos = compraCabService
                    .getByturno(turno.getIdTurno());

            InputStream reporte_4 = this.getClass().getResourceAsStream(
                    "/py/com/ideasweb/perseo/transaccion/reports/JRTurnoMovimientoCompras.jasper");
            JasperReport JRSubCompras = (JasperReport) JRLoader
                    .loadObject(reporte_4);
            // JasperReport JRSubCompras = (JasperReport)
            // JRLoader.loadObject(getClass().getResourceAsStream("/py/com/perseo/venta/reports/JRTurnoMovimientoCompras.jasper"));
            parameters.put("JRDataSourceCompras",
                    new JRDataSourceCompras(listGastos));
            parameters.put("JRSubCompras", JRSubCompras);

            print = JasperFillManager.fillReport(report, parameters,
                    new JRDataSourceArticulos(listArticulos));

            byte[] reporteF = null;
            reporteF = JasperExportManager.exportReportToPdf(print);
            File tempFileF = File.createTempFile("Turno-Mov", ".pdf", null);
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
    public String cerrarTurnoByUsuario(TurnoDTO turno, UsuarioDTO usuario)
            throws Exception {
        // TODO Auto-generated method stub
        turno = getById(turno.getIdTurno());
        turno.setFechaCierre(new Timestamp(System.currentTimeMillis()));
        turno.setEstado(false);

        turno = grabar(turno);

        // cerrar el historico
        List<HistoricoArticuloDTO> histart = articuloDepositoService
                .getByTurno(turno.getIdTurno(), usuario);

        histart.stream().forEach(h -> {
            // insertar historico articulo
            if (h.getAnterior() == null)
                h.setAnterior(new Double(0));

            try {
                historicoArticuloService.grabar(h);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        // generar el reporte

        return generarReporteMovimientoByUsuario(turno, usuario);
    }

    @Override
    public TurnoDTO getById(Integer idTurno) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idTurno).get());
    }

    @Override
    public TurnoDTO grabar(TurnoDTO turno) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(turno)));
    }

}

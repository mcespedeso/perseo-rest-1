package py.com.ideasweb.perseo.app.facturacion.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.app.cliente.service.ClienteLiteService;
import py.com.ideasweb.perseo.app.facturacion.model.FacturaLitecab;
import py.com.ideasweb.perseo.app.facturacion.model.FacturaLitedet;
import py.com.ideasweb.perseo.app.usuario.model.UsuarioLite;
import py.com.ideasweb.perseo.app.usuario.service.UsuarioLiteService;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.seguridad.services.UsuarioService;

@Service
public class FacturaLiteServiceImpl implements FacturaLiteService {

    @Autowired
    DataSource dataSource;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClienteLiteService clienteService;

    @Override
    public void addFacturas(List<FacturaLitecab> facturas, Integer idUsuario) throws Exception {

        Connection conn = null;

        try {

            System.out.println(facturas.size());

            conn = dataSource.getConnection();

            for (FacturaLitecab cab : facturas) {

                System.out.println("insertando");

                Integer idcab = new Integer(0);
                String sql_seq = " SELECT nextval('factura_cab_id_factura_cab_seq')  as id ";

                PreparedStatement psseq = conn.prepareStatement(sql_seq);
                ResultSet rsset = psseq.executeQuery();

                while (rsset.next()) {
                    idcab = rsset.getInt("id");
                }
                UsuarioDTO user = usuarioService.getUserById(cab.getIdUsuario());

                if (cab.getIdCliente() == 0) {
                    cab.setIdCliente(clienteService
                            .findByDoc(cab.getNroDocumentoCliente())
                            .getIdCliente());
                }

                String sql = " insert into factura_cab ";
                sql += " (fecha,fechalog,id_cliente,id_usuario,nro_documento_cliente,direccion_cliente, ";
                sql += " telefono_cliente,timbrado,establecimiento,punto_expedicion,numero_factura, ";
                sql += " tipo_factura,importe,estado,sincronizado_core,fecha_hora_sincronizacion_core, ";
                sql += " id_empresa, id_factura_cab ) ";
                sql += " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

                PreparedStatement pscab = conn.prepareStatement(sql);
                pscab.setDate(1, cab.getFecha());
                pscab.setTimestamp(2,
                        new Timestamp(System.currentTimeMillis()));
                pscab.setInt(3, cab.getIdCliente());
                pscab.setInt(4, cab.getIdUsuario());
                pscab.setString(5, cab.getNroDocumentoCliente());
                pscab.setString(6, cab.getDireccionCliente());
                pscab.setString(7, cab.getTelefonoCliente());
                pscab.setString(8, cab.getTimbrado());
                pscab.setInt(9, cab.getEstablecimiento());
                pscab.setInt(10, cab.getPuntoExpedicion());
                pscab.setInt(11, cab.getNumeroFactura());
                pscab.setString(12, cab.getTipoFactura());
                pscab.setDouble(13, cab.getImporte());
                pscab.setBoolean(14, true);
                pscab.setBoolean(15, false);
                pscab.setNull(16, Types.TIMESTAMP);
                pscab.setNull(16, Types.TIMESTAMP);
                pscab.setInt(17, user.getEmpresa().getIdEmpresa());
                pscab.setInt(18, idcab);
                pscab.executeUpdate();

                // detalle

                for (FacturaLitedet det : cab.getFacturadet()) {

                    String sqldet = " insert into factura_det ( ";
                    sqldet += " id_factura_cab,id_articulo,concepto,cantidad,precio_venta,tasa_iva,sub_total,impuesto) ";
                    sqldet += " values (?,?,?,?,?,?,?,?) ";
                    PreparedStatement psdet = conn.prepareStatement(sqldet);
                    psdet.setInt(1, idcab);
                    psdet.setInt(2, det.getIdArticulo());
                    psdet.setString(3, det.getConcepto());
                    psdet.setDouble(4, det.getCantidad());
                    psdet.setDouble(5, det.getPrecioVenta());
                    psdet.setDouble(6, det.getTasaIva());
                    psdet.setDouble(7, det.getSubTotal());
                    psdet.setDouble(8, det.getImpuesto());
                    psdet.executeUpdate();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<FacturaLitecab> getFacturas(String apiKey, Integer limit)
            throws Exception {

        Connection conn = null;
        List<FacturaLitecab> list = new ArrayList<FacturaLitecab>();

        try {
            conn = dataSource.getConnection();

            String sql = " select * from factura_cab order by fecha desc ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FacturaLitecab cab = new FacturaLitecab();
                cab.setIdFacturaCab(rs.getInt("id_factura_cab"));

                cab.setFecha(rs.getDate("fecha"));

                cab.setFecha(rs.getDate("fechalog"));
                cab.setIdCliente(rs.getInt("id_cliente"));
                cab.setIdUsuario(rs.getInt("id_usuario"));
                cab.setNroDocumentoCliente(
                        rs.getString("nro_documento_cliente"));
                cab.setDireccionCliente(rs.getString("direccion_cliente"));
                cab.setTelefonoCliente(rs.getString("telefono_cliente"));
                cab.setTimbrado(rs.getString("timbrado"));
                cab.setEstablecimiento(rs.getInt("establecimiento"));
                cab.setPuntoExpedicion(rs.getInt("punto_expedicion"));
                cab.setNumeroFactura(rs.getInt("numero_factura"));
                cab.setTipoFactura(rs.getString("tipo_factura"));
                cab.setImporte(rs.getDouble("importe"));
                cab.setEstado(rs.getBoolean("estado"));
                cab.setIdEmpresa(rs.getInt("id_empresa"));

                String sql_det = "select * from factura_det where id_factura_cab = ?";

                PreparedStatement ps_det = conn.prepareStatement(sql_det);
                ps_det.setInt(1, rs.getInt("id_factura_cab"));

                ResultSet rs_det = ps_det.executeQuery();

                List<FacturaLitedet> listdet = new ArrayList<FacturaLitedet>();

                while (rs_det.next()) {
                    FacturaLitedet det = new FacturaLitedet();
                    det.setIdFacturaDet(rs_det.getInt("id_factura_det"));
                    det.setIdFacturaCab(rs_det.getInt("id_factura_cab"));
                    det.setIdArticulo(rs_det.getInt("id_articulo"));
                    det.setConcepto(rs_det.getString("concepto"));
                    det.setCantidad(rs_det.getDouble("cantidad"));
                    det.setPrecioVenta(rs_det.getDouble("precio_venta"));
                    det.setTasaIva(rs_det.getDouble("tasa_iva"));
                    det.setSubTotal(rs_det.getDouble("sub_total"));
                    det.setImpuesto(rs_det.getDouble("impuesto"));

                    listdet.add(det);
                }

                cab.setFacturadet(listdet);

                list.add(cab);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }

    @Override
    public List<FacturaLitecab> getFacturasByEmpresa(Integer idEmpresa,
            String fechadesde, String fechahasta) throws Exception {
        Connection conn = null;
        List<FacturaLitecab> list = new ArrayList<FacturaLitecab>();

        try {
            conn = dataSource.getConnection();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date starDate = sdf.parse(fechadesde);
            java.util.Date endDate = sdf.parse(fechahasta);

            String sql = " select * from factura_cab ";
            sql += " where id_empresa = ? an fecha between ?  and ? ";
            sql += " order by fecha desc ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idEmpresa);
            ps.setDate(2, new Date(starDate.getTime()));
            ps.setDate(3, new Date(endDate.getTime()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FacturaLitecab cab = new FacturaLitecab();
                cab.setIdFacturaCab(rs.getInt("id_factura_cab"));

                cab.setFecha(rs.getDate("fecha"));

                cab.setFecha(rs.getDate("fechalog"));
                cab.setIdCliente(rs.getInt("id_cliente"));
                cab.setIdUsuario(rs.getInt("id_usuario"));
                cab.setNroDocumentoCliente(
                        rs.getString("nro_documento_cliente"));
                cab.setDireccionCliente(rs.getString("direccion_cliente"));
                cab.setTelefonoCliente(rs.getString("telefono_cliente"));
                cab.setTimbrado(rs.getString("timbrado"));
                cab.setEstablecimiento(rs.getInt("establecimiento"));
                cab.setPuntoExpedicion(rs.getInt("punto_expedicion"));
                cab.setNumeroFactura(rs.getInt("numero_factura"));
                cab.setTipoFactura(rs.getString("tipo_factura"));
                cab.setImporte(rs.getDouble("importe"));
                cab.setEstado(rs.getBoolean("estado"));
                cab.setIdEmpresa(rs.getInt("id_empresa"));

                String sql_det = "select * from factura_det where id_factura_cab = ?";

                PreparedStatement ps_det = conn.prepareStatement(sql_det);
                ps_det.setInt(1, rs.getInt("id_factura_cab"));

                ResultSet rs_det = ps_det.executeQuery();

                List<FacturaLitedet> listdet = new ArrayList<FacturaLitedet>();

                while (rs_det.next()) {
                    FacturaLitedet det = new FacturaLitedet();
                    det.setIdFacturaDet(rs_det.getInt("id_factura_det"));
                    det.setIdFacturaCab(rs_det.getInt("id_factura_cab"));
                    det.setIdArticulo(rs_det.getInt("id_articulo"));
                    det.setConcepto(rs_det.getString("concepto"));
                    det.setCantidad(rs_det.getDouble("cantidad"));
                    det.setPrecioVenta(rs_det.getDouble("precio_venta"));
                    det.setTasaIva(rs_det.getDouble("tasa_iva"));
                    det.setSubTotal(rs_det.getDouble("sub_total"));
                    det.setImpuesto(rs_det.getDouble("impuesto"));
                    listdet.add(det);
                }

                cab.setFacturadet(listdet);

                list.add(cab);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }

    @Override
    public List<FacturaLitecab> getFacturasByUsuario(Integer idUsuario,
            Integer limit) throws Exception {

        Connection conn = null;
        List<FacturaLitecab> list = new ArrayList<FacturaLitecab>();

        try {
            conn = dataSource.getConnection();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

            String sql = " select * from factura_cab ";
            sql += " where id_usuario = ? ";
            sql += " order by fecha desc ";
            if (limit != null)
                sql += " limit " + limit;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FacturaLitecab cab = new FacturaLitecab();
                cab.setIdFacturaCab(rs.getInt("id_factura_cab"));

                cab.setFecha(rs.getDate("fecha"));

                cab.setFecha(rs.getDate("fechalog"));
                cab.setIdCliente(rs.getInt("id_cliente"));
                cab.setIdUsuario(rs.getInt("id_usuario"));
                cab.setNroDocumentoCliente(
                        rs.getString("nro_documento_cliente"));
                cab.setDireccionCliente(rs.getString("direccion_cliente"));
                cab.setTelefonoCliente(rs.getString("telefono_cliente"));
                cab.setTimbrado(rs.getString("timbrado"));
                cab.setEstablecimiento(rs.getInt("establecimiento"));
                cab.setPuntoExpedicion(rs.getInt("punto_expedicion"));
                cab.setNumeroFactura(rs.getInt("numero_factura"));
                cab.setTipoFactura(rs.getString("tipo_factura"));
                cab.setImporte(rs.getDouble("importe"));
                cab.setEstado(rs.getBoolean("estado"));
                cab.setIdEmpresa(rs.getInt("id_empresa"));

                String sql_det = "select * from factura_det where id_factura_cab = ?";

                PreparedStatement ps_det = conn.prepareStatement(sql_det);
                ps_det.setInt(1, rs.getInt("id_factura_cab"));

                ResultSet rs_det = ps_det.executeQuery();

                List<FacturaLitedet> listdet = new ArrayList<FacturaLitedet>();

                while (rs_det.next()) {
                    FacturaLitedet det = new FacturaLitedet();
                    det.setIdFacturaDet(rs_det.getInt("id_factura_det"));
                    det.setIdFacturaCab(rs_det.getInt("id_factura_cab"));
                    det.setIdArticulo(rs_det.getInt("id_articulo"));
                    det.setConcepto(rs_det.getString("concepto"));
                    det.setCantidad(rs_det.getDouble("cantidad"));
                    det.setPrecioVenta(rs_det.getDouble("precio_venta"));
                    det.setTasaIva(rs_det.getDouble("tasa_iva"));
                    det.setSubTotal(rs_det.getDouble("sub_total"));
                    det.setImpuesto(rs_det.getDouble("impuesto"));
                    listdet.add(det);
                }

                cab.setFacturadet(listdet);

                list.add(cab);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;

    }

    @Override
    public void addFactura(FacturaLitecab cab, Integer idUsuario) throws Exception {

        Connection conn = null;

        try {

            //UsuarioDTO owner = usuarioService.getUserById(idUsuario);
                    
            conn = dataSource.getConnection();

            System.out.println("insertando factura..");

            Integer idcab = new Integer(0);
            String sql_seq = " SELECT nextval('factura_cab_id_factura_cab_seq')  as id ";

            PreparedStatement psseq = conn.prepareStatement(sql_seq);
            ResultSet rsset = psseq.executeQuery();

            while (rsset.next()) {
                idcab = rsset.getInt("id");
            }
            UsuarioDTO user = usuarioService.getUserById(cab.getIdUsuario());

            if (cab.getIdCliente() == 0) {
                cab.setIdCliente(clienteService
                        .findByDoc(cab.getNroDocumentoCliente())
                        .getIdCliente());
            }

            String sql = " insert into factura_cab ";
            sql += " (fecha,fechalog,id_cliente,id_usuario,nro_documento_cliente,direccion_cliente, ";
            sql += " telefono_cliente,timbrado,establecimiento,punto_expedicion,numero_factura, ";
            sql += " tipo_factura,importe,estado,sincronizado_core,fecha_hora_sincronizacion_core, ";
            sql += " id_empresa, id_factura_cab ) ";
            sql += " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            PreparedStatement pscab = conn.prepareStatement(sql);
            pscab.setDate(1, cab.getFecha());
            pscab.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pscab.setInt(3, cab.getIdCliente());
            pscab.setInt(4, cab.getIdUsuario());
            pscab.setString(5, cab.getNroDocumentoCliente());
            pscab.setString(6, cab.getDireccionCliente());
            pscab.setString(7, cab.getTelefonoCliente());
            pscab.setString(8, cab.getTimbrado());
            pscab.setInt(9, cab.getEstablecimiento());
            pscab.setInt(10, cab.getPuntoExpedicion());
            pscab.setInt(11, cab.getNumeroFactura());
            pscab.setString(12, cab.getTipoFactura());
            pscab.setDouble(13, cab.getImporte());
            pscab.setBoolean(14, true);
            pscab.setBoolean(15, false);
            pscab.setNull(16, Types.TIMESTAMP);
            pscab.setNull(16, Types.TIMESTAMP);
            pscab.setInt(17, user.getEmpresa().getIdEmpresa());
            pscab.setInt(18, idcab);
            pscab.executeUpdate();

            // detalle

            for (FacturaLitedet det : cab.getFacturadet()) {

                String sqldet = " insert into factura_det ( ";
                sqldet += " id_factura_cab,id_articulo,concepto,cantidad,precio_venta,tasa_iva,sub_total,impuesto) ";
                sqldet += " values (?,?,?,?,?,?,?,?) ";
                PreparedStatement psdet = conn.prepareStatement(sqldet);
                psdet.setInt(1, idcab);
                psdet.setInt(2, det.getIdArticulo());
                psdet.setString(3, det.getConcepto());
                psdet.setDouble(4, det.getCantidad());
                psdet.setDouble(5, det.getPrecioVenta());
                psdet.setDouble(6, det.getTasaIva());
                psdet.setDouble(7, det.getSubTotal());
                psdet.setDouble(8, det.getImpuesto());
                psdet.executeUpdate();

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaCabDTO;
import py.com.ideasweb.perseo.transaccion.dtos.VentaCabDTO;

public interface FacturaCabService {

    List<FacturaCabDTO> getBySucursal(Boolean allEstados, Boolean estado,
            Boolean allTipos, Integer idtipofactura, Integer idsucursal)
            throws Exception;

    List<FacturaCabDTO> getByCliente(Integer idcliente, Boolean all,
            Boolean estado) throws Exception;

    FacturaCabDTO cobrarFactura(Integer idfacturacab, UsuarioDTO usuarioDTO)
            throws Exception;

    List<FacturaCabDTO> getByturno(Integer idturno) throws Exception;

    FacturaCabDTO grabar(FacturaCabDTO factura) throws Exception;

    FacturaCabDTO getById(Integer idFacturaCab) throws Exception;

    // movi de venta
    String registrarVentaRapida(VentaCabDTO ventaCab, UsuarioDTO usuario)
            throws Exception;

    String getLibroIvaVentaContable(String datos, UsuarioDTO usuario)
            throws Exception;

    String imprimirTicket(FacturaCabDTO facturaCab, UsuarioDTO usuario)
            throws Exception;

    String imprimirNormal(FacturaCabDTO facturaCab) throws Exception;
}

package py.com.ideasweb.perseo.transaccion.services;

import java.sql.Date;
import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.transaccion.dtos.VentaCabDTO;

public interface VentaCabService {

    VentaCabDTO getById(Integer idVentaCab) throws Exception;

    VentaCabDTO grabar(VentaCabDTO dto) throws Exception;

    List<VentaCabDTO> findByEmpresaAndFechas(Integer idEmpresa, Date fechadesde,
            Date fechaHasta) throws Exception;

    List<VentaCabDTO> getByEstadoAndSucursal(Integer estado, Integer idSucursal)
            throws Exception;

    List<VentaCabDTO> getByCliente(Integer idcliente, Boolean all,
            Integer idestado) throws Exception;

    VentaCabDTO registrarPedido(VentaCabDTO ventacab, UsuarioDTO usuario)
            throws Exception;

}

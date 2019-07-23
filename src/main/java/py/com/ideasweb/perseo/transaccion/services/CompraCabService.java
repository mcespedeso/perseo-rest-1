package py.com.ideasweb.perseo.transaccion.services;

import java.sql.Date;
import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;

public interface CompraCabService {

    List<CompraCabDTO> getByturno(Integer idturno) throws Exception;

    String registrarCompra(CompraCabDTO cab, UsuarioDTO usuario)
            throws Exception;

    List<CompraCabDTO> getByEmpresaAndFecha(Date fechaDesde, Date fechahasta,
            Integer idEmpresa) throws Exception;

    List<CompraCabDTO> getByProveedorAndFecha(Date fechaDesde, Date fechahasta,
            Integer idProveedor) throws Exception;

    String getLibroIvaCompra(String datos, UsuarioDTO usuarioDTO)
            throws Exception;

    CompraCabDTO getById(Integer idCompraCab) throws Exception;
    
    CompraCabDTO grabar(CompraCabDTO dto) throws Exception;
}

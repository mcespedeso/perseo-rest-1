package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.TipoFacturaDTO;

public interface TipoFacturaService {

    TipoFacturaDTO grabar(TipoFacturaDTO dto) throws Exception;

    List<TipoFacturaDTO> findAll() throws Exception;

    TipoFacturaDTO getById(Integer idTipoFactura) throws Exception;
}

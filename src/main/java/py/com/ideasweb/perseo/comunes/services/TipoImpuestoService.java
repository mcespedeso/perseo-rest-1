package py.com.ideasweb.perseo.comunes.services;

import java.util.List;

import py.com.ideasweb.perseo.comunes.dtos.TipoImpuestoDTO;

public interface TipoImpuestoService {

    TipoImpuestoDTO grabar(TipoImpuestoDTO tipoImpuesto) throws Exception;

    List<TipoImpuestoDTO> findAll() throws Exception;

    TipoImpuestoDTO getById(Integer idTipoImpuesto) throws Exception;
}

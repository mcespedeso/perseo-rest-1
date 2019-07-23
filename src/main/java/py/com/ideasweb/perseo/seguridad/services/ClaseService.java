package py.com.ideasweb.perseo.seguridad.services;

import py.com.ideasweb.perseo.seguridad.dtos.ClaseDTO;

public interface ClaseService {

    ClaseDTO getById(Integer idClas) throws Exception;

    ClaseDTO grabar(ClaseDTO dto) throws Exception;

}

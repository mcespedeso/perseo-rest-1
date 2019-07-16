package py.com.ideasweb.perseo.comunes.services;

import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;

public interface EmpresaService {
    
    EmpresaDTO getByID(Integer idEmpresa) throws Exception;

}

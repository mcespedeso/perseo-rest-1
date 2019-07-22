package py.com.ideasweb.perseo.comunes.services;

import java.util.List;

import py.com.ideasweb.perseo.comunes.dtos.ProveedorDTO;

public interface ProveedorService {

    List<ProveedorDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    List<ProveedorDTO> getProveedorByParamsAndEmpresa(String parametro,
            Integer idEmpresa) throws Exception;
    
    ProveedorDTO grabar(ProveedorDTO proveedorDTO) throws Exception;

}

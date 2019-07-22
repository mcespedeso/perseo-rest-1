package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.CajaCuentaDTO;

public interface CajaCuentaService {

    CajaCuentaDTO findById(Integer idCajaCuenta) throws Exception;
    
    CajaCuentaDTO grabar(CajaCuentaDTO dto) throws Exception;
    
    List<CajaCuentaDTO> getByBanco(Integer idBanco) throws Exception;
}

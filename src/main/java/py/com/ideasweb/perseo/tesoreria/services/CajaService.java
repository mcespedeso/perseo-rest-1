package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.CajaDTO;

public interface CajaService {

    CajaDTO getById(Integer idCaja) throws Exception;

    List<CajaDTO> findByEmpresa(Integer idEmpresa) throws Exception;
    
    List<CajaDTO> findBySucursal(Integer idSucursal) throws Exception;

    CajaDTO grabar(CajaDTO dto) throws Exception;
}

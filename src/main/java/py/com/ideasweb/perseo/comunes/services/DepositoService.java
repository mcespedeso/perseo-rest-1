package py.com.ideasweb.perseo.comunes.services;

import java.util.List;

import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;

public interface DepositoService {

    List<DepositoDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    List<DepositoDTO> getBySucursal(Integer idSucursal) throws Exception;
    
    DepositoDTO grabar(DepositoDTO dto) throws Exception;

}

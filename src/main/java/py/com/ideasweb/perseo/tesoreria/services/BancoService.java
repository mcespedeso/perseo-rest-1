package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.BancoDTO;

public interface BancoService {
    
    BancoDTO getById(Integer idBanco) throws Exception;
    
    List<BancoDTO> findByEmpresa(Integer idEmpresa) throws Exception;
    
    BancoDTO grabar(BancoDTO dto) throws Exception;

}

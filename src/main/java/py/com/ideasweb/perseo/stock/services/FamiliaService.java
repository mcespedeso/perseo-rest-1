package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.FamiliaDTO;

public interface FamiliaService {

    FamiliaDTO getByID(Integer idFamilia) throws Exception;
    
    List<FamiliaDTO> getByEmpresa(Integer idEmpresa) throws Exception;
    
    FamiliaDTO grabar(FamiliaDTO dto) throws Exception;
}

package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.MarcaDTO;

public interface MarcaService {

    MarcaDTO getByID(Integer idMarca) throws Exception;

    List<MarcaDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    MarcaDTO grabar(MarcaDTO dto) throws Exception;

}

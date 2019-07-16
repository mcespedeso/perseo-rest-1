package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.UnidadMedidaDTO;

public interface UnidadMedidaService {

    UnidadMedidaDTO getByID(Integer idUnidadMedida) throws Exception;

    List<UnidadMedidaDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    UnidadMedidaDTO grabar(UnidadMedidaDTO dto) throws Exception;

}

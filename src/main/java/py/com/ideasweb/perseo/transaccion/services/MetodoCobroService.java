package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.MetodoCobroDTO;

public interface MetodoCobroService {

    MetodoCobroDTO grabar(MetodoCobroDTO dto) throws Exception;

    List<MetodoCobroDTO> findAll() throws Exception;

    List<MetodoCobroDTO> findByEmpresa(Integer idEmpresa) throws Exception;

    MetodoCobroDTO getById(Integer idMetodoCobro) throws Exception;
}

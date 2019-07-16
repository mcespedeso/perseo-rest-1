package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.ConceptoMovDTO;

public interface ConceptoMovService {

    ConceptoMovDTO grabar(ConceptoMovDTO dto) throws Exception;

    List<ConceptoMovDTO> findAll() throws Exception;

    ConceptoMovDTO getById(Integer idConceptoMov) throws Exception;
}

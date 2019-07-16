package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.ConceptoMovDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.ConceptoMovMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.ConceptoMovRepository;
import py.com.ideasweb.perseo.tesoreria.services.ConceptoMovService;

@Service
public class ConceptoMovServiceImpl extends BaseServiceImpl
        implements ConceptoMovService {

    @Autowired
    ConceptoMovMapper mapper;

    @Autowired
    ConceptoMovRepository repo;

    @Override
    public ConceptoMovDTO grabar(ConceptoMovDTO dto) throws Exception {
        // TODO Auto-generated method stub

        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<ConceptoMovDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public ConceptoMovDTO getById(Integer idConceptoMov) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idConceptoMov).get());
    }

}

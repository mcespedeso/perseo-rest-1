package py.com.ideasweb.perseo.seguridad.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.ClaseDTO;
import py.com.ideasweb.perseo.seguridad.mapper.ClaseMapper;
import py.com.ideasweb.perseo.seguridad.repositories.ClaseRepository;
import py.com.ideasweb.perseo.seguridad.services.ClaseService;

@Service
public class ClaseServiceImpl extends BaseServiceImpl implements ClaseService {

    @Autowired
    ClaseRepository repo;

    @Autowired
    ClaseMapper mapper;

    @Override
    public ClaseDTO getById(Integer idClase) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idClase));
    }

    @Override
    public ClaseDTO grabar(ClaseDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

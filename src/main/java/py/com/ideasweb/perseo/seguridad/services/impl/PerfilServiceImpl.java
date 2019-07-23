package py.com.ideasweb.perseo.seguridad.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.PerfilDTO;
import py.com.ideasweb.perseo.seguridad.mapper.PerfilMapper;
import py.com.ideasweb.perseo.seguridad.repositories.PerfilRepository;
import py.com.ideasweb.perseo.seguridad.services.PerfilService;

@Service
public class PerfilServiceImpl extends BaseServiceImpl
        implements PerfilService {

    @Autowired
    PerfilRepository repo;

    @Autowired
    PerfilMapper mapper;

    @Override
    public PerfilDTO getById(Integer idpefil) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idpefil));
    }

    @Override
    public List<PerfilDTO> getAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public PerfilDTO add(PerfilDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<PerfilDTO> getByEstado(Boolean estado) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findByEstado(estado));
    }

}

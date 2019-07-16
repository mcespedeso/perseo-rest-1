package py.com.ideasweb.perseo.comunes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.TipoImpuestoDTO;
import py.com.ideasweb.perseo.comunes.mapper.TipoImpuestoMapper;
import py.com.ideasweb.perseo.comunes.repositories.TipoImpuestoRepository;
import py.com.ideasweb.perseo.comunes.services.TipoImpuestoService;

@Service
public class TipoImpuestoServiceImpl extends BaseServiceImpl
        implements TipoImpuestoService {

    @Autowired
    TipoImpuestoMapper mapper;

    @Autowired
    TipoImpuestoRepository repo;

    @Override
    public TipoImpuestoDTO grabar(TipoImpuestoDTO tipoImpuesto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(tipoImpuesto)));
    }

    @Override
    public List<TipoImpuestoDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public TipoImpuestoDTO getById(Integer idTipoImpuesto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idTipoImpuesto).get());
    }

}

package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.transaccion.dtos.TipoFacturaDTO;
import py.com.ideasweb.perseo.transaccion.mapper.TipoFacturaMapper;
import py.com.ideasweb.perseo.transaccion.repositories.TipoFacturaRepository;
import py.com.ideasweb.perseo.transaccion.services.TipoFacturaService;

@Service
public class TipoFacturaServiceImpl extends BaseEntity
        implements TipoFacturaService {

    @Autowired
    TipoFacturaMapper mapper;

    @Autowired
    TipoFacturaRepository repo;

    @Override
    public TipoFacturaDTO grabar(TipoFacturaDTO dto) throws Exception {
        // TODO Auto-generated method stub

        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<TipoFacturaDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public TipoFacturaDTO getById(Integer idTipoFactura) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idTipoFactura).get());
    }

}

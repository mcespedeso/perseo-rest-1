package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.transaccion.dtos.EstadoVentaDTO;
import py.com.ideasweb.perseo.transaccion.mapper.EstadoVentaMapper;
import py.com.ideasweb.perseo.transaccion.repositories.EstadoVentaRepository;
import py.com.ideasweb.perseo.transaccion.services.EstadoVentaService;

@Service
public class EstadoVentaServiceImpl extends BaseEntity
        implements EstadoVentaService {

    @Autowired
    EstadoVentaMapper mapper;

    @Autowired
    EstadoVentaRepository repo;

    @Override
    public EstadoVentaDTO grabar(EstadoVentaDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<EstadoVentaDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public EstadoVentaDTO getById(Integer idEstadoVenta) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idEstadoVenta).get());
    }

}

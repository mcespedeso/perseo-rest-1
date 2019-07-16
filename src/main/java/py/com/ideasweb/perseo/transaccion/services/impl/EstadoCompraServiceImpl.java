package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.EstadoCompraDTO;
import py.com.ideasweb.perseo.transaccion.mapper.EstadoCompraMapper;
import py.com.ideasweb.perseo.transaccion.repositories.EstadoCompraRepository;
import py.com.ideasweb.perseo.transaccion.services.EstadoCompraService;

@Service
public class EstadoCompraServiceImpl extends BaseServiceImpl
        implements EstadoCompraService {

    @Autowired
    EstadoCompraMapper mapper;

    @Autowired
    EstadoCompraRepository repo;

    @Override
    public EstadoCompraDTO grabar(EstadoCompraDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<EstadoCompraDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public EstadoCompraDTO getById(Integer idEstadoCompra) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idEstadoCompra).get());
    }

}

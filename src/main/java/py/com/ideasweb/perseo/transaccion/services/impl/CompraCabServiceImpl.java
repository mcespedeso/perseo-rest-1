package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;
import py.com.ideasweb.perseo.transaccion.mapper.CompraCabMapper;
import py.com.ideasweb.perseo.transaccion.repositories.CompraCabRepository;
import py.com.ideasweb.perseo.transaccion.services.CompraCabService;

@Service
public class CompraCabServiceImpl extends BaseServiceImpl
        implements CompraCabService {

    @Autowired
    CompraCabMapper mapper;

    @Autowired
    CompraCabRepository repo;

    @Override
    public List<CompraCabDTO> getByturno(Integer idturno) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findByTurnoIdTurno(idturno));
    }

}

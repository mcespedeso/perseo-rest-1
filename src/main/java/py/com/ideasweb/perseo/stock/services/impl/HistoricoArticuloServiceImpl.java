package py.com.ideasweb.perseo.stock.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.HistoricoArticuloDTO;
import py.com.ideasweb.perseo.stock.mapper.HistoricoArticuloMapper;
import py.com.ideasweb.perseo.stock.repositories.HistoricoArticuloRepository;
import py.com.ideasweb.perseo.stock.services.HistoricoArticuloService;

@Service
public class HistoricoArticuloServiceImpl extends BaseServiceImpl
        implements HistoricoArticuloService {

    @Autowired
    HistoricoArticuloMapper mapper;

    @Autowired
    HistoricoArticuloRepository repo;

    @Override
    public HistoricoArticuloDTO grabar(
            HistoricoArticuloDTO historicoArticuloDTO) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(
                repo.save(mapper.dtoToEntity(historicoArticuloDTO)));
    }

}

package py.com.ideasweb.perseo.stock.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioCostoDTO;
import py.com.ideasweb.perseo.stock.mapper.HistoricoPrecioCostoMapper;
import py.com.ideasweb.perseo.stock.repositories.HistoricoPrecioCostoRepository;
import py.com.ideasweb.perseo.stock.services.HistoricoPrecioCostoService;

@Service
public class HistoricoPrecioCostoServiceImpl extends BaseServiceImpl
        implements HistoricoPrecioCostoService {

    @Autowired
    HistoricoPrecioCostoRepository repo;

    @Autowired
    HistoricoPrecioCostoMapper mapper;

    @Override
    public HistoricoPrecioCostoDTO grabar(HistoricoPrecioCostoDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public Double getPromedioCostoByArticulo(Integer idArticulo)
            throws Exception {
        // TODO Auto-generated method stub
        return repo.findPromedioCostoByArticulo(idArticulo);
    }

}

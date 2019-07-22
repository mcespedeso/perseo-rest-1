package py.com.ideasweb.perseo.stock.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioVentaDTO;
import py.com.ideasweb.perseo.stock.mapper.HistoricoPrecioVentaMapper;
import py.com.ideasweb.perseo.stock.repositories.HistoricoPrecioVentaRepository;
import py.com.ideasweb.perseo.stock.services.HistoricoPrecioVentaService;

@Service
public class HistoricoPrecioVentaServiceImpl extends BaseServiceImpl
        implements HistoricoPrecioVentaService {

    @Autowired
    HistoricoPrecioVentaMapper mapper;

    @Autowired
    HistoricoPrecioVentaRepository repo;

    @Override
    public HistoricoPrecioVentaDTO grabar(HistoricoPrecioVentaDTO dto)
            throws Exception {
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

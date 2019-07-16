package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.MonedaMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.MonedaRepository;
import py.com.ideasweb.perseo.tesoreria.services.MonedaService;

@Service
public class MonedaServiceImpl extends BaseServiceImpl
        implements MonedaService {

    @Autowired
    MonedaMapper mapper;

    @Autowired
    MonedaRepository repo;

    @Override
    public MonedaDTO grabar(MonedaDTO moneda) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(moneda)));
    }

    @Override
    public List<MonedaDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public MonedaDTO getByCodMoneda(Integer codMoneda) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(codMoneda).get());
    }

}

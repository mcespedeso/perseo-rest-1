package py.com.ideasweb.perseo.transaccion.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaDTO;
import py.com.ideasweb.perseo.transaccion.mapper.FacturaMapper;
import py.com.ideasweb.perseo.transaccion.repositories.FacturaRepository;
import py.com.ideasweb.perseo.transaccion.services.FacturaService;

@Service
public class FacturaServiceImpl extends BaseServiceImpl implements FacturaService {

    @Autowired
    FacturaMapper mapper;
    
    @Autowired 
    FacturaRepository repo;
    
    @Override
    public FacturaDTO getNumeroSgteByCaja(Integer idCaja) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findByCaja(idCaja));
    }

    @Override
    public FacturaDTO grabar(FacturaDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

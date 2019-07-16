package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.entities.BaseEntity;
import py.com.ideasweb.perseo.transaccion.dtos.FormaPagoDTO;
import py.com.ideasweb.perseo.transaccion.mapper.FormaPagoMapper;
import py.com.ideasweb.perseo.transaccion.repositories.FormaPagoRepository;
import py.com.ideasweb.perseo.transaccion.services.FormaPagoService;

@Service
public class FormaPagoServiceImpl extends BaseEntity
        implements FormaPagoService {

    @Autowired
    FormaPagoMapper mapper;

    @Autowired
    FormaPagoRepository repo;

    @Override
    public FormaPagoDTO grabar(FormaPagoDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<FormaPagoDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public FormaPagoDTO getById(Integer idFormaPago) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idFormaPago).get());
    }

}

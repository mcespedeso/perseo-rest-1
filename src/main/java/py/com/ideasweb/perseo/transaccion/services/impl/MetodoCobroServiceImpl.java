package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.MetodoCobroDTO;
import py.com.ideasweb.perseo.transaccion.mapper.MetodoCobroMapper;
import py.com.ideasweb.perseo.transaccion.repositories.MetodoCobroRepository;
import py.com.ideasweb.perseo.transaccion.services.MetodoCobroService;

@Service
public class MetodoCobroServiceImpl extends BaseServiceImpl
        implements MetodoCobroService {

    @Autowired
    MetodoCobroMapper mapper;

    @Autowired
    MetodoCobroRepository repo;

    @Override
    public MetodoCobroDTO grabar(MetodoCobroDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<MetodoCobroDTO> findAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public List<MetodoCobroDTO> findByEmpresa(Integer idEmpresa)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public MetodoCobroDTO getById(Integer idMetodoCobro) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idMetodoCobro).get());
    }

}

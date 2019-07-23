package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.CompraDetDTO;
import py.com.ideasweb.perseo.transaccion.mapper.CompraDetMapper;
import py.com.ideasweb.perseo.transaccion.repositories.CompraDetRepository;
import py.com.ideasweb.perseo.transaccion.services.CompraDetService;

@Service
public class CompraDetServiceImpl extends BaseServiceImpl
        implements CompraDetService {

    @Autowired
    CompraDetRepository repo;

    @Autowired
    CompraDetMapper mapper;

    @Override
    public CompraDetDTO grabar(CompraDetDTO dto) throws Exception {
        
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<CompraDetDTO> getByCompraCab(Integer idCompraCab)
            throws Exception {
        
        return mapper.entityListToDtoList(
                repo.findByCompraCabIdCompraCab(idCompraCab));
    }

}

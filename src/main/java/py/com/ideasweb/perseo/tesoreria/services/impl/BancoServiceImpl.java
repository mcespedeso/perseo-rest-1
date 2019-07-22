package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.BancoDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.BancoMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.BancoRepository;
import py.com.ideasweb.perseo.tesoreria.services.BancoService;

@Service
public class BancoServiceImpl extends BaseServiceImpl implements BancoService {

    @Autowired
    BancoRepository repo;

    @Autowired
    BancoMapper mapper;

    @Override
    public BancoDTO getById(Integer idBanco) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idBanco));
    }

    @Override
    public List<BancoDTO> findByEmpresa(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public BancoDTO grabar(BancoDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

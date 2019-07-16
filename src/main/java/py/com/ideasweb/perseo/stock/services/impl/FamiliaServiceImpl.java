package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.FamiliaDTO;
import py.com.ideasweb.perseo.stock.mapper.FamiliaMapper;
import py.com.ideasweb.perseo.stock.repositories.FamiliaRepository;
import py.com.ideasweb.perseo.stock.services.FamiliaService;

@Service
public class FamiliaServiceImpl extends BaseServiceImpl
        implements FamiliaService {

    @Autowired
    FamiliaMapper mapper;

    @Autowired
    FamiliaRepository repo;

    @Override
    public FamiliaDTO getByID(Integer idFamilia) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idFamilia).get());
    }

    @Override
    public List<FamiliaDTO> getByEmpresa(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public FamiliaDTO grabar(FamiliaDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.MarcaDTO;
import py.com.ideasweb.perseo.stock.mapper.MarcaMapper;
import py.com.ideasweb.perseo.stock.repositories.MarcaRepository;
import py.com.ideasweb.perseo.stock.services.MarcaService;

@Service
public class MarcaServiceImpl extends BaseServiceImpl implements MarcaService {

    @Autowired
    MarcaMapper mapper;

    @Autowired
    MarcaRepository repo;

    @Override
    public MarcaDTO getByID(Integer idMarca) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idMarca).get());
    }

    @Override
    public List<MarcaDTO> getByEmpresa(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public MarcaDTO grabar(MarcaDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

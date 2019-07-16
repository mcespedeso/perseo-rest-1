package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.UnidadMedidaDTO;
import py.com.ideasweb.perseo.stock.mapper.UnidadMedidaMapper;
import py.com.ideasweb.perseo.stock.repositories.UnidadMedidaRepository;
import py.com.ideasweb.perseo.stock.services.UnidadMedidaService;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl
        implements UnidadMedidaService {

    @Autowired
    UnidadMedidaMapper mapper;

    @Autowired
    UnidadMedidaRepository repo;

    @Override
    public UnidadMedidaDTO getByID(Integer idUnidadMedida) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idUnidadMedida).get());
    }

    @Override
    public List<UnidadMedidaDTO> getByEmpresa(Integer idEmpresa)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public UnidadMedidaDTO grabar(UnidadMedidaDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

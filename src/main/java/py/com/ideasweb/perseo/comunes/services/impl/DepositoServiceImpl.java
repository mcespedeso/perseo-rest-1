package py.com.ideasweb.perseo.comunes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.mapper.DepositoMapper;
import py.com.ideasweb.perseo.comunes.repositories.DepositoRepository;
import py.com.ideasweb.perseo.comunes.services.DepositoService;

@Service
public class DepositoServiceImpl extends BaseServiceImpl
        implements DepositoService {

    @Autowired
    DepositoMapper mapper;

    @Autowired
    DepositoRepository repo;

    @Override
    public List<DepositoDTO> getByEmpresa(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public List<DepositoDTO> getBySucursal(Integer idSucursal)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findBySucursalIdSucursal(idSucursal));
    }

    @Override
    public DepositoDTO grabar(DepositoDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

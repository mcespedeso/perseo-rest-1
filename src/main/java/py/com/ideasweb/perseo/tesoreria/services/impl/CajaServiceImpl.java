package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.CajaDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.CajaMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.CajaRepository;
import py.com.ideasweb.perseo.tesoreria.services.CajaService;

@Service
public class CajaServiceImpl extends BaseServiceImpl implements CajaService {

    @Autowired
    CajaMapper mapper;

    @Autowired
    CajaRepository repo;

    @Override
    public CajaDTO getById(Integer idCaja) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idCaja));
    }

    @Override
    public List<CajaDTO> findByEmpresa(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public CajaDTO grabar(CajaDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<CajaDTO> findBySucursal(Integer idSucursal) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findBySucursalIdSucursal(idSucursal));
    }

}

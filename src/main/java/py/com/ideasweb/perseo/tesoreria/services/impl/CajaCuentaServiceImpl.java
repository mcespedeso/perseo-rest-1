package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.CajaCuentaDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.CajaCuentaMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.CajaCuentaRepository;
import py.com.ideasweb.perseo.tesoreria.services.CajaCuentaService;

@Service
public class CajaCuentaServiceImpl extends BaseServiceImpl
        implements CajaCuentaService {

    @Autowired
    CajaCuentaRepository repo;

    @Autowired
    CajaCuentaMapper mapper;

    @Override
    public CajaCuentaDTO findById(Integer idCajaCuenta) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idCajaCuenta));
    }

    @Override
    public CajaCuentaDTO grabar(CajaCuentaDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<CajaCuentaDTO> getByBanco(Integer idBanco) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findByBancoIdBanco(idBanco));
    }

}

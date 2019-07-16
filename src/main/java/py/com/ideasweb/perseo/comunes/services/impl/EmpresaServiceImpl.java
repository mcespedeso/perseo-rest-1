package py.com.ideasweb.perseo.comunes.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.mapper.EmpresaMapper;
import py.com.ideasweb.perseo.comunes.repositories.EmpresaRepository;
import py.com.ideasweb.perseo.comunes.services.EmpresaService;

@Service
public class EmpresaServiceImpl extends BaseServiceImpl
        implements EmpresaService {

    @Autowired
    EmpresaMapper mapper;

    EmpresaRepository repo;

    @Override
    public EmpresaDTO getByID(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idEmpresa).get());
    }

}

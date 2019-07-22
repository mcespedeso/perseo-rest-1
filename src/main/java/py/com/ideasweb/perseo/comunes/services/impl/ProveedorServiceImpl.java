package py.com.ideasweb.perseo.comunes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.ProveedorDTO;
import py.com.ideasweb.perseo.comunes.mapper.ProveedorMapper;
import py.com.ideasweb.perseo.comunes.repositories.ProveedorRepository;
import py.com.ideasweb.perseo.comunes.services.ProveedorService;

@Service
public class ProveedorServiceImpl extends BaseServiceImpl
        implements ProveedorService {

    @Autowired
    ProveedorMapper mapper;

    @Autowired
    ProveedorRepository repo;

    @Override
    public List<ProveedorDTO> getByEmpresa(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public List<ProveedorDTO> getProveedorByParamsAndEmpresa(String parametro,
            Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findByDescripcionIgnoreCaseContainingOrNrodocIgnoreCaseContainingAndEmpresaIdEmpresa(
                        parametro, parametro, idEmpresa));
    }

    @Override
    public ProveedorDTO grabar(ProveedorDTO proveedorDTO) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(proveedorDTO)));
    }

}

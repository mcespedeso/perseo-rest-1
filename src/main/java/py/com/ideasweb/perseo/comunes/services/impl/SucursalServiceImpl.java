package py.com.ideasweb.perseo.comunes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.comunes.mapper.SucursalMapper;
import py.com.ideasweb.perseo.comunes.repositories.SucursalRepository;
import py.com.ideasweb.perseo.comunes.services.SucursalService;

@Service
public class SucursalServiceImpl extends BaseServiceImpl
        implements SucursalService {

    @Autowired
    SucursalMapper mapper;

    @Autowired
    SucursalRepository repo;

    @Override
    public SucursalDTO getSucursalById(Integer idSucursal) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idSucursal).get());
    }

    @Override
    public List<SucursalDTO> getAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public List<SucursalDTO> getByEmpresa(Integer idEmpresa) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public SucursalDTO grabar(SucursalDTO sucursal) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(sucursal)));
    }

    @Override
    public void delete(Integer idSucursal) throws Exception {
        // TODO Auto-generated method stub

        SucursalDTO dto = getSucursalById(idSucursal);
        dto.setEstado(false);

        repo.save(mapper.dtoToEntity(dto));

    }

}

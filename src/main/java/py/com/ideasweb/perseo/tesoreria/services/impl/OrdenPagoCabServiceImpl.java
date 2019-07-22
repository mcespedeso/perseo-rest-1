package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoCabDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.OrdenPagoCabMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.OrdenPagoCabRepository;
import py.com.ideasweb.perseo.tesoreria.services.OrdenPagoCabService;

@Service
public class OrdenPagoCabServiceImpl extends BaseServiceImpl
        implements OrdenPagoCabService {

    @Autowired
    OrdenPagoCabRepository repo;

    @Autowired
    OrdenPagoCabMapper mapper;

    @Override
    public OrdenPagoCabDTO getById(Integer idOrdenOagoCab) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idOrdenOagoCab));
    }

    @Override
    public List<OrdenPagoCabDTO> getByEmpresa(Integer idEmpresa)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public OrdenPagoCabDTO grabar(OrdenPagoCabDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<OrdenPagoCabDTO> getBySucursal(Integer idSucursal)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findBySucursalIdSucursal(idSucursal));
    }

}

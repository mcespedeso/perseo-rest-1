package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaCabDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloPrecioVentaCabMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloPrecioVentaCabRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloPrecioVentaCabService;

@Service
public class ArticuloVentaCabServiceImpl extends BaseServiceImpl
        implements ArticuloPrecioVentaCabService {

    @Autowired
    ArticuloPrecioVentaCabMapper mapper;

    @Autowired
    ArticuloPrecioVentaCabRepository repo;

    @Override
    public List<ArticuloPrecioVentaCabDTO> getByEmpresa(Integer idEmpresa)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public ArticuloPrecioVentaCabDTO getById(Integer idArticuloPrecioVentaCab)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityToDto(repo.findById(idArticuloPrecioVentaCab).get());
    }

    @Override
    public ArticuloPrecioVentaCabDTO grabar(ArticuloPrecioVentaCabDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

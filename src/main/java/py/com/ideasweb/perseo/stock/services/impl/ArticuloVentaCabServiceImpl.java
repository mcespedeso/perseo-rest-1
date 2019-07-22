package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ArticuloPrecioVentaCabDTO> getByEmpresa(Integer idEmpresa,
            Boolean all, Boolean estado) throws Exception {
        // TODO Auto-generated method stub
        List<ArticuloPrecioVentaCabDTO> list = mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
        if (!all) {
            return list.stream().filter(a -> a.getEstado() == estado)
                    .collect(Collectors.toList());
        }
        return list;
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

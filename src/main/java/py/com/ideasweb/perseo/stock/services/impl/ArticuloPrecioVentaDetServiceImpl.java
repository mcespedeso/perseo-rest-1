package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaDetDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloPrecioVentaDetMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloPrecioVentaDetRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloPrecioVentaDetService;

@Service
public class ArticuloPrecioVentaDetServiceImpl extends BaseServiceImpl
        implements ArticuloPrecioVentaDetService {

    @Autowired
    ArticuloPrecioVentaDetMapper mapper;

    @Autowired
    ArticuloPrecioVentaDetRepository repo;

    @Override
    public List<ArticuloPrecioVentaDetDTO> getByPrecioVentaCab(
            Integer idArticuloPrecioVentaCab) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findByArticuloPrecioVentaCabIdArticuloPrecioVentaCab(
                        idArticuloPrecioVentaCab));
    }

    @Override
    public ArticuloPrecioVentaDetDTO getById(Integer idArticuloPrecioVentaDet)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityToDto(repo.findById(idArticuloPrecioVentaDet).get());
    }

    @Override
    public ArticuloPrecioVentaDetDTO grabar(ArticuloPrecioVentaDetDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoDetDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.OrdenPagoDetMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.OrdenPagoDetRepository;
import py.com.ideasweb.perseo.tesoreria.services.OrdenPagoDetService;

@Service
public class OrdenPagoDetServiceImpl extends BaseServiceImpl
        implements OrdenPagoDetService {

    @Autowired
    OrdenPagoDetRepository repo;

    @Autowired
    OrdenPagoDetMapper mapper;

    @Override
    public List<OrdenPagoDetDTO> getByOrdenPagoCab(Integer idOrdenPagoCab)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findByOrdenPagoCabIdOrdenPagoCab(idOrdenPagoCab));
    }

    @Override
    public OrdenPagoDetDTO grabar(OrdenPagoDetDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

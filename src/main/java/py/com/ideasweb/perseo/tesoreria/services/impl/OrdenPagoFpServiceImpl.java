package py.com.ideasweb.perseo.tesoreria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoFpDTO;
import py.com.ideasweb.perseo.tesoreria.mapper.OrdenPagoFpMapper;
import py.com.ideasweb.perseo.tesoreria.repositories.OrdenPagoFpRepository;
import py.com.ideasweb.perseo.tesoreria.services.OrdenPagoFpService;

public class OrdenPagoFpServiceImpl extends BaseServiceImpl
        implements OrdenPagoFpService {

    @Autowired
    OrdenPagoFpMapper mapper;

    @Autowired
    OrdenPagoFpRepository repo;

    @Override
    public OrdenPagoFpDTO getById(Integer idOrdenPagoFp) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idOrdenPagoFp));
    }

    @Override
    public OrdenPagoFpDTO grabar(OrdenPagoFpDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<OrdenPagoFpDTO> getByOrdenPagoCab(Integer idOrdenPagoCab)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findByOrdenPagoCabIdOrdenPagoCab(idOrdenPagoCab));
    }

}

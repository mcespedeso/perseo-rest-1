package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaFormaCobroDTO;
import py.com.ideasweb.perseo.transaccion.mapper.FacturaFormaCobroMapper;
import py.com.ideasweb.perseo.transaccion.repositories.FacturaFormaCobroRepository;
import py.com.ideasweb.perseo.transaccion.services.FacturaFormaCobroService;

@Service
public class FacturaFormaCobroServiceImpl extends BaseServiceImpl
        implements FacturaFormaCobroService {

    @Autowired
    FacturaFormaCobroMapper mapper;

    @Autowired
    FacturaFormaCobroRepository repo;

    @Override
    public FacturaFormaCobroDTO grabar(FacturaFormaCobroDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<FacturaFormaCobroDTO> getByFacturaCab(Integer idFacturaCab)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findByFacturaCabIdFacturaCab(idFacturaCab));
    }

}

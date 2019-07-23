package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaDetDTO;
import py.com.ideasweb.perseo.transaccion.mapper.FacturaDetMapper;
import py.com.ideasweb.perseo.transaccion.repositories.FacturaDetRepository;
import py.com.ideasweb.perseo.transaccion.services.FacturaDetService;

@Service
public class FacturaDetServiceImpl extends BaseServiceImpl
        implements FacturaDetService {

    @Autowired
    FacturaDetMapper mapper;

    @Autowired
    FacturaDetRepository repo;

    @Override
    public FacturaDetDTO grabar(FacturaDetDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<FacturaDetDTO> getByFacturaCab(Integer idFacturaCab)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findByFacturaCabIdFacturaCab(idFacturaCab));
    }

}

package py.com.ideasweb.perseo.transaccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.transaccion.dtos.VentaDetDTO;
import py.com.ideasweb.perseo.transaccion.mapper.VentaDetMapper;
import py.com.ideasweb.perseo.transaccion.repositories.VentaDetRepository;
import py.com.ideasweb.perseo.transaccion.services.VentaDetService;

@Service
public class VentaDetServiceImpl extends BaseServiceImpl
        implements VentaDetService {

    @Autowired
    VentaDetMapper mapper;

    @Autowired
    VentaDetRepository repo;

    @Override
    public VentaDetDTO grabar(VentaDetDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<VentaDetDTO> getByVentaCab(Integer idVentaCab)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByVentaCabIdVentaCab(idVentaCab));
    }

}

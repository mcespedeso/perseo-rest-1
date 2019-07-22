package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaDetDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloTransferenciaDetMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloTransferenciaDetRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloTransferenciaDetService;

@Service
public class ArticuloTransferenciaDetServiceImpl extends BaseServiceImpl
        implements ArticuloTransferenciaDetService {

    @Autowired
    ArticuloTransferenciaDetMapper mapper;

    @Autowired
    ArticuloTransferenciaDetRepository repo;

    @Override
    public ArticuloTransferenciaDetDTO grabar(ArticuloTransferenciaDetDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<ArticuloTransferenciaDetDTO> getByTransferenciaCab(
            Integer idArticuloTransferenciaCab) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findByArticuloTransferenciaCabIdArticuloTransferenciaCab(
                        idArticuloTransferenciaCab));
    }

}

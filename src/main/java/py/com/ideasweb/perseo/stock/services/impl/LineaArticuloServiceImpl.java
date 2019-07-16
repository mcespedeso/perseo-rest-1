package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.LineaArticuloDTO;
import py.com.ideasweb.perseo.stock.mapper.LineaArticuloMapper;
import py.com.ideasweb.perseo.stock.repositories.LineaArticuloRepository;
import py.com.ideasweb.perseo.stock.services.LineaArticuloService;

@Service
public class LineaArticuloServiceImpl extends BaseServiceImpl
        implements LineaArticuloService {

    @Autowired
    LineaArticuloMapper mapper;

    @Autowired
    LineaArticuloRepository repo;

    @Override
    public LineaArticuloDTO getByID(Integer idLineaArticulo) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idLineaArticulo).get());
    }

    @Override
    public List<LineaArticuloDTO> getByEmpresa(Integer idEmpresa)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public List<LineaArticuloDTO> getByFamilia(Integer idFamilia)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByFamiliaIdFamilia(idFamilia));
    }

    @Override
    public LineaArticuloDTO grabar(LineaArticuloDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

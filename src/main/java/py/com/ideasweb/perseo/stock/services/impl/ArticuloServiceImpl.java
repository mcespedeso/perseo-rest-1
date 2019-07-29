package py.com.ideasweb.perseo.stock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloService;

@Service
public class ArticuloServiceImpl extends BaseServiceImpl
        implements ArticuloService {

    @Autowired
    ArticuloMapper mapper;

    @Autowired
    ArticuloRepository repo;

    @Override
    public List<ArticuloDTO> getByEmpresa(Integer idEmpresa) {
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public List<ArticuloDTO> getByParams(String param, Boolean all)
            throws Exception {
        // TODO Auto-generated method stub
        List<ArticuloDTO> list = new ArrayList<>();
        if (!all)
            return mapper.entityListToDtoList(
                    repo.findByDescripcionContainsIgnoreCaseOrCodigoBarraContainsIgnoreCase(
                            param, param));

        return list.stream().filter(a -> a.getEstado() == true)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticuloDTO> getByFamilia(Integer idfamilia) throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByFamiliaIdFamilia(idfamilia));
    }

    @Override
    public ArticuloDTO grabar(ArticuloDTO articulo) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(articulo)));
    }

}

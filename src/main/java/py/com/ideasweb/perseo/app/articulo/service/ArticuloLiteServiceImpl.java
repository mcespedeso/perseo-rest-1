package py.com.ideasweb.perseo.app.articulo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.app.articulo.model.ArticuloLite;
import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;

@Service
public class ArticuloLiteServiceImpl extends BaseServiceImpl
        implements ArticuloLiteService {

    @Autowired
    ArticuloDepositoService articuloDepositoService;

    @Override
    public List<ArticuloLite> findByEmpresa(Integer idEmpresa)
            throws Exception {
        List<ArticuloLite> lista = new ArrayList<>();

        articuloDepositoService.getByEmpresa(idEmpresa).stream().forEach(ad -> {
            lista.add(new ArticuloLite(ad));
        });

        return lista;

    }

    @Override
    public ArticuloLite grabar(ArticuloLite articulo) throws Exception {
        // TODO Auto-generated method stub

        ArticuloDTO dto = new ArticuloDTO(articulo);

        ArticuloDepositoDTO dep = new ArticuloDepositoDTO();
        dep.setArticulo(dto);
        articuloDepositoService.grabar(dep);

        return null;
        // return articuloRepository.save(articulo);

    }

}

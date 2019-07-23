package py.com.ideasweb.perseo.app.articulo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.app.articulo.model.ArticuloLite;
import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.seguridad.services.UsuarioService;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;

@Service
public class ArticuloLiteServiceImpl extends BaseServiceImpl
        implements ArticuloLiteService {

    private static final Logger logger = LoggerFactory
            .getLogger(ArticuloLiteServiceImpl.class);

    @Autowired
    ArticuloDepositoService articuloDepositoService;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public List<ArticuloLite> findByEmpresa(Integer idUsuario)
            throws Exception {

        UsuarioDTO user = usuarioService.getUserById(idUsuario);
        logger.info("Obteniendo articulos para la empresa :"
                + user.getEmpresa().getDescripcion());
        List<ArticuloLite> lista = new ArrayList<>();

        articuloDepositoService
                .getBySucursalAndDeposito(user.getSucursal().getIdSucursal(),
                        user.getDeposito().getIdDeposito(), true)
                .stream().forEach(ad -> {
                    lista.add(new ArticuloLite(ad));
                });

        return lista;

    }

    @Override
    public ArticuloLite grabar(ArticuloLite articulo, Integer idUsuario)
            throws Exception {
        // TODO Auto-generated method stub
        logger.info("Grabando el articulo: " + articulo);
        UsuarioDTO user = usuarioService.getUserById(idUsuario);
        ArticuloDTO dto = new ArticuloDTO(articulo);
        dto.setUsuario(user);
        dto.setEmpresa(user.getEmpresa());

        ArticuloDepositoDTO dep = new ArticuloDepositoDTO();
        dep.setArticulo(dto);
        dep.setDeposito(user.getDeposito());
        dep.setSucursal(user.getSucursal());
        dep.setEmpresa(user.getEmpresa());
        dep.setCantidad(articulo.getCantidad());
        dep.setPrecioVenta(articulo.getPrecioVenta());
        dep.setEstado(articulo.getEstado());
        dep.setUsuario(user);

        ArticuloDepositoDTO newDTO = articuloDepositoService.grabar(dep);

        return new ArticuloLite(newDTO);

    }

}

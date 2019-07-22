package py.com.ideasweb.perseo.stock.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloMovimientoDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloMovimientoMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloMovimientoRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;
import py.com.ideasweb.perseo.stock.services.ArticuloMovimientoService;

@Service
public class ArticuloMovimientoServiceImpl extends BaseServiceImpl
        implements ArticuloMovimientoService {

    @Autowired
    ArticuloMovimientoRepository repo;

    @Autowired
    ArticuloMovimientoMapper mapper;

    @Autowired
    ArticuloDepositoService articuloDepositoService;

    @Override
    public ArticuloMovimientoDTO getById(Integer idArticuloMovimiento)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(idArticuloMovimiento));
    }

    @Override
    public List<ArticuloMovimientoDTO> getByEmpresa(Integer idEmpresa)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public List<ArticuloMovimientoDTO> getByArticulo(Integer idArticulo)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByArticuloIdArticulo(idArticulo));
    }

    @Override
    public List<ArticuloMovimientoDTO> getByDeposito(Integer idDeposito)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByDepositoIdDeposito(idDeposito));
    }

    @Override
    public ArticuloMovimientoDTO grabar(ArticuloMovimientoDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public String ajusteStock(ArticuloMovimientoDTO articulomovimiento,
            UsuarioDTO usuario) throws Exception {
        try {

            articulomovimiento.setFecha(new Date(System.currentTimeMillis()));
            articulomovimiento.setUsuario(usuario);

            ArticuloDepositoDTO ad = articuloDepositoService
                    .getByArticuloAndDeposito(
                            articulomovimiento.getArticulo().getIdArticulo(),
                            articulomovimiento.getDeposito().getIdDeposito());
            
            Double res = new Double(0);
            if (articulomovimiento.getColumna().equals("I")) {
                res = ad.getCantidad() + articulomovimiento.getCantidad();
            } else {
                res = ad.getCantidad() - articulomovimiento.getCantidad();
            }
            ad.setCantidad(res);

            // actulizar el stock
            articuloDepositoService.grabar(ad);

            // grabar el movimiento
            grabar(articulomovimiento);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw e;
        }
        return "Ajuste realizado";
    }

}

package py.com.ideasweb.perseo.stock.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloMovimientoDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaCabDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaDetDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloTransferenciaCabMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloTransferenciaCabRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloMovimientoService;
import py.com.ideasweb.perseo.stock.services.ArticuloTransferenciaCabService;
import py.com.ideasweb.perseo.tesoreria.dtos.ConceptoMovDTO;

@Service
public class ArticuloTransferenciaCabServiceImpl extends BaseServiceImpl
        implements ArticuloTransferenciaCabService {

    @Autowired
    ArticuloTransferenciaCabMapper mapper;

    @Autowired
    ArticuloTransferenciaCabRepository repo;

    @Autowired
    ArticuloMovimientoService articuloMovimientoService;

    @Autowired
    ArticuloTransferenciaDetServiceImpl articuloTransferenciaDetService;

    @Override
    public String transferirArticulos(
            ArticuloTransferenciaCabDTO articulotransferenciacab,
            List<ArticuloTransferenciaDetDTO> detalles, UsuarioDTO usuario)
            throws Exception {

        try {
            articulotransferenciacab
                    .setFecha(new Date(System.currentTimeMillis()));
            articulotransferenciacab.setUsuario(usuario);
            articulotransferenciacab.setEmpresa(usuario.getEmpresa());
            articulotransferenciacab.setEstado(true);
            ArticuloTransferenciaCabDTO newDto = grabar(
                    articulotransferenciacab);

            detalles.stream().forEach(element -> {
                element.setArticuloTransferenciaCab(newDto);

                try {

                    articuloTransferenciaDetService.grabar(element);

                    // registrar la entrada/salida en articulo mov

                    ArticuloMovimientoDTO salida = new ArticuloMovimientoDTO();
                    salida.setArticulo(element.getArticulo());
                    salida.setFecha(new Date(System.currentTimeMillis()));
                    salida.setDeposito(
                            articulotransferenciacab.getDepositoOrigen());
                    ConceptoMovDTO c = new ConceptoMovDTO();
                    c.setIdConceptoMov(13);
                    salida.setConceptoMov(c);
                    salida.setUsuario(usuario);
                    salida.setCantidad(
                            element.getCantidadRecibido().doubleValue());
                    salida.setColumna("E");
                    articuloMovimientoService.grabar(salida);

                    ArticuloMovimientoDTO entrada = new ArticuloMovimientoDTO();
                    entrada.setArticulo(element.getArticulo());
                    entrada.setFecha(new Date(System.currentTimeMillis()));
                    entrada.setDeposito(
                            articulotransferenciacab.getDepositoDestino());
                    ConceptoMovDTO c1 = new ConceptoMovDTO();
                    c1.setIdConceptoMov(14);
                    entrada.setConceptoMov(c1);
                    entrada.setUsuario(usuario);
                    entrada.setCantidad(
                            element.getCantidadRecibido().doubleValue());
                    entrada.setColumna("I");
                    articuloMovimientoService.grabar(entrada);

                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    @Override
    public ArticuloTransferenciaCabDTO grabar(ArticuloTransferenciaCabDTO dto)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

}

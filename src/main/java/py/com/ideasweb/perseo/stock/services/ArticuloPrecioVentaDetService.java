package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaDetDTO;

public interface ArticuloPrecioVentaDetService {

    List<ArticuloPrecioVentaDetDTO> getByPrecioVentaCab(
            Integer idArticuloPrecioVentaCab) throws Exception;

    ArticuloPrecioVentaDetDTO getById(Integer idArticuloPrecioVentaDet)
            throws Exception;

    ArticuloPrecioVentaDetDTO grabar(ArticuloPrecioVentaDetDTO dto)
            throws Exception;

    //
    void updatePrecioByFamilia(Integer idfamilia, UsuarioDTO usuario)
            throws Exception;

    void updatePrecioByListacab(UsuarioDTO usuario, Integer idDeposito,
            Integer idarticuloprecioventacab, String concepto) throws Exception;

    void setPrecioArticulo(ArticuloDTO articulo, Integer idprecioventacab,
            UsuarioDTO usuario) throws Exception;

    ArticuloPrecioVentaDetDTO getByArticuloAndPrecioVentaCab(Integer idarticulo,
            Integer idarticuloprecioventacab) throws Exception;

}

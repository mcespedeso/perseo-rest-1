package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaCabDTO;

public interface ArticuloPrecioVentaCabService {

    List<ArticuloPrecioVentaCabDTO> getByEmpresa(Integer idEmpresa)
            throws Exception;

    ArticuloPrecioVentaCabDTO getById(Integer idArticuloPrecioVentaCab)
            throws Exception;

    ArticuloPrecioVentaCabDTO grabar(ArticuloPrecioVentaCabDTO dto)
            throws Exception;

}

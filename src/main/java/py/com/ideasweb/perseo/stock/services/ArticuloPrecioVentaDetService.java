package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaDetDTO;

public interface ArticuloPrecioVentaDetService {

    List<ArticuloPrecioVentaDetDTO> getByPrecioVentaCab(Integer idArticuloPrecioVentaCab) throws Exception;
    
    ArticuloPrecioVentaDetDTO getById(Integer idArticuloPrecioVentaDet) throws Exception;
    
    ArticuloPrecioVentaDetDTO grabar(ArticuloPrecioVentaDetDTO dto) throws Exception;
    
}

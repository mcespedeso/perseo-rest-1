package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;

public interface ArticuloService {

    List<ArticuloDTO> getByEmpresa(Integer idEmpresa);

    List<ArticuloDTO> getByParams(String param, Boolean all) throws Exception;

    List<ArticuloDTO> getByFamilia(Integer idfamilia) throws Exception;

    ArticuloDTO grabar(ArticuloDTO articulo) throws Exception;
    

}

package py.com.ideasweb.perseo.app.articulo.service;

import java.util.List;

import py.com.ideasweb.perseo.app.articulo.model.ArticuloLite;

public interface ArticuloLiteService {

    
    List<ArticuloLite> findByEmpresa(Integer idEmpresa) throws Exception;
       

    ArticuloLite grabar(ArticuloLite articulo) throws Exception;
    
}

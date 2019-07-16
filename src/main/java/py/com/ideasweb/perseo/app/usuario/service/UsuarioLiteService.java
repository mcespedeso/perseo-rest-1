package py.com.ideasweb.perseo.app.usuario.service;

import java.util.List;

import py.com.ideasweb.perseo.app.usuario.model.UsuarioLite;

public interface UsuarioLiteService {

    List<UsuarioLite> findAll();

    List<UsuarioLite> findByEmpresa(Integer idEmpresa);
    
    UsuarioLite getById(Integer idUsuario);
    
    UsuarioLite grabar(UsuarioLite usuario);

}

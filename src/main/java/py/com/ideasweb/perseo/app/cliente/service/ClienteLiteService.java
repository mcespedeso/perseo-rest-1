package py.com.ideasweb.perseo.app.cliente.service;

import java.util.List;

import py.com.ideasweb.perseo.app.cliente.model.ClienteLite;

public interface ClienteLiteService {

    List<ClienteLite> findAll();

    ClienteLite grabar(ClienteLite cliente, Integer idUsuario) throws Exception;

    List<ClienteLite> findByEmpresa(Integer idEmpresa) throws Exception;
    
    List<ClienteLite> findByUsuario(Integer idUsuario) throws Exception;

    ClienteLite findByDoc(String doc) throws Exception;

}

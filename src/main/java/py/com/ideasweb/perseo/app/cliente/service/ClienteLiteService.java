package py.com.ideasweb.perseo.app.cliente.service;

import java.util.List;

import py.com.ideasweb.perseo.app.cliente.model.ClienteLite;

public interface ClienteLiteService {

    List<ClienteLite> findAll();
    
    ClienteLite grabar(ClienteLite cliente);
    
    List<ClienteLite> findByEmpresa(Integer idEmpresa);
    
    ClienteLite findByDoc(String doc);

}

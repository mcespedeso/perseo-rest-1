package py.com.ideasweb.perseo.app.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.app.cliente.model.ClienteLite;

@Service
public class ClienteLiteServiceImpl implements ClienteLiteService {

    @Override
    public List<ClienteLite> findAll() {

        // return clienteRepository.findAll();

        return null;
    }

    @Override
    public ClienteLite grabar(ClienteLite cliente) {
        // TODO Auto-generated method stub

        return null;
        // return clienteRepository.save(cliente);

    }

    @Override
    public List<ClienteLite> findByEmpresa(Integer idEmpresa) {
        // TODO Auto-generated method stub
        return null;
        // return clienteRepository.findByIdEmpresa(idEmpresa);
    }

    @Override
    public ClienteLite findByDoc(String doc) {
        // TODO Auto-generated method stub
        return null;
        // return clienteRepository.findByNroDocumento(doc);
    }

}

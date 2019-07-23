package py.com.ideasweb.perseo.app.cliente.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.app.cliente.model.ClienteLite;
import py.com.ideasweb.perseo.comunes.dtos.ClienteDTO;
import py.com.ideasweb.perseo.comunes.services.ClienteService;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.seguridad.services.UsuarioService;

@Service
public class ClienteLiteServiceImpl implements ClienteLiteService {

    private static final Logger logger = LoggerFactory
            .getLogger(ClienteLiteServiceImpl.class);

    @Autowired
    ClienteService clienteService;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public List<ClienteLite> findAll() {

        // return clienteRepository.findAll();

        return null;
    }

    @Override
    public ClienteLite grabar(ClienteLite cliente, Integer idUsuario)
            throws Exception {

        logger.info("Grabando el cliente: " + cliente);
        UsuarioDTO user = usuarioService.getUserById(idUsuario);

        ClienteDTO dto = new ClienteDTO(cliente);
        dto.setUsuario(user);
        dto.setEmpresa(user.getEmpresa());
        dto.setSucursal(user.getSucursal());

        ClienteDTO newDto = clienteService.grabar(dto);

        return new ClienteLite(newDto);

    }

    @Override
    public List<ClienteLite> findByEmpresa(Integer idEmpresa) throws Exception {

        logger.info("Obteniendo clientes para la empresa :" + idEmpresa);

        List<ClienteLite> lista = new ArrayList<>();

        clienteService.getByEmpresa(idEmpresa).forEach(c -> {
            ClienteLite lite = new ClienteLite(c);
            lista.add(lite);
        });

        return lista;
    }

    @Override
    public ClienteLite findByDoc(String doc) throws Exception {

        ClienteDTO dto = clienteService.getByDoc(doc);
        return new ClienteLite(dto);
    }

    @Override
    public List<ClienteLite> findByUsuario(Integer idUsuario) throws Exception {

        UsuarioDTO user = usuarioService.getUserById(idUsuario);
        logger.info("Obteniendo clientes del usuario: " + user.getLogin());

        List<ClienteLite> lista = new ArrayList<>();

        clienteService.getByUsuario(idUsuario).forEach(c -> {
            ClienteLite lite = new ClienteLite(c);
            lista.add(lite);
        });

        return lista;
    }

}

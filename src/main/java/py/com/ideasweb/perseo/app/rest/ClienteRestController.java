package py.com.ideasweb.perseo.app.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.ideasweb.perseo.app.cliente.model.ClienteLite;
import py.com.ideasweb.perseo.app.cliente.service.ClienteLiteService;

@RestController
@RequestMapping(value = "/api/v1/app/clientes")
public class ClienteRestController {

    private static final Logger LOG = LoggerFactory
            .getLogger(ClienteRestController.class);
    
    private ClienteLiteService clienteService;

    public ClienteRestController(ClienteLiteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ResponseEntity<List<ClienteLite>> getClientes() {
        List<ClienteLite> cliente = clienteService.findAll();
        return ResponseEntity.ok(cliente);
    }

    // cambiar, obtener clientes vinculados al usuario
    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<ClienteLite>> getClientesByUsuario(
            @PathVariable("idUsuario") Integer idUsuario) {
        List<ClienteLite> cliente = clienteService.findAll();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<ClienteLite>> getClientesByEmpresa(
            @PathVariable("idEmpresa") Integer idEmpresa) {
        LOG.info("Descargando clientes para la empresa: " + idEmpresa);
        List<ClienteLite> articulos = clienteService.findByEmpresa(idEmpresa);
        return ResponseEntity.ok(articulos);
    }

    @PostMapping()
    public ResponseEntity<ClienteLite> grabarCliente(@RequestBody ClienteLite cliente) {

        return ResponseEntity.ok(clienteService.grabar(cliente));
    }

}

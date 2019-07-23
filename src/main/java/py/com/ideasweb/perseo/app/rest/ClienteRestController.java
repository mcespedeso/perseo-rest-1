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

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<ClienteLite>> getClientesByUsuario(
            @PathVariable("idUsuario") Integer idUsuario) throws Exception {
        List<ClienteLite> cliente = clienteService.findByUsuario(idUsuario);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<ClienteLite>> getClientesByEmpresa(
            @PathVariable("idEmpresa") Integer idEmpresa) throws Exception {
        List<ClienteLite> articulos = clienteService.findByEmpresa(idEmpresa);
        return ResponseEntity.ok(articulos);
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity<ClienteLite> grabarCliente(
            @PathVariable("idUsuario") Integer idUsuario,
            @RequestBody ClienteLite cliente) throws Exception {

        return ResponseEntity.ok(clienteService.grabar(cliente, idUsuario));
    }

}

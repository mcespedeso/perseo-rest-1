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

import py.com.ideasweb.perseo.app.usuario.model.UsuarioLite;
import py.com.ideasweb.perseo.app.usuario.service.UsuarioLiteService;

@RestController
@RequestMapping(value = "/api/v1/app/usuarios")
public class UsuarioRestController {

    private static final Logger LOG = LoggerFactory
            .getLogger(UsuarioRestController.class);

    private UsuarioLiteService usuarioService;

    public UsuarioRestController(UsuarioLiteService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /*@GetMapping()
    public ResponseEntity<List<UsuarioLite>> getUsuarios() {
        List<UsuarioLite> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }*/

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<UsuarioLite>> getArticulosByEmpresa(
            @PathVariable("idEmpresa") Integer idEmpresa) {
        LOG.info("Descargando usuarios para la empresa: " + idEmpresa);
        List<UsuarioLite> usuarios = usuarioService.findByEmpresa(idEmpresa);
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity<UsuarioLite> grabarUsuario(
            @PathVariable("idUsuario") Integer idUsuario,
            @RequestBody UsuarioLite usuario) {
        LOG.info("Grabando el usuario : " + usuario.toString());
        return ResponseEntity.ok(usuarioService.grabar(usuario, idUsuario));
    }

}

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

import py.com.ideasweb.perseo.app.articulo.model.ArticuloLite;
import py.com.ideasweb.perseo.app.articulo.service.ArticuloLiteService;

@RestController
@RequestMapping(value = "/api/v1/app/articulos")
public class ArticuloRestController {

    private static final Logger LOG = LoggerFactory
            .getLogger(ArticuloRestController.class);

    private ArticuloLiteService articuloService;

    public ArticuloRestController(ArticuloLiteService articuloService) {
        this.articuloService = articuloService;
    }

   /* @GetMapping()
    public ResponseEntity<List<ArticuloLite>> getArticulos() {
        List<ArticuloLite> articulos = articuloService.findAll();
        return ResponseEntity.ok(articulos);
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<ArticuloLite>> getArticulosByEmpresa(
            @PathVariable("idEmpresa") Integer idEmpresa) {
        LOG.info("Descargando articulos para la empresa: " + idEmpresa);
        List<ArticuloLite> articulos = articuloService.findByEmpresa(idEmpresa);
        return ResponseEntity.ok(articulos);
    }

    @PostMapping()
    public ResponseEntity<ArticuloLite> grabarArticulo(
            @RequestBody ArticuloLite articulo) {
        return ResponseEntity.ok(articuloService.grabar(articulo));
    }*/

}

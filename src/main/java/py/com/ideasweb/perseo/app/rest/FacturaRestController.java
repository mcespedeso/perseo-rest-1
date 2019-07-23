package py.com.ideasweb.perseo.app.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.ideasweb.perseo.app.facturacion.model.FacturaLitecab;
import py.com.ideasweb.perseo.app.facturacion.service.FacturaLiteService;

@RestController
@RequestMapping(value = "/api/v1/app/facturas")
public class FacturaRestController {

    private static final Logger LOG = LoggerFactory
            .getLogger(FacturaRestController.class);

    private FacturaLiteService facturaService;

    public FacturaRestController(FacturaLiteService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping()
    public ResponseEntity<List<FacturaLitecab>> getFacturas() {
        List<FacturaLitecab> facturas = new ArrayList<FacturaLitecab>();
        try {
            facturas = facturaService.getFacturas(null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
        return ResponseEntity.ok(facturas);
    }

    @PostMapping("/grabar-lista/{idUsuario}")
    public ResponseEntity addPedidos(
            @PathVariable("idUsuario") Integer idUsuario,
            @RequestBody List<FacturaLitecab> facturas) {
        try {
            facturaService.addFacturas(facturas, idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity addPedido(
            @PathVariable("idUsuario") Integer idUsuario,
            @RequestBody FacturaLitecab factura) {
        try {
            facturaService.addFactura(factura, idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<FacturaLitecab>> getFacturasByUsuario(
            @PathVariable("idUsuario") Integer idUsuario) {

        LOG.info("Obteniendo facturas del usuario: " + idUsuario);
        List<FacturaLitecab> facturas = new ArrayList<FacturaLitecab>();
        try {
            facturas = facturaService.getFacturasByUsuario(idUsuario, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/empresa/{idEmpresa}/{fechaDesde}/{fechaHasta}")
    public ResponseEntity<List<FacturaLitecab>> getFacturasByEmpresa(
            @PathVariable("idEmpresa") Integer idEmpresa,
            @PathVariable("fechaDesde") String fechaDesde,
            @PathVariable("fechaHasta") String fechaHasta) {

        List<FacturaLitecab> facturas = new ArrayList<FacturaLitecab>();
        try {
            facturas = facturaService.getFacturasByEmpresa(idEmpresa,
                    fechaDesde, fechaHasta);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
        return ResponseEntity.ok(facturas);
    }

}

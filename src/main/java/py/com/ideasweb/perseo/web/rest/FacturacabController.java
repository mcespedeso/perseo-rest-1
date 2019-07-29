package py.com.ideasweb.perseo.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.ideasweb.perseo.seguridad.dtos.UserDetailsDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.services.ArticuloService;

@RestController
@RequestMapping(value = "/api/v1/articulos")
public class FacturacabController {
	
private static final Logger LOG = LoggerFactory.getLogger(FacturacabController.class);
	
	private ArticuloService articuloService;
	
	FacturacabController(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}

	@GetMapping()
	public ResponseEntity<List<ArticuloDTO>> getArticulos(
			@AuthenticationPrincipal UserDetailsDTO userDetails) {
		List<ArticuloDTO> articulos = articuloService.getByEmpresa(userDetails.getUsuario().getEmpresa().getIdEmpresa());
		return ResponseEntity.ok(articulos);
	}
	
	
}

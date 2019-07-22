package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloMovimientoDTO;

public interface ArticuloMovimientoService {

    ArticuloMovimientoDTO getById(Integer idArticuloMovimiento)
            throws Exception;

    List<ArticuloMovimientoDTO> getByEmpresa(Integer idEmpresa)
            throws Exception;

    List<ArticuloMovimientoDTO> getByArticulo(Integer idArticulo)
            throws Exception;

    List<ArticuloMovimientoDTO> getByDeposito(Integer idDeposito)
            throws Exception;

    ArticuloMovimientoDTO grabar(ArticuloMovimientoDTO dto) throws Exception;

    String ajusteStock(ArticuloMovimientoDTO articulomovimiento,
            UsuarioDTO usuario) throws Exception;

}

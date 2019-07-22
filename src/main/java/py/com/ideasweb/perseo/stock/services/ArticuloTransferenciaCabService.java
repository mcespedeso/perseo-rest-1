package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaCabDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaDetDTO;

public interface ArticuloTransferenciaCabService {

    ArticuloTransferenciaCabDTO grabar(ArticuloTransferenciaCabDTO dto) throws Exception;
    
    String transferirArticulos(
            ArticuloTransferenciaCabDTO articulotransferenciacab,
            List<ArticuloTransferenciaDetDTO> detalles, UsuarioDTO usuario)
            throws Exception;

}

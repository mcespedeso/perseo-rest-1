package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaDetDTO;

public interface ArticuloTransferenciaDetService {

    ArticuloTransferenciaDetDTO grabar(ArticuloTransferenciaDetDTO dto)
            throws Exception;

    List<ArticuloTransferenciaDetDTO> getByTransferenciaCab(
            Integer idArticuloTransferenciaCab) throws Exception;
}

package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.CompraDetDTO;

public interface CompraDetService {

    CompraDetDTO grabar(CompraDetDTO dto) throws Exception;
    
    List<CompraDetDTO> getByCompraCab(Integer idCompraCab) throws Exception;
}

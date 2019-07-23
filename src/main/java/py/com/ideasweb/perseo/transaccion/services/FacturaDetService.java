package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.FacturaDetDTO;

public interface FacturaDetService {

    FacturaDetDTO grabar(FacturaDetDTO dto) throws Exception;

    List<FacturaDetDTO> getByFacturaCab(Integer idFacturaCab) throws Exception;
}

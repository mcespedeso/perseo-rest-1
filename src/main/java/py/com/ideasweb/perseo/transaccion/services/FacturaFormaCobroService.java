package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.FacturaFormaCobroDTO;

public interface FacturaFormaCobroService {

    FacturaFormaCobroDTO grabar(FacturaFormaCobroDTO dto) throws Exception;

    List<FacturaFormaCobroDTO> getByFacturaCab(Integer idFacturaCab)
            throws Exception;
}

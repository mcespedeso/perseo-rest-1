package py.com.ideasweb.perseo.transaccion.services;

import py.com.ideasweb.perseo.transaccion.dtos.FacturaDTO;

public interface FacturaService {

    FacturaDTO getNumeroSgteByCaja(Integer idCaja) throws Exception;
    
    FacturaDTO grabar(FacturaDTO dto) throws Exception;

}

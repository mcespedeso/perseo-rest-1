package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoFpDTO;

public interface OrdenPagoFpService {

    OrdenPagoFpDTO getById(Integer idOrdenPagoFp) throws Exception;

    OrdenPagoFpDTO grabar(OrdenPagoFpDTO dto) throws Exception;

    List<OrdenPagoFpDTO> getByOrdenPagoCab(Integer idOrdenPagoCab)
            throws Exception;

}

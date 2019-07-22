package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoDetDTO;

public interface OrdenPagoDetService {

    List<OrdenPagoDetDTO> getByOrdenPagoCab(Integer idOrdenPagoCab)
            throws Exception;

    OrdenPagoDetDTO grabar(OrdenPagoDetDTO dto) throws Exception;
}

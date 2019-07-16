package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.EstadoVentaDTO;

public interface EstadoVentaService {

    EstadoVentaDTO grabar(EstadoVentaDTO dto) throws Exception;

    List<EstadoVentaDTO> findAll() throws Exception;

    EstadoVentaDTO getById(Integer idEstadoVenta) throws Exception;
}

package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.transaccion.dtos.EstadoCompraDTO;

public interface EstadoCompraService {

    EstadoCompraDTO grabar(EstadoCompraDTO dto) throws Exception;

    List<EstadoCompraDTO> findAll() throws Exception;

    EstadoCompraDTO getById(Integer idEstadoCompra) throws Exception;
}

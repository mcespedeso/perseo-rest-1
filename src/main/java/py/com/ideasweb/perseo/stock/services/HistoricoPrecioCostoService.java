package py.com.ideasweb.perseo.stock.services;

import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioCostoDTO;

public interface HistoricoPrecioCostoService {

    HistoricoPrecioCostoDTO grabar(HistoricoPrecioCostoDTO dto)
            throws Exception;

    Double getPromedioCostoByArticulo(Integer idArticulo) throws Exception;
}

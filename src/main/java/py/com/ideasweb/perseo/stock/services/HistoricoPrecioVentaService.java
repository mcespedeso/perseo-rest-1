package py.com.ideasweb.perseo.stock.services;

import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioVentaDTO;

public interface HistoricoPrecioVentaService {

    HistoricoPrecioVentaDTO grabar(HistoricoPrecioVentaDTO dto) throws Exception;
}

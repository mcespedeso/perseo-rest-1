package py.com.ideasweb.perseo.stock.services;

import py.com.ideasweb.perseo.stock.dtos.HistoricoArticuloDTO;

public interface HistoricoArticuloService {

    HistoricoArticuloDTO grabar(HistoricoArticuloDTO historicoArticuloDTO)
            throws Exception;
}

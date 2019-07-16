package py.com.ideasweb.perseo.stock.services;

import java.util.List;

import py.com.ideasweb.perseo.stock.dtos.LineaArticuloDTO;

public interface LineaArticuloService {

    LineaArticuloDTO getByID(Integer idLineaArticulo) throws Exception;

    List<LineaArticuloDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    List<LineaArticuloDTO> getByFamilia(Integer idFamilia) throws Exception;

    LineaArticuloDTO grabar(LineaArticuloDTO dto) throws Exception;
}

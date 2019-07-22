package py.com.ideasweb.perseo.tesoreria.services;

import java.util.List;

import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoCabDTO;

public interface OrdenPagoCabService {

    OrdenPagoCabDTO getById(Integer idOrdenOagoCab) throws Exception;

    List<OrdenPagoCabDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    OrdenPagoCabDTO grabar(OrdenPagoCabDTO dto) throws Exception;

    List<OrdenPagoCabDTO> getBySucursal(Integer idSucursal) throws Exception;

}

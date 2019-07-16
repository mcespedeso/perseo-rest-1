package py.com.ideasweb.perseo.comunes.services;

import java.util.List;

import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;

public interface SucursalService {

    SucursalDTO getSucursalById(Integer idSucursal) throws Exception;

    List<SucursalDTO> getAll() throws Exception;

    List<SucursalDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    SucursalDTO grabar(SucursalDTO sucursal) throws Exception;

    void delete(Integer idSucursal) throws Exception;

}

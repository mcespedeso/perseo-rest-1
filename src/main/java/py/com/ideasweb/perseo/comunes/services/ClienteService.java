package py.com.ideasweb.perseo.comunes.services;

import java.util.List;

import py.com.ideasweb.perseo.comunes.dtos.ClienteDTO;

public interface ClienteService {

    List<ClienteDTO> getByEmpresa(Integer idEmpresa) throws Exception;

    ClienteDTO getById(Integer idCliente) throws Exception;

    ClienteDTO grabar(ClienteDTO cliente) throws Exception;

    List<ClienteDTO> getByTipoDocAndDOc(String tipodoc, String nrodoc)
            throws Exception;

    List<ClienteDTO> getByNombres(String nombres) throws Exception;

    List<ClienteDTO> getByUsuario(Integer idUsuario) throws Exception;

    ClienteDTO getByDoc(String nrodoc) throws Exception;
}

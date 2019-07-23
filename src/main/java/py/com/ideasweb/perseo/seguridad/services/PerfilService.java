package py.com.ideasweb.perseo.seguridad.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.PerfilDTO;

public interface PerfilService {

    PerfilDTO getById(Integer idpefil) throws Exception;

    List<PerfilDTO> getAll() throws Exception;

    PerfilDTO add(PerfilDTO entity) throws Exception;

    List<PerfilDTO> getByEstado(Boolean estado) throws Exception;

}

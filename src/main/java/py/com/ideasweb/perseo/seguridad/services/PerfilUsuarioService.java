package py.com.ideasweb.perseo.seguridad.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.PerfilusuarioDTO;

public interface PerfilUsuarioService {

    List<PerfilusuarioDTO> findByUsuario(Integer idUsuario);

    void grabar(PerfilusuarioDTO perfil);

    void deleteByUsuario(Integer idUsuario);

    Boolean ifAsigned(PerfilusuarioDTO perfilusuario) throws Exception;

}

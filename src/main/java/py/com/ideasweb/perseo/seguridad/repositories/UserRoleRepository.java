package py.com.ideasweb.perseo.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioRoleEntity;

/**
 * Created by jdferreira
 */
public interface UserRoleRepository
        extends JpaRepository<UsuarioRoleEntity, Integer> {

    List<UsuarioRoleEntity> findByUsuario(UsuarioEntity usuario);

    UsuarioRoleEntity findByUsuarioIdUsuario(Integer idUsuario);
    
    void deleteByUsuarioIdUsuario(Integer idUsuario);
}
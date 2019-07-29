package py.com.ideasweb.perseo.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.UsuarioRoleEntity;

/**
 * Created by jdferreira
 */
public interface UserRoleRepository
        extends JpaRepository<UsuarioRoleEntity, Long> {

	List<UsuarioRoleEntity> findByLogin(String login);

    //UsuarioRoleEntity findByUsuarioIdUsuario(Integer idUsuario);
    
    void deleteByLogin(String login);
    
//    @Query(value = "select * from usuario_x_role where id_usuario = :idUsuario", nativeQuery = true)
//    List<UsuarioRoleEntity> findByUser(
//            @Param("idUsuario") Integer idUsuario);
}
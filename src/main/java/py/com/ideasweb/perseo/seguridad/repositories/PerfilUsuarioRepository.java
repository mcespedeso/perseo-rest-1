package py.com.ideasweb.perseo.seguridad.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.PerfilusuarioEntity;

/**
 * Created by jdferreira
 */
public interface PerfilUsuarioRepository
        extends JpaRepository<PerfilusuarioEntity, Integer> {

    List<PerfilusuarioEntity> findByIdUsuario(Integer idUsuario);

    void deleteByIdUsuario(Integer idUsuario);

   Optional<PerfilusuarioEntity>findByIdUsuarioAndPerfilIdPerfil(
            Integer idUsuario, Integer idPerfil);

}
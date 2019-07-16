package py.com.ideasweb.perseo.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.PerfilusuarioEntity;

/**
 * Created by jdferreira
 */
public interface PerfilUsuarioRepository
        extends JpaRepository<PerfilusuarioEntity, Integer> {

    List<PerfilusuarioEntity> findByIdUsuario(Integer idUsuario);
    
    void deleteByIdUsuario(Integer idUsuario);

}
package py.com.ideasweb.perseo.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.PerfilEntity;

/**
 * Created by jdferreira
 */
public interface PerfilRepository extends JpaRepository<PerfilEntity, Integer> {

}
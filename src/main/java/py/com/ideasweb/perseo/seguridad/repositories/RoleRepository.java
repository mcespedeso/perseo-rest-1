package py.com.ideasweb.perseo.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.seguridad.entities.RolesEntity;

public interface RoleRepository extends JpaRepository<RolesEntity, Integer> {

    
}

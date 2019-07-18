package py.com.ideasweb.perseo.comunes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.ProveedorEntity;

public interface ProveedorRepository
        extends JpaRepository<ProveedorEntity, Integer> {

}

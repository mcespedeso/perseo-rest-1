package py.com.ideasweb.perseo.tesoreria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.ConceptoMovEntity;

public interface ConceptoMovRepository
        extends JpaRepository<ConceptoMovEntity, Integer> {

}

package py.com.ideasweb.perseo.comunes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.TipoImpuestoEntity;

public interface TipoImpuestoRepository
        extends JpaRepository<TipoImpuestoEntity, Integer> {

}

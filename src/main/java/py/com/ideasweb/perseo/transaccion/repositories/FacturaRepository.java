package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.FacturaEntity;

public interface FacturaRepository
        extends JpaRepository<FacturaEntity, Integer> {

}

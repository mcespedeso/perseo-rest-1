package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.FacturaFormaCobroEntity;

public interface FacturaFormaCobroRepository
        extends JpaRepository<FacturaFormaCobroEntity, Integer> {

}

package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.FacturaPlazoEntity;

public interface FacturaPlazoRepository
        extends JpaRepository<FacturaPlazoEntity, Integer> {

}

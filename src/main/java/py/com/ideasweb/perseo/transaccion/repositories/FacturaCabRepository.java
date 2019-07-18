package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.FacturaCabEntity;

public interface FacturaCabRepository
        extends JpaRepository<FacturaCabEntity, Integer> {

}

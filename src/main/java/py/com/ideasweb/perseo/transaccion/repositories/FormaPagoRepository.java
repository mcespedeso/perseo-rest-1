package py.com.ideasweb.perseo.transaccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.FormaPagoEntity;

public interface FormaPagoRepository
        extends JpaRepository<FormaPagoEntity, Integer> {

}

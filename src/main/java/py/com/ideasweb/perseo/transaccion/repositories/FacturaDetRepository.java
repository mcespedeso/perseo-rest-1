package py.com.ideasweb.perseo.transaccion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.FacturaDetEntity;

public interface FacturaDetRepository
        extends JpaRepository<FacturaDetEntity, Integer> {

    List<FacturaDetEntity> findByFacturaCabIdFacturaCab(Integer idFacturaCab);

}

package py.com.ideasweb.perseo.transaccion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.CompraDetEntity;

public interface CompraDetRepository
        extends JpaRepository<CompraDetEntity, Integer> {

    List<CompraDetEntity> findByCompraCabIdCompraCab(Integer idCompraCab);
}

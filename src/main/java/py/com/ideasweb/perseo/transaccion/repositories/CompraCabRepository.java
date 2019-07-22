package py.com.ideasweb.perseo.transaccion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.CompraCabEntity;

public interface CompraCabRepository
        extends JpaRepository<CompraCabEntity, Integer> {

    List<CompraCabEntity> findByTurnoIdTurno(Integer idTurno);
}

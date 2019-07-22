package py.com.ideasweb.perseo.transaccion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.TurnoEntity;

public interface TurnoRepository extends JpaRepository<TurnoEntity, Integer> {
    
    List<TurnoEntity> findByUsuarioIdUsuario(Integer idUsuario);
    
    TurnoEntity findByusuarioIdUsuarioAndEstadoTrue(Integer idUsuario);

}

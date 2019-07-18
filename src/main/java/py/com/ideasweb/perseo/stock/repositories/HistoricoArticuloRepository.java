package py.com.ideasweb.perseo.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.HistoricoArticuloEntity;

public interface HistoricoArticuloRepository
        extends JpaRepository<HistoricoArticuloEntity, Integer> {

}

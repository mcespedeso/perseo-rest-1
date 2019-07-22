package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloTransferenciaDetEntity;

public interface ArticuloTransferenciaDetRepository
        extends JpaRepository<ArticuloTransferenciaDetEntity, Integer> {

    List<ArticuloTransferenciaDetEntity> findByArticuloTransferenciaCabIdArticuloTransferenciaCab(
            Integer idTransferenciaCab);

}

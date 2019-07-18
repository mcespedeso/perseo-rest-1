package py.com.ideasweb.perseo.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloTransferenciaCabEntity;

public interface ArticuloTransferenciaCabRepository
        extends JpaRepository<ArticuloTransferenciaCabEntity, Integer> {

}

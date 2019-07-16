package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.ArticuloPrecioVentaCabEntity;

public interface ArticuloPrecioVentaCabRepository
        extends JpaRepository<ArticuloPrecioVentaCabEntity, Integer> {

    List<ArticuloPrecioVentaCabEntity> findByEmpresaIdEmpresa(
            Integer idEmpresa);

}

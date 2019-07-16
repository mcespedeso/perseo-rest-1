package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.LineaArticuloEntity;

public interface LineaArticuloRepository
        extends JpaRepository<LineaArticuloEntity, Integer> {

    List<LineaArticuloEntity> findByEmpresaIdEmpresa(Integer idEmpresa);
    
    List<LineaArticuloEntity> findByFamiliaIdFamilia(Integer idFamilia);
}

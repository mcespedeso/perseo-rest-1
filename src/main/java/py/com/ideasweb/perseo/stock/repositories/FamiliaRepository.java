package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.FamiliaEntity;

public interface FamiliaRepository
        extends JpaRepository<FamiliaEntity, Integer> {

    List<FamiliaEntity> findByEmpresaIdEmpresa(Integer idEmpresa);
}

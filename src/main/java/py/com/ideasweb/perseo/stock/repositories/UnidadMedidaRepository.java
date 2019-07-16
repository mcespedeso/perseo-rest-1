package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.UnidadMedidaEntity;

public interface UnidadMedidaRepository
        extends JpaRepository<UnidadMedidaEntity, Integer> {

    List<UnidadMedidaEntity> findByEmpresaIdEmpresa(Integer idEmpresa);
}

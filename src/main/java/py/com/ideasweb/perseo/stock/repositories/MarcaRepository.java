package py.com.ideasweb.perseo.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.stock.entities.MarcaEntity;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Integer> {

    List<MarcaEntity> findByEmpresaIdEmpresa(Integer idEmpresa);
}

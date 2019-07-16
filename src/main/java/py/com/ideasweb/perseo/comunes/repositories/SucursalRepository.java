package py.com.ideasweb.perseo.comunes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;
public interface SucursalRepository extends JpaRepository<SucursalEntity, Integer> {

    List<SucursalEntity> findByEmpresaIdEmpresa(Integer idEmpresa);
}

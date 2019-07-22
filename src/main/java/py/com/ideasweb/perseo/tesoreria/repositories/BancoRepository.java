package py.com.ideasweb.perseo.tesoreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.BancoEntity;

public interface BancoRepository extends JpaRepository<BancoEntity, Integer> {

    List<BancoEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

}

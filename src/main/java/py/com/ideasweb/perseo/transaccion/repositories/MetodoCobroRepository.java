package py.com.ideasweb.perseo.transaccion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.transaccion.entities.MetodoCobroEntity;

public interface MetodoCobroRepository
        extends JpaRepository<MetodoCobroEntity, Integer> {

    List<MetodoCobroEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

}

package py.com.ideasweb.perseo.comunes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;

public interface EmpresaRepository
        extends JpaRepository<EmpresaEntity, Integer> {

}

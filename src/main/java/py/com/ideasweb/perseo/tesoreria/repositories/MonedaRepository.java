package py.com.ideasweb.perseo.tesoreria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.MonedaEntity;

public interface MonedaRepository extends JpaRepository<MonedaEntity, Integer> {

}

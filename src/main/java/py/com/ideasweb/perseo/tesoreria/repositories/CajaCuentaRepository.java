package py.com.ideasweb.perseo.tesoreria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.tesoreria.entities.CajaCuentaEntity;

public interface CajaCuentaRepository
        extends JpaRepository<CajaCuentaEntity, Integer> {

    List<CajaCuentaEntity> findByBancoIdBanco(Integer idBanco);

}

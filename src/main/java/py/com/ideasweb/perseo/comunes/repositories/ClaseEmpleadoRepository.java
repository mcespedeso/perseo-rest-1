package py.com.ideasweb.perseo.comunes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.comunes.dtos.ClaseEmpleadoDTO;
import py.com.ideasweb.perseo.comunes.entities.ClaseEmpleadoEntity;

public interface ClaseEmpleadoRepository
        extends JpaRepository<ClaseEmpleadoEntity, Integer> {

    List<ClaseEmpleadoEntity> findByEmpresaIdEmpresa(Integer idEmpresa);

}

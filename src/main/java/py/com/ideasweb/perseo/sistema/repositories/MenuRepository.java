package py.com.ideasweb.perseo.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.ideasweb.perseo.sistema.entities.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

}

package py.com.ideasweb.perseo.seguridad.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.MenuDTO;

public interface MenuService {

    List<MenuDTO> getAll() throws Exception;

    MenuDTO garbar(MenuDTO dto) throws Exception;

    MenuDTO getById(Integer id) throws Exception;

    List<MenuDTO> getByPerfil(Integer idperfil, boolean all, boolean estado)
            throws Exception;

    List<MenuDTO> getMenuesWithoutPerfiles() throws Exception;

}

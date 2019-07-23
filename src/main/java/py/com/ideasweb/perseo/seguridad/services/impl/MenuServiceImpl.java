package py.com.ideasweb.perseo.seguridad.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.MenuDTO;
import py.com.ideasweb.perseo.seguridad.mapper.MenuMapper;
import py.com.ideasweb.perseo.seguridad.repositories.MenuRepository;
import py.com.ideasweb.perseo.seguridad.services.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {

    @Autowired
    MenuRepository repo;

    @Autowired
    MenuMapper mapper;

    @Override
    public List<MenuDTO> getAll() throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(repo.findAll());
    }

    @Override
    public MenuDTO garbar(MenuDTO dto) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public MenuDTO getById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.getOne(id));
    }

    @Override
    public List<MenuDTO> getByPerfil(Integer idperfil, boolean all,
            boolean estado) throws Exception {
        // TODO Auto-generated method stub
        if (all)
            return mapper.entityListToDtoList(repo
                    .findByTipoAndPerfilIdPerfilOrderByOrdenAsc("M", idperfil));

        return mapper.entityListToDtoList(
                repo.findByTipoAndPerfilIdPerfilAndEstadoOrderByOrdenAsc("M",
                        idperfil, estado));
    }

    @Override
    public List<MenuDTO> getMenuesWithoutPerfiles() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}

package py.com.ideasweb.perseo.sistema.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.sistema.dtos.MenuDTO;
import py.com.ideasweb.perseo.sistema.entities.MenuEntity;

/**
 * @author jdferreira
 */
@Component
public class MenuMapper implements BaseMapper<MenuEntity, MenuDTO> {

    private final ModelMapper modelMapper;

    public MenuMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MenuDTO> entityListToDtoList(List<MenuEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public MenuDTO entityToDto(MenuEntity entity) {
        MenuDTO dto = modelMapper.map(entity, MenuDTO.class);
        return dto;
    }

    @Override
    public MenuEntity dtoToEntity(MenuDTO dto) {
        return modelMapper.map(dto, MenuEntity.class);
    }

}

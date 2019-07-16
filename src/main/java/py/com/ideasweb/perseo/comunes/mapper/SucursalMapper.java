package py.com.ideasweb.perseo.comunes.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.comunes.dtos.SucursalDTO;
import py.com.ideasweb.perseo.comunes.entities.SucursalEntity;

/**
 * @author jdferreira
 */
@Component
public class SucursalMapper implements BaseMapper<SucursalEntity, SucursalDTO> {

    private final ModelMapper modelMapper;

    public SucursalMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SucursalDTO> entityListToDtoList(
            List<SucursalEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public SucursalDTO entityToDto(SucursalEntity entity) {
        SucursalDTO dto = modelMapper.map(entity, SucursalDTO.class);
        return dto;
    }

    @Override
    public SucursalEntity dtoToEntity(SucursalDTO dto) {
        return modelMapper.map(dto, SucursalEntity.class);
    }

}

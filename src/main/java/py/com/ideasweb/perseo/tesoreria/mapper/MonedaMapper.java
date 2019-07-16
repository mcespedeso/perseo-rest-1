package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.MonedaDTO;
import py.com.ideasweb.perseo.tesoreria.entities.MonedaEntity;

/**
 * @author jdferreira
 */
@Component
public class MonedaMapper implements BaseMapper<MonedaEntity, MonedaDTO> {

    private final ModelMapper modelMapper;

    public MonedaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MonedaDTO> entityListToDtoList(List<MonedaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public MonedaDTO entityToDto(MonedaEntity entity) {
        MonedaDTO dto = modelMapper.map(entity, MonedaDTO.class);
        return dto;
    }

    @Override
    public MonedaEntity dtoToEntity(MonedaDTO dto) {
        return modelMapper.map(dto, MonedaEntity.class);
    }

}

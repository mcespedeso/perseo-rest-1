package py.com.ideasweb.perseo.sistema.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.sistema.dtos.ClaseDTO;
import py.com.ideasweb.perseo.sistema.entities.ClaseEntity;

/**
 * @author jdferreira
 */
@Component
public class ClaseMapper implements BaseMapper<ClaseEntity, ClaseDTO> {

    private final ModelMapper modelMapper;

    public ClaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClaseDTO> entityListToDtoList(List<ClaseEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ClaseDTO entityToDto(ClaseEntity entity) {
        ClaseDTO dto = modelMapper.map(entity, ClaseDTO.class);
        return dto;
    }

    @Override
    public ClaseEntity dtoToEntity(ClaseDTO dto) {
        return modelMapper.map(dto, ClaseEntity.class);
    }

}

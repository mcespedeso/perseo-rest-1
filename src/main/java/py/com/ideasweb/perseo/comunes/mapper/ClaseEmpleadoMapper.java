package py.com.ideasweb.perseo.comunes.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.comunes.dtos.ClaseEmpleadoDTO;
import py.com.ideasweb.perseo.comunes.entities.ClaseEmpleadoEntity;

/**
 * @author jdferreira
 */
@Component
public class ClaseEmpleadoMapper
        implements BaseMapper<ClaseEmpleadoEntity, ClaseEmpleadoDTO> {

    private final ModelMapper modelMapper;

    public ClaseEmpleadoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClaseEmpleadoDTO> entityListToDtoList(
            List<ClaseEmpleadoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ClaseEmpleadoDTO entityToDto(ClaseEmpleadoEntity entity) {
        ClaseEmpleadoDTO dto = modelMapper.map(entity, ClaseEmpleadoDTO.class);
        return dto;
    }

    @Override
    public ClaseEmpleadoEntity dtoToEntity(ClaseEmpleadoDTO dto) {
        return modelMapper.map(dto, ClaseEmpleadoEntity.class);
    }

}

package py.com.ideasweb.perseo.comunes.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.comunes.dtos.ProveedorDTO;
import py.com.ideasweb.perseo.comunes.entities.ProveedorEntity;

/**
 * @author jdferreira
 */
@Component
public class ProveedorMapper
        implements BaseMapper<ProveedorEntity, ProveedorDTO> {

    private final ModelMapper modelMapper;

    public ProveedorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProveedorDTO> entityListToDtoList(
            List<ProveedorEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO entityToDto(ProveedorEntity entity) {
        ProveedorDTO dto = modelMapper.map(entity, ProveedorDTO.class);
        return dto;
    }

    @Override
    public ProveedorEntity dtoToEntity(ProveedorDTO dto) {
        return modelMapper.map(dto, ProveedorEntity.class);
    }

}

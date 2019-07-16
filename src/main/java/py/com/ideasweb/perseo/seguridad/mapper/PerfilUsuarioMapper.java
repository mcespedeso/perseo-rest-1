package py.com.ideasweb.perseo.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.seguridad.dtos.PerfilusuarioDTO;
import py.com.ideasweb.perseo.seguridad.entities.PerfilusuarioEntity;

/**
 * @author jdferreira
 */
@Component
public class PerfilUsuarioMapper
        implements BaseMapper<PerfilusuarioEntity, PerfilusuarioDTO> {

    private final ModelMapper modelMapper;

    public PerfilUsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PerfilusuarioDTO> entityListToDtoList(
            List<PerfilusuarioEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public PerfilusuarioDTO entityToDto(PerfilusuarioEntity entity) {
        PerfilusuarioDTO dto = modelMapper.map(entity, PerfilusuarioDTO.class);
        return dto;
    }

    @Override
    public PerfilusuarioEntity dtoToEntity(PerfilusuarioDTO dto) {
        return modelMapper.map(dto, PerfilusuarioEntity.class);
    }

}

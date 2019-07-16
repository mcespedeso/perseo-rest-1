package py.com.ideasweb.perseo.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.seguridad.entities.UsuarioEntity;

/**
 * @author jdferreira
 */
@Component
public class UsuarioMapper implements BaseMapper<UsuarioEntity, UsuarioDTO> {

    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UsuarioDTO> entityListToDtoList(
            List<UsuarioEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO entityToDto(UsuarioEntity entity) {
        UsuarioDTO dto = modelMapper.map(entity, UsuarioDTO.class);
        return dto;
    }

    @Override
    public UsuarioEntity dtoToEntity(UsuarioDTO dto) {
        return modelMapper.map(dto, UsuarioEntity.class);
    }

}

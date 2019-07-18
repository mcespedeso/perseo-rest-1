package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.CompraDetDTO;
import py.com.ideasweb.perseo.transaccion.entities.CompraDetEntity;

/**
 * @author jdferreira
 */
@Component
public class CompraDetMapper
        implements BaseMapper<CompraDetEntity, CompraDetDTO> {

    private final ModelMapper modelMapper;

    public CompraDetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompraDetDTO> entityListToDtoList(
            List<CompraDetEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public CompraDetDTO entityToDto(CompraDetEntity entity) {
        CompraDetDTO dto = modelMapper.map(entity, CompraDetDTO.class);
        return dto;
    }

    @Override
    public CompraDetEntity dtoToEntity(CompraDetDTO dto) {
        return modelMapper.map(dto, CompraDetEntity.class);
    }

}

package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.LineaArticuloDTO;
import py.com.ideasweb.perseo.stock.entities.LineaArticuloEntity;

/**
 * @author jdferreira
 */
@Component
public class LineaArticuloMapper
        implements BaseMapper<LineaArticuloEntity, LineaArticuloDTO> {

    private final ModelMapper modelMapper;

    public LineaArticuloMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LineaArticuloDTO> entityListToDtoList(
            List<LineaArticuloEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public LineaArticuloDTO entityToDto(LineaArticuloEntity entity) {
        LineaArticuloDTO dto = modelMapper.map(entity, LineaArticuloDTO.class);
        return dto;
    }

    @Override
    public LineaArticuloEntity dtoToEntity(LineaArticuloDTO dto) {
        return modelMapper.map(dto, LineaArticuloEntity.class);
    }

}

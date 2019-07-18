package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.ArticuloMovimientoDTO;
import py.com.ideasweb.perseo.stock.entities.ArticuloMovimientoEntity;

/**
 * @author jdferreira
 */
@Component
public class ArticuloMovimientoMapper
        implements BaseMapper<ArticuloMovimientoEntity, ArticuloMovimientoDTO> {

    private final ModelMapper modelMapper;

    public ArticuloMovimientoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticuloMovimientoDTO> entityListToDtoList(
            List<ArticuloMovimientoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloMovimientoDTO entityToDto(ArticuloMovimientoEntity entity) {
        ArticuloMovimientoDTO dto = modelMapper.map(entity,
                ArticuloMovimientoDTO.class);
        return dto;
    }

    @Override
    public ArticuloMovimientoEntity dtoToEntity(ArticuloMovimientoDTO dto) {
        return modelMapper.map(dto, ArticuloMovimientoEntity.class);
    }

}

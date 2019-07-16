package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.entities.ArticuloEntity;

/**
 * @author jdferreira
 */
@Component
public class ArticuloMapper implements BaseMapper<ArticuloEntity, ArticuloDTO> {

    private final ModelMapper modelMapper;

    public ArticuloMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticuloDTO> entityListToDtoList(
            List<ArticuloEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloDTO entityToDto(ArticuloEntity entity) {
        ArticuloDTO dto = modelMapper.map(entity, ArticuloDTO.class);
        return dto;
    }

    @Override
    public ArticuloEntity dtoToEntity(ArticuloDTO dto) {
        return modelMapper.map(dto, ArticuloEntity.class);
    }

}

package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaCabDTO;
import py.com.ideasweb.perseo.stock.entities.ArticuloPrecioVentaCabEntity;

/**
 * @author jdferreira
 */
@Component
public class ArticuloPrecioVentaCabMapper implements
        BaseMapper<ArticuloPrecioVentaCabEntity, ArticuloPrecioVentaCabDTO> {

    private final ModelMapper modelMapper;

    public ArticuloPrecioVentaCabMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticuloPrecioVentaCabDTO> entityListToDtoList(
            List<ArticuloPrecioVentaCabEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloPrecioVentaCabDTO entityToDto(
            ArticuloPrecioVentaCabEntity entity) {
        ArticuloPrecioVentaCabDTO dto = modelMapper.map(entity,
                ArticuloPrecioVentaCabDTO.class);
        return dto;
    }

    @Override
    public ArticuloPrecioVentaCabEntity dtoToEntity(
            ArticuloPrecioVentaCabDTO dto) {
        return modelMapper.map(dto, ArticuloPrecioVentaCabEntity.class);
    }

}

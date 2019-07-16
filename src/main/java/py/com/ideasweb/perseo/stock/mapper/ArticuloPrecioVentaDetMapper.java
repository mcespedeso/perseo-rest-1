package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaDetDTO;
import py.com.ideasweb.perseo.stock.entities.ArticuloPrecioVentaDetEntity;

/**
 * @author jdferreira
 */
@Component
public class ArticuloPrecioVentaDetMapper implements
        BaseMapper<ArticuloPrecioVentaDetEntity, ArticuloPrecioVentaDetDTO> {

    private final ModelMapper modelMapper;

    public ArticuloPrecioVentaDetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticuloPrecioVentaDetDTO> entityListToDtoList(
            List<ArticuloPrecioVentaDetEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloPrecioVentaDetDTO entityToDto(
            ArticuloPrecioVentaDetEntity entity) {
        ArticuloPrecioVentaDetDTO dto = modelMapper.map(entity,
                ArticuloPrecioVentaDetDTO.class);
        return dto;
    }

    @Override
    public ArticuloPrecioVentaDetEntity dtoToEntity(
            ArticuloPrecioVentaDetDTO dto) {
        return modelMapper.map(dto, ArticuloPrecioVentaDetEntity.class);
    }

}

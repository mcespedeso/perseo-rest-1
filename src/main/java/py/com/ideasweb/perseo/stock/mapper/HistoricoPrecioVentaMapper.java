package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioVentaDTO;
import py.com.ideasweb.perseo.stock.entities.HistoricoPrecioVentaEntity;

/**
 * @author jdferreira
 */
@Component
public class HistoricoPrecioVentaMapper implements
        BaseMapper<HistoricoPrecioVentaEntity, HistoricoPrecioVentaDTO> {

    private final ModelMapper modelMapper;

    public HistoricoPrecioVentaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HistoricoPrecioVentaDTO> entityListToDtoList(
            List<HistoricoPrecioVentaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public HistoricoPrecioVentaDTO entityToDto(
            HistoricoPrecioVentaEntity entity) {
        HistoricoPrecioVentaDTO dto = modelMapper.map(entity,
                HistoricoPrecioVentaDTO.class);
        return dto;
    }

    @Override
    public HistoricoPrecioVentaEntity dtoToEntity(HistoricoPrecioVentaDTO dto) {
        return modelMapper.map(dto, HistoricoPrecioVentaEntity.class);
    }

}

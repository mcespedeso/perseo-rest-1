package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioCostoDTO;
import py.com.ideasweb.perseo.stock.entities.HistoricoPrecioCostoEntity;

/**
 * @author jdferreira
 */
@Component
public class HistoricoPrecioCostoMapper implements
        BaseMapper<HistoricoPrecioCostoEntity, HistoricoPrecioCostoDTO> {

    private final ModelMapper modelMapper;

    public HistoricoPrecioCostoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HistoricoPrecioCostoDTO> entityListToDtoList(
            List<HistoricoPrecioCostoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public HistoricoPrecioCostoDTO entityToDto(
            HistoricoPrecioCostoEntity entity) {
        HistoricoPrecioCostoDTO dto = modelMapper.map(entity,
                HistoricoPrecioCostoDTO.class);
        return dto;
    }

    @Override
    public HistoricoPrecioCostoEntity dtoToEntity(HistoricoPrecioCostoDTO dto) {
        return modelMapper.map(dto, HistoricoPrecioCostoEntity.class);
    }

}

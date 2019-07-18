package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.HistoricoArticuloDTO;
import py.com.ideasweb.perseo.stock.entities.HistoricoArticuloEntity;

/**
 * @author jdferreira
 */
@Component
public class HistoricoArticuloMapper
        implements BaseMapper<HistoricoArticuloEntity, HistoricoArticuloDTO> {

    private final ModelMapper modelMapper;

    public HistoricoArticuloMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HistoricoArticuloDTO> entityListToDtoList(
            List<HistoricoArticuloEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public HistoricoArticuloDTO entityToDto(HistoricoArticuloEntity entity) {
        HistoricoArticuloDTO dto = modelMapper.map(entity,
                HistoricoArticuloDTO.class);
        return dto;
    }

    @Override
    public HistoricoArticuloEntity dtoToEntity(HistoricoArticuloDTO dto) {
        return modelMapper.map(dto, HistoricoArticuloEntity.class);
    }

}

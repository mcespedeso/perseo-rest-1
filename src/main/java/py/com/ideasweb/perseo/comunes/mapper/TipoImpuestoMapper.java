package py.com.ideasweb.perseo.comunes.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.comunes.dtos.TipoImpuestoDTO;
import py.com.ideasweb.perseo.comunes.entities.TipoImpuestoEntity;

/**
 * @author jdferreira
 */
@Component
public class TipoImpuestoMapper
        implements BaseMapper<TipoImpuestoEntity, TipoImpuestoDTO> {

    private final ModelMapper modelMapper;

    public TipoImpuestoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoImpuestoDTO> entityListToDtoList(
            List<TipoImpuestoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public TipoImpuestoDTO entityToDto(TipoImpuestoEntity entity) {
        TipoImpuestoDTO dto = modelMapper.map(entity, TipoImpuestoDTO.class);
        return dto;
    }

    @Override
    public TipoImpuestoEntity dtoToEntity(TipoImpuestoDTO dto) {
        return modelMapper.map(dto, TipoImpuestoEntity.class);
    }

}

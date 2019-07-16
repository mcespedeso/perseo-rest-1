package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.TipoFacturaDTO;
import py.com.ideasweb.perseo.transaccion.entities.TipoFacturaEntity;

/**
 * @author jdferreira
 */
@Component
public class TipoFacturaMapper
        implements BaseMapper<TipoFacturaEntity, TipoFacturaDTO> {

    private final ModelMapper modelMapper;

    public TipoFacturaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoFacturaDTO> entityListToDtoList(
            List<TipoFacturaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public TipoFacturaDTO entityToDto(TipoFacturaEntity entity) {
        TipoFacturaDTO dto = modelMapper.map(entity, TipoFacturaDTO.class);
        return dto;
    }

    @Override
    public TipoFacturaEntity dtoToEntity(TipoFacturaDTO dto) {
        return modelMapper.map(dto, TipoFacturaEntity.class);
    }

}

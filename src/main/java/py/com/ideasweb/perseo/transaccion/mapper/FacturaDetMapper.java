package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaDetDTO;
import py.com.ideasweb.perseo.transaccion.entities.FacturaDetEntity;

/**
 * @author jdferreira
 */
@Component
public class FacturaDetMapper
        implements BaseMapper<FacturaDetEntity, FacturaDetDTO> {

    private final ModelMapper modelMapper;

    public FacturaDetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FacturaDetDTO> entityListToDtoList(
            List<FacturaDetEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FacturaDetDTO entityToDto(FacturaDetEntity entity) {
        FacturaDetDTO dto = modelMapper.map(entity, FacturaDetDTO.class);
        return dto;
    }

    @Override
    public FacturaDetEntity dtoToEntity(FacturaDetDTO dto) {
        return modelMapper.map(dto, FacturaDetEntity.class);
    }

}

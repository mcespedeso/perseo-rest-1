package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaDTO;
import py.com.ideasweb.perseo.transaccion.entities.FacturaEntity;

/**
 * @author jdferreira
 */
@Component
public class FacturaMapper implements BaseMapper<FacturaEntity, FacturaDTO> {

    private final ModelMapper modelMapper;

    public FacturaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FacturaDTO> entityListToDtoList(
            List<FacturaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FacturaDTO entityToDto(FacturaEntity entity) {
        FacturaDTO dto = modelMapper.map(entity, FacturaDTO.class);
        return dto;
    }

    @Override
    public FacturaEntity dtoToEntity(FacturaDTO dto) {
        return modelMapper.map(dto, FacturaEntity.class);
    }

}

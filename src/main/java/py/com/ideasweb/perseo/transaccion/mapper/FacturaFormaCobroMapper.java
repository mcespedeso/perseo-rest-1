package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaFormaCobroDTO;
import py.com.ideasweb.perseo.transaccion.entities.FacturaFormaCobroEntity;

/**
 * @author jdferreira
 */
@Component
public class FacturaFormaCobroMapper
        implements BaseMapper<FacturaFormaCobroEntity, FacturaFormaCobroDTO> {

    private final ModelMapper modelMapper;

    public FacturaFormaCobroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FacturaFormaCobroDTO> entityListToDtoList(
            List<FacturaFormaCobroEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FacturaFormaCobroDTO entityToDto(FacturaFormaCobroEntity entity) {
        FacturaFormaCobroDTO dto = modelMapper.map(entity,
                FacturaFormaCobroDTO.class);
        return dto;
    }

    @Override
    public FacturaFormaCobroEntity dtoToEntity(FacturaFormaCobroDTO dto) {
        return modelMapper.map(dto, FacturaFormaCobroEntity.class);
    }

}

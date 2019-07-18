package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaPlazoDTO;
import py.com.ideasweb.perseo.transaccion.entities.FacturaPlazoEntity;

/**
 * @author jdferreira
 */
@Component
public class FacturaPlazoMapper
        implements BaseMapper<FacturaPlazoEntity, FacturaPlazoDTO> {

    private final ModelMapper modelMapper;

    public FacturaPlazoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FacturaPlazoDTO> entityListToDtoList(
            List<FacturaPlazoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FacturaPlazoDTO entityToDto(FacturaPlazoEntity entity) {
        FacturaPlazoDTO dto = modelMapper.map(entity, FacturaPlazoDTO.class);
        return dto;
    }

    @Override
    public FacturaPlazoEntity dtoToEntity(FacturaPlazoDTO dto) {
        return modelMapper.map(dto, FacturaPlazoEntity.class);
    }

}

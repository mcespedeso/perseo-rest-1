package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoDetDTO;
import py.com.ideasweb.perseo.tesoreria.entities.OrdenPagoDetEntity;

/**
 * @author jdferreira
 */
@Component
public class OrdenPagoDetMapper
        implements BaseMapper<OrdenPagoDetEntity, OrdenPagoDetDTO> {

    private final ModelMapper modelMapper;

    public OrdenPagoDetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrdenPagoDetDTO> entityListToDtoList(
            List<OrdenPagoDetEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public OrdenPagoDetDTO entityToDto(OrdenPagoDetEntity entity) {
        OrdenPagoDetDTO dto = modelMapper.map(entity, OrdenPagoDetDTO.class);
        return dto;
    }

    @Override
    public OrdenPagoDetEntity dtoToEntity(OrdenPagoDetDTO dto) {
        return modelMapper.map(dto, OrdenPagoDetEntity.class);
    }

}

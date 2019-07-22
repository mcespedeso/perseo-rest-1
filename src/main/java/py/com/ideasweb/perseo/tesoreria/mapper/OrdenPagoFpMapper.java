package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoFpDTO;
import py.com.ideasweb.perseo.tesoreria.entities.OrdenPagoFpEntity;

/**
 * @author jdferreira
 */
@Component
public class OrdenPagoFpMapper
        implements BaseMapper<OrdenPagoFpEntity, OrdenPagoFpDTO> {

    private final ModelMapper modelMapper;

    public OrdenPagoFpMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrdenPagoFpDTO> entityListToDtoList(
            List<OrdenPagoFpEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public OrdenPagoFpDTO entityToDto(OrdenPagoFpEntity entity) {
        OrdenPagoFpDTO dto = modelMapper.map(entity, OrdenPagoFpDTO.class);
        return dto;
    }

    @Override
    public OrdenPagoFpEntity dtoToEntity(OrdenPagoFpDTO dto) {
        return modelMapper.map(dto, OrdenPagoFpEntity.class);
    }

}

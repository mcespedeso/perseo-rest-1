package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.EstadoVentaDTO;
import py.com.ideasweb.perseo.transaccion.entities.EstadoVentaEntity;

/**
 * @author jdferreira
 */
@Component
public class EstadoVentaMapper
        implements BaseMapper<EstadoVentaEntity, EstadoVentaDTO> {

    private final ModelMapper modelMapper;

    public EstadoVentaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EstadoVentaDTO> entityListToDtoList(
            List<EstadoVentaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public EstadoVentaDTO entityToDto(EstadoVentaEntity entity) {
        EstadoVentaDTO dto = modelMapper.map(entity, EstadoVentaDTO.class);
        return dto;
    }

    @Override
    public EstadoVentaEntity dtoToEntity(EstadoVentaDTO dto) {
        return modelMapper.map(dto, EstadoVentaEntity.class);
    }

}

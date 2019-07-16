package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.EstadoCompraDTO;
import py.com.ideasweb.perseo.transaccion.entities.EstadoCompraEntity;

/**
 * @author jdferreira
 */
@Component
public class EstadoCompraMapper
        implements BaseMapper<EstadoCompraEntity, EstadoCompraDTO> {

    private final ModelMapper modelMapper;

    public EstadoCompraMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EstadoCompraDTO> entityListToDtoList(
            List<EstadoCompraEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public EstadoCompraDTO entityToDto(EstadoCompraEntity entity) {
        EstadoCompraDTO dto = modelMapper.map(entity, EstadoCompraDTO.class);
        return dto;
    }

    @Override
    public EstadoCompraEntity dtoToEntity(EstadoCompraDTO dto) {
        return modelMapper.map(dto, EstadoCompraEntity.class);
    }

}

package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.UnidadMedidaDTO;
import py.com.ideasweb.perseo.stock.entities.UnidadMedidaEntity;

/**
 * @author jdferreira
 */
@Component
public class UnidadMedidaMapper
        implements BaseMapper<UnidadMedidaEntity, UnidadMedidaDTO> {

    private final ModelMapper modelMapper;

    public UnidadMedidaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UnidadMedidaDTO> entityListToDtoList(
            List<UnidadMedidaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public UnidadMedidaDTO entityToDto(UnidadMedidaEntity entity) {
        UnidadMedidaDTO dto = modelMapper.map(entity, UnidadMedidaDTO.class);
        return dto;
    }

    @Override
    public UnidadMedidaEntity dtoToEntity(UnidadMedidaDTO dto) {
        return modelMapper.map(dto, UnidadMedidaEntity.class);
    }

}

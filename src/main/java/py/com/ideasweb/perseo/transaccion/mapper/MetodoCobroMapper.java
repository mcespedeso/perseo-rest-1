package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.MetodoCobroDTO;
import py.com.ideasweb.perseo.transaccion.entities.MetodoCobroEntity;

/**
 * @author jdferreira
 */
@Component
public class MetodoCobroMapper
        implements BaseMapper<MetodoCobroEntity, MetodoCobroDTO> {

    private final ModelMapper modelMapper;

    public MetodoCobroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MetodoCobroDTO> entityListToDtoList(
            List<MetodoCobroEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public MetodoCobroDTO entityToDto(MetodoCobroEntity entity) {
        MetodoCobroDTO dto = modelMapper.map(entity, MetodoCobroDTO.class);
        return dto;
    }

    @Override
    public MetodoCobroEntity dtoToEntity(MetodoCobroDTO dto) {
        return modelMapper.map(dto, MetodoCobroEntity.class);
    }

}

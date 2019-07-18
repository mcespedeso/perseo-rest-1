package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.TurnoDTO;
import py.com.ideasweb.perseo.transaccion.entities.TurnoEntity;

/**
 * @author jdferreira
 */
@Component
public class TurnoMapper implements BaseMapper<TurnoEntity, TurnoDTO> {

    private final ModelMapper modelMapper;

    public TurnoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TurnoDTO> entityListToDtoList(List<TurnoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public TurnoDTO entityToDto(TurnoEntity entity) {
        TurnoDTO dto = modelMapper.map(entity, TurnoDTO.class);
        return dto;
    }

    @Override
    public TurnoEntity dtoToEntity(TurnoDTO dto) {
        return modelMapper.map(dto, TurnoEntity.class);
    }

}

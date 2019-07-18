package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.CajaDTO;
import py.com.ideasweb.perseo.tesoreria.entities.CajaEntity;

/**
 * @author jdferreira
 */
@Component
public class CajaMapper implements BaseMapper<CajaEntity, CajaDTO> {

    private final ModelMapper modelMapper;

    public CajaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CajaDTO> entityListToDtoList(List<CajaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public CajaDTO entityToDto(CajaEntity entity) {
        CajaDTO dto = modelMapper.map(entity, CajaDTO.class);
        return dto;
    }

    @Override
    public CajaEntity dtoToEntity(CajaDTO dto) {
        return modelMapper.map(dto, CajaEntity.class);
    }

}

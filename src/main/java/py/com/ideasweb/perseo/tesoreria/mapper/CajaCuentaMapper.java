package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.CajaCuentaDTO;
import py.com.ideasweb.perseo.tesoreria.entities.CajaCuentaEntity;

/**
 * @author jdferreira
 */
@Component
public class CajaCuentaMapper
        implements BaseMapper<CajaCuentaEntity, CajaCuentaDTO> {

    private final ModelMapper modelMapper;

    public CajaCuentaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CajaCuentaDTO> entityListToDtoList(
            List<CajaCuentaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public CajaCuentaDTO entityToDto(CajaCuentaEntity entity) {
        CajaCuentaDTO dto = modelMapper.map(entity, CajaCuentaDTO.class);
        return dto;
    }

    @Override
    public CajaCuentaEntity dtoToEntity(CajaCuentaDTO dto) {
        return modelMapper.map(dto, CajaCuentaEntity.class);
    }

}

package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.OrdenPagoCabDTO;
import py.com.ideasweb.perseo.tesoreria.entities.OrdenPagoCabEntity;

/**
 * @author jdferreira
 */
@Component
public class OrdenPagoCabMapper
        implements BaseMapper<OrdenPagoCabEntity, OrdenPagoCabDTO> {

    private final ModelMapper modelMapper;

    public OrdenPagoCabMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrdenPagoCabDTO> entityListToDtoList(
            List<OrdenPagoCabEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public OrdenPagoCabDTO entityToDto(OrdenPagoCabEntity entity) {
        OrdenPagoCabDTO dto = modelMapper.map(entity, OrdenPagoCabDTO.class);
        return dto;
    }

    @Override
    public OrdenPagoCabEntity dtoToEntity(OrdenPagoCabDTO dto) {
        return modelMapper.map(dto, OrdenPagoCabEntity.class);
    }

}

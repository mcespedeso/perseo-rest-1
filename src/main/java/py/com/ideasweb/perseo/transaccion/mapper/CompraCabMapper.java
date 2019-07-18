package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.CompraCabDTO;
import py.com.ideasweb.perseo.transaccion.entities.CompraCabEntity;

/**
 * @author jdferreira
 */
@Component
public class CompraCabMapper
        implements BaseMapper<CompraCabEntity, CompraCabDTO> {

    private final ModelMapper modelMapper;

    public CompraCabMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompraCabDTO> entityListToDtoList(
            List<CompraCabEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public CompraCabDTO entityToDto(CompraCabEntity entity) {
        CompraCabDTO dto = modelMapper.map(entity, CompraCabDTO.class);
        return dto;
    }

    @Override
    public CompraCabEntity dtoToEntity(CompraCabDTO dto) {
        return modelMapper.map(dto, CompraCabEntity.class);
    }

}

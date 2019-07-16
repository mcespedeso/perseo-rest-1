package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.MarcaDTO;
import py.com.ideasweb.perseo.stock.entities.MarcaEntity;

/**
 * @author jdferreira
 */
@Component
public class MarcaMapper implements BaseMapper<MarcaEntity, MarcaDTO> {

    private final ModelMapper modelMapper;

    public MarcaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MarcaDTO> entityListToDtoList(List<MarcaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public MarcaDTO entityToDto(MarcaEntity entity) {
        MarcaDTO dto = modelMapper.map(entity, MarcaDTO.class);
        return dto;
    }

    @Override
    public MarcaEntity dtoToEntity(MarcaDTO dto) {
        return modelMapper.map(dto, MarcaEntity.class);
    }

}

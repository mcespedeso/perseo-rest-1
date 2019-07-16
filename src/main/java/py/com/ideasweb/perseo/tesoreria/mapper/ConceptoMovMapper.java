package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.ConceptoMovDTO;
import py.com.ideasweb.perseo.tesoreria.entities.ConceptoMovEntity;

/**
 * @author jdferreira
 */
@Component
public class ConceptoMovMapper
        implements BaseMapper<ConceptoMovEntity, ConceptoMovDTO> {

    private final ModelMapper modelMapper;

    public ConceptoMovMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ConceptoMovDTO> entityListToDtoList(
            List<ConceptoMovEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ConceptoMovDTO entityToDto(ConceptoMovEntity entity) {
        ConceptoMovDTO dto = modelMapper.map(entity, ConceptoMovDTO.class);
        return dto;
    }

    @Override
    public ConceptoMovEntity dtoToEntity(ConceptoMovDTO dto) {
        return modelMapper.map(dto, ConceptoMovEntity.class);
    }

}

package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.FamiliaDTO;
import py.com.ideasweb.perseo.stock.entities.FamiliaEntity;

/**
 * @author jdferreira
 */
@Component
public class FamiliaMapper implements BaseMapper<FamiliaEntity, FamiliaDTO> {

    private final ModelMapper modelMapper;

    public FamiliaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FamiliaDTO> entityListToDtoList(
            List<FamiliaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FamiliaDTO entityToDto(FamiliaEntity entity) {
        FamiliaDTO dto = modelMapper.map(entity, FamiliaDTO.class);
        return dto;
    }

    @Override
    public FamiliaEntity dtoToEntity(FamiliaDTO dto) {
        return modelMapper.map(dto, FamiliaEntity.class);
    }

}

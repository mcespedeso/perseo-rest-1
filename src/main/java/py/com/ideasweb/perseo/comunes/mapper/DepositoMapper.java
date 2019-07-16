package py.com.ideasweb.perseo.comunes.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.comunes.entities.DepositoEntity;

/**
 * @author jdferreira
 */
@Component
public class DepositoMapper implements BaseMapper<DepositoEntity, DepositoDTO> {

    private final ModelMapper modelMapper;

    public DepositoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DepositoDTO> entityListToDtoList(
            List<DepositoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public DepositoDTO entityToDto(DepositoEntity entity) {
        DepositoDTO dto = modelMapper.map(entity, DepositoDTO.class);
        return dto;
    }

    @Override
    public DepositoEntity dtoToEntity(DepositoDTO dto) {
        return modelMapper.map(dto, DepositoEntity.class);
    }

}

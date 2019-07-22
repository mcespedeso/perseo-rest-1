package py.com.ideasweb.perseo.tesoreria.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.tesoreria.dtos.BancoDTO;
import py.com.ideasweb.perseo.tesoreria.entities.BancoEntity;

/**
 * @author jdferreira
 */
@Component
public class BancoMapper implements BaseMapper<BancoEntity, BancoDTO> {

    private final ModelMapper modelMapper;

    public BancoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BancoDTO> entityListToDtoList(List<BancoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public BancoDTO entityToDto(BancoEntity entity) {
        BancoDTO dto = modelMapper.map(entity, BancoDTO.class);
        return dto;
    }

    @Override
    public BancoEntity dtoToEntity(BancoDTO dto) {
        return modelMapper.map(dto, BancoEntity.class);
    }

}

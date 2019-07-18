package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaDetDTO;
import py.com.ideasweb.perseo.stock.entities.ArticuloTransferenciaDetEntity;

/**
 * @author jdferreira
 */
@Component
public class ArticuloTransferenciaDetMapper implements
        BaseMapper<ArticuloTransferenciaDetEntity, ArticuloTransferenciaDetDTO> {

    private final ModelMapper modelMapper;

    public ArticuloTransferenciaDetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticuloTransferenciaDetDTO> entityListToDtoList(
            List<ArticuloTransferenciaDetEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloTransferenciaDetDTO entityToDto(
            ArticuloTransferenciaDetEntity entity) {
        ArticuloTransferenciaDetDTO dto = modelMapper.map(entity,
                ArticuloTransferenciaDetDTO.class);
        return dto;
    }

    @Override
    public ArticuloTransferenciaDetEntity dtoToEntity(
            ArticuloTransferenciaDetDTO dto) {
        return modelMapper.map(dto, ArticuloTransferenciaDetEntity.class);
    }

}

package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.ArticuloTransferenciaCabDTO;
import py.com.ideasweb.perseo.stock.entities.ArticuloTransferenciaCabEntity;

/**
 * @author jdferreira
 */
@Component
public class ArticuloTransferenciaCabMapper implements
        BaseMapper<ArticuloTransferenciaCabEntity, ArticuloTransferenciaCabDTO> {

    private final ModelMapper modelMapper;

    public ArticuloTransferenciaCabMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticuloTransferenciaCabDTO> entityListToDtoList(
            List<ArticuloTransferenciaCabEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloTransferenciaCabDTO entityToDto(
            ArticuloTransferenciaCabEntity entity) {
        ArticuloTransferenciaCabDTO dto = modelMapper.map(entity,
                ArticuloTransferenciaCabDTO.class);
        return dto;
    }

    @Override
    public ArticuloTransferenciaCabEntity dtoToEntity(
            ArticuloTransferenciaCabDTO dto) {
        return modelMapper.map(dto, ArticuloTransferenciaCabEntity.class);
    }

}

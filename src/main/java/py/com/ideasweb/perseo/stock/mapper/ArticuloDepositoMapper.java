package py.com.ideasweb.perseo.stock.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
import py.com.ideasweb.perseo.stock.entities.ArticuloDepositoEntity;

/**
 * @author jdferreira
 */
@Component
public class ArticuloDepositoMapper
        implements BaseMapper<ArticuloDepositoEntity, ArticuloDepositoDTO> {

    private final ModelMapper modelMapper;

    public ArticuloDepositoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticuloDepositoDTO> entityListToDtoList(
            List<ArticuloDepositoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloDepositoDTO entityToDto(ArticuloDepositoEntity entity) {
        ArticuloDepositoDTO dto = modelMapper.map(entity,
                ArticuloDepositoDTO.class);
        return dto;
    }

    @Override
    public ArticuloDepositoEntity dtoToEntity(ArticuloDepositoDTO dto) {
        return modelMapper.map(dto, ArticuloDepositoEntity.class);
    }

}

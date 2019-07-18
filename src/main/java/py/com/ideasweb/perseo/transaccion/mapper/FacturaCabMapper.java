package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.FacturaCabDTO;
import py.com.ideasweb.perseo.transaccion.entities.FacturaCabEntity;

/**
 * @author jdferreira
 */
@Component
public class FacturaCabMapper
        implements BaseMapper<FacturaCabEntity, FacturaCabDTO> {

    private final ModelMapper modelMapper;

    public FacturaCabMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FacturaCabDTO> entityListToDtoList(
            List<FacturaCabEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FacturaCabDTO entityToDto(FacturaCabEntity entity) {
        FacturaCabDTO dto = modelMapper.map(entity, FacturaCabDTO.class);
        return dto;
    }

    @Override
    public FacturaCabEntity dtoToEntity(FacturaCabDTO dto) {
        return modelMapper.map(dto, FacturaCabEntity.class);
    }

}

package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.VentaCabDTO;
import py.com.ideasweb.perseo.transaccion.entities.VentaCabEntity;

/**
 * @author jdferreira
 */
@Component
public class VentaCabMapper implements BaseMapper<VentaCabEntity, VentaCabDTO> {

    private final ModelMapper modelMapper;

    public VentaCabMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VentaCabDTO> entityListToDtoList(
            List<VentaCabEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public VentaCabDTO entityToDto(VentaCabEntity entity) {
        VentaCabDTO dto = modelMapper.map(entity, VentaCabDTO.class);
        return dto;
    }

    @Override
    public VentaCabEntity dtoToEntity(VentaCabDTO dto) {
        return modelMapper.map(dto, VentaCabEntity.class);
    }

}

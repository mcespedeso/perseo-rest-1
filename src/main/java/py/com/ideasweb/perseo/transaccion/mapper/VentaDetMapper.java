package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.VentaDetDTO;
import py.com.ideasweb.perseo.transaccion.entities.VentaDetEntity;

/**
 * @author jdferreira
 */
@Component
public class VentaDetMapper implements BaseMapper<VentaDetEntity, VentaDetDTO> {

    private final ModelMapper modelMapper;

    public VentaDetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VentaDetDTO> entityListToDtoList(
            List<VentaDetEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public VentaDetDTO entityToDto(VentaDetEntity entity) {
        VentaDetDTO dto = modelMapper.map(entity, VentaDetDTO.class);
        return dto;
    }

    @Override
    public VentaDetEntity dtoToEntity(VentaDetDTO dto) {
        return modelMapper.map(dto, VentaDetEntity.class);
    }

}

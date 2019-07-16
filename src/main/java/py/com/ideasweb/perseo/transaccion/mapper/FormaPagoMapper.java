package py.com.ideasweb.perseo.transaccion.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.transaccion.dtos.FormaPagoDTO;
import py.com.ideasweb.perseo.transaccion.entities.FormaPagoEntity;

/**
 * @author jdferreira
 */
@Component
public class FormaPagoMapper
        implements BaseMapper<FormaPagoEntity, FormaPagoDTO> {

    private final ModelMapper modelMapper;

    public FormaPagoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FormaPagoDTO> entityListToDtoList(
            List<FormaPagoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FormaPagoDTO entityToDto(FormaPagoEntity entity) {
        FormaPagoDTO dto = modelMapper.map(entity, FormaPagoDTO.class);
        return dto;
    }

    @Override
    public FormaPagoEntity dtoToEntity(FormaPagoDTO dto) {
        return modelMapper.map(dto, FormaPagoEntity.class);
    }

}

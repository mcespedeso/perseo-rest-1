package py.com.ideasweb.perseo.comunes.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.comunes.dtos.EmpresaDTO;
import py.com.ideasweb.perseo.comunes.entities.EmpresaEntity;

/**
 * @author jdferreira
 */
@Component
public class EmpresaMapper implements BaseMapper<EmpresaEntity, EmpresaDTO> {

    private final ModelMapper modelMapper;

    public EmpresaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmpresaDTO> entityListToDtoList(
            List<EmpresaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public EmpresaDTO entityToDto(EmpresaEntity entity) {
        EmpresaDTO dto = modelMapper.map(entity, EmpresaDTO.class);
        return dto;
    }

    @Override
    public EmpresaEntity dtoToEntity(EmpresaDTO dto) {
        return modelMapper.map(dto, EmpresaEntity.class);
    }

}

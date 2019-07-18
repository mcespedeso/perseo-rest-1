package py.com.ideasweb.perseo.comunes.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.ideasweb.perseo.common.mapper.BaseMapper;
import py.com.ideasweb.perseo.comunes.dtos.ClienteDTO;
import py.com.ideasweb.perseo.comunes.entities.ClienteEntity;

/**
 * @author jdferreira
 */
@Component
public class ClienteMapper implements BaseMapper<ClienteEntity, ClienteDTO> {

    private final ModelMapper modelMapper;

    public ClienteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClienteDTO> entityListToDtoList(
            List<ClienteEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO entityToDto(ClienteEntity entity) {
        ClienteDTO dto = modelMapper.map(entity, ClienteDTO.class);
        return dto;
    }

    @Override
    public ClienteEntity dtoToEntity(ClienteDTO dto) {
        return modelMapper.map(dto, ClienteEntity.class);
    }

}

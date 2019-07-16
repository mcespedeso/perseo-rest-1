package py.com.ideasweb.perseo.common.mapper;

import java.util.List;

public interface BaseMapper<E, D> {
    List<D> entityListToDtoList(List<E> entityList);

    D entityToDto(E entity);

    E dtoToEntity(D dto);
}

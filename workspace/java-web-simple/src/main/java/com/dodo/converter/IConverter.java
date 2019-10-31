package com.dodo.converter;

import com.dodo.dto.AbstractDTO;
import com.dodo.entity.BaseEntity;

public interface IConverter<D extends AbstractDTO<?>, E extends BaseEntity> {
	D toDTO(E entity);
	E toEntity(D dto);
}

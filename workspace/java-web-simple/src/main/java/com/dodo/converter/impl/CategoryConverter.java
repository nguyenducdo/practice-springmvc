package com.dodo.converter.impl;

import org.springframework.stereotype.Component;

import com.dodo.converter.IConverter;
import com.dodo.dto.CategoryDTO;
import com.dodo.entity.CategoryEntity;

@Component
public class CategoryConverter implements IConverter<CategoryDTO, CategoryEntity>{
	
	
	
	@Override
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(entity.getId());
		categoryDTO.setName(entity.getName());
		categoryDTO.setCode(entity.getCode());
		return categoryDTO;
	}

	@Override
	public CategoryEntity toEntity(CategoryDTO dto) {
		return null;
	}

}

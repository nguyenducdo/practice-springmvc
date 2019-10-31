package com.dodo.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dodo.converter.IConverter;
import com.dodo.dto.NewDTO;
import com.dodo.entity.NewEntity;
import com.dodo.repository.CategoryRepository;
import com.dodo.repository.NewRepository;

@Component
public class NewConverter implements IConverter<NewDTO, NewEntity>{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewRepository newRepository;
	
	@Override
	public NewDTO toDTO(NewEntity entity) {
		NewDTO newDTO = new NewDTO();
		newDTO.setId(entity.getId());
		newDTO.setTitle(entity.getTitle());
		newDTO.setThumbnail(entity.getThumbnail());
		newDTO.setShortDescription(entity.getShortDescription());
		newDTO.setContent(entity.getContent());
		newDTO.setCategoryCode(entity.getCategory().getCode());
		newDTO.setCategoryName(entity.getCategory().getName());
		return newDTO;
	}

	@Override
	public NewEntity toEntity(NewDTO dto) {
		NewEntity newEntity = new NewEntity();
		if(dto.getId()!=null) {
			newEntity = newRepository.findOne(dto.getId()); //để lấy ra createDate và createBy
		}
		newEntity.setTitle(dto.getTitle());
		newEntity.setThumbnail(dto.getThumbnail());
		newEntity.setShortDescription(dto.getShortDescription());
		newEntity.setContent(dto.getContent());
		newEntity.setCategory(categoryRepository.findOneByCode(dto.getCategoryCode()));
		return newEntity;
	}

}

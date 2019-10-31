package com.dodo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodo.converter.impl.CategoryConverter;
import com.dodo.dto.CategoryDTO;
import com.dodo.entity.CategoryEntity;
import com.dodo.repository.CategoryRepository;
import com.dodo.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		for(CategoryEntity entity : categoryRepository.findAll()) {
			list.add(categoryConverter.toDTO(entity));
		}
		return list;
	}

	@Override
	public CategoryDTO findOneByCode(String code) {
		CategoryEntity entity = categoryRepository.findOneByCode(code);
		return categoryConverter.toDTO(entity);
	}

	@Override
	public Map<String, String> findAllCodeNameSet() {
		Map<String, String> result = new HashMap<String, String>();
		for(CategoryEntity entity : categoryRepository.findAll()) {
			result.put(entity.getCode(), entity.getName());
		}
		return result;
	}

}

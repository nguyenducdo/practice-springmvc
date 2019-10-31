package com.dodo.service;

import java.util.List;
import java.util.Map;

import com.dodo.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	Map<String, String> findAllCodeNameSet();
	CategoryDTO findOneByCode(String code);
}

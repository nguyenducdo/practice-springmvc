package com.dodo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dodo.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewDTO findOne(Long id);
	NewDTO save(NewDTO dto);
	void delete(long[] ids);
}

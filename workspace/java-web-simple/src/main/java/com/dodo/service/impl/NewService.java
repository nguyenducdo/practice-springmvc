package com.dodo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dodo.converter.IConverter;
import com.dodo.dto.NewDTO;
import com.dodo.entity.NewEntity;
import com.dodo.repository.NewRepository;
import com.dodo.service.INewService;

@Service
public class NewService implements INewService{
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private IConverter<NewDTO, NewEntity> newConverter;
	
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> list = new ArrayList<NewDTO>();
		for(NewEntity entity : newRepository.findAll(pageable).getContent()) {
			list.add(newConverter.toDTO(entity));
		}
		return list;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findOne(Long id) {
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDTO(entity);
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		NewEntity newEntity = newConverter.toEntity(dto);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id : ids) {
			newRepository.delete(id);
		}
	}
	
	

}

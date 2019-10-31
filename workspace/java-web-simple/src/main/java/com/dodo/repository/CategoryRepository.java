package com.dodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dodo.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}

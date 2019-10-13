package com.dodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dodo.entity.NewEntity;

//mặc định đã có @repository (cung cấp các hàm chung truy vấn csdl)
public interface NewRepository extends JpaRepository<NewEntity, Long> {

}

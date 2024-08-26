package com.MO.Software.category.Service;

import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.category.categoryModel;

@Repository
public interface categoryRepository extends baseRepository<categoryModel, Long> {
	
}
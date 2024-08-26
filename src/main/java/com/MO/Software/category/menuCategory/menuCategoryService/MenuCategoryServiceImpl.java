package com.MO.Software.category.menuCategory.menuCategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.category.menuCategory.MenuCategoryModel;

@Service
public class MenuCategoryServiceImpl 
extends baseServiceImpl<MenuCategoryModel,Long> 
implements MenuCategoryServiceInterface{

	@Autowired
	private MenuCategoryRepository MenuCategoryRepository;
	
	@Override
	protected baseRepository<MenuCategoryModel, Long> getRepository() {
		return MenuCategoryRepository;
	}

	@Override
	public MenuCategoryModel findByExactCategoryName(String categoryName) {
		return MenuCategoryRepository.findByCategoryName(categoryName);
	}


	@Override
	public List<MenuCategoryModel> findByAproxmatedCategoryName(String categoryName) {
		return MenuCategoryRepository.findByLikeCategoryName(categoryName);
	}

}

package com.MO.Software.category.menuCategory.menuCategoryService;

import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.category.menuCategory.MenuCategoryModel;

public interface MenuCategoryServiceInterface 
extends baseServiceInterface<MenuCategoryModel,Long>{

	MenuCategoryModel findByExactCategoryName(String categoryName);
	List<MenuCategoryModel> findByAproxmatedCategoryName(String categoryName);
}

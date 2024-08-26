package com.MO.Software.category.menuCategory.menuCategoryService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.category.menuCategory.MenuCategoryModel;

@Repository
public interface MenuCategoryRepository extends baseRepository<MenuCategoryModel,Long>{

	@Query("Select mc from MenuCategoryModel mc where mc.categoryName=:categoryName")
	MenuCategoryModel findByCategoryName(String categoryName);

	@Query("Select mc from MenuCategoryModel mc where mc.categoryName LIKE %:categoryName%")
	List<MenuCategoryModel> findByLikeCategoryName(String categoryName);
	
}

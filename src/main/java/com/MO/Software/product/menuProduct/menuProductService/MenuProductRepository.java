package com.MO.Software.product.menuProduct.menuProductService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.product.menuProduct.MenuProductModel;

@Repository
public interface MenuProductRepository 
extends baseRepository<MenuProductModel,Long> ,JpaSpecificationExecutor<MenuProductModel>{

	@Query("SELECT mp FROM MenuProductModel mp WHERE mp.productName LIKE %:productName%")
	List<MenuProductModel> findByProductName(String productName);
	
	@Query("SELECT mp FROM MenuProductModel mp WHERE mp.productName=:productName")
	MenuProductModel findByProductNameDistinct(String productName);

	@Query("SELECT mp FROM MenuProductModel mp WHERE mp.menuCategoryModel.id=:id")
	List<MenuProductModel> findByMenuCategoryId(Long id);
}

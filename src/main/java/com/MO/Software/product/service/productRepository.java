package com.MO.Software.product.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.product.productModel;

@Repository
public interface productRepository extends baseRepository<productModel,Long>{

	@Query("SELECT p from productModel p where p.categoryModel.id=:categoryId")
	List<productModel> findByCategoryModelId(Long categoryId);

	@Query("SELECT p FROM productModel p WHERE p.name LIKE %:productName%")
	List<productModel> findByNameLike(@Param("productName") String productName);

	@Query("SELECT p FROM productModel p WHERE p.name=:productName")
	productModel findByName(@Param("productName") String productName);

	@Query("SELECT p FROM productModel p WHERE p.categoryModel.id=:categoryModelId AND p.buyPrice <= :buyPrice")
	List<productModel> findByCategoryModelIdAndBuyPrice(Long categoryModelId, Double buyPrice);

	@Query("SELECT p FROM productModel p WHERE p.categoryModel.id=:categoryModelId AND p.sellPrice <= :sellPrice")
	Collection<productModel> findByCategoryModelIdAndSellPrice(Long categoryModelId, Double sellPrice);

	@Query("SELECT p FROM productModel p WHERE p.categoryModel.id=:categoryModelId AND p.gainPercentage <= :gainPercentage")
	Collection<productModel> findByCategoryModelIdAndGainPercentage(Long categoryModelId, Double gainPercentage);

	@Query("SELECT p.buyPrice FROM productModel p WHERE p.id=:productId")
	Double findBuyPriceByProductId(Long productId);

	
}

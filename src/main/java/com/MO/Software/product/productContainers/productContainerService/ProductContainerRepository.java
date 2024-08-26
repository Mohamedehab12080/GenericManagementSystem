package com.MO.Software.product.productContainers.productContainerService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.product.productContainers.ProductContainer;
import com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO;

@Repository
public interface ProductContainerRepository 
extends baseRepository<ProductContainer,Long>{

	@Query("Select new com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO("
			+ "pc.id,"
			+ "pc.productModel.id,"
			+ "pc.productModel.name,"
			+ "pc.container.id,"
			+ "pc.container.name,"
			+ "pc.quantity)"
			+ " From ProductContainer pc where pc.productModel.id=:productId")
	List<ProductContainerDTO> findByProductId(@Param("productId") Long productId);

	@Query("Select new com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO("
			+ "pc.id,"
			+ "pc.productModel.id,"
			+ "pc.productModel.name,"
			+ "pc.container.id,"
			+ "pc.container.name,"
			+ "pc.quantity)"
			+ " From ProductContainer pc where "
			+ "pc.productModel.id=:productId"
			+ " And pc.container.id=:ContainerId")
	ProductContainerDTO findByProductIdAndContainerId(@Param("productId") Long productId,@Param("ContainerId") Long containerId);

	@Query("Select pc.productModel.id From ProductContainer pc where pc.container.id=:containerId")
	List<Long> findByContainerId(@Param("containerId") Long containerId);
}

package com.MO.Software.product.productContainers.productMoreThanContainer.productMoreThanContainerService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.product.productContainers.productMoreThanContainer.StoreProductMoreThanContainer;

@Repository
public interface ProductMoreThanContainerRepository 
extends baseRepository<StoreProductMoreThanContainer,Long>{

	
	@Query("SELECT spc From StoreProductMoreThanContainer spc where "
			+ "spc.containerName=:containerName And spc.storeProduct.id=:storeProductId")
	StoreProductMoreThanContainer findByStoreProductIdAndContainerName(Long storeProductId, String containerName);

}

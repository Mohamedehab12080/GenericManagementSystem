package com.MO.Software.product.productContainers.productMoreThanContainer.productMoreThanContainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.product.productContainers.productMoreThanContainer.StoreProductMoreThanContainer;

@Service
public class ProductMoreThanContainerServiceImpl 
extends baseServiceImpl<StoreProductMoreThanContainer,Long>
 implements ProductMoreThanContainerServiceInterface{

	@Autowired
	private ProductMoreThanContainerRepository ProductMoreThanContainerRepository;
	
	@Override
	protected baseRepository<StoreProductMoreThanContainer, Long> getRepository() {
		return ProductMoreThanContainerRepository;
	}

	@Override
	public StoreProductMoreThanContainer findByStoreProductIdAndContainerName(Long storeProductId,
			String containerName) {
		
		return ProductMoreThanContainerRepository.findByStoreProductIdAndContainerName(storeProductId,containerName);
	}

}

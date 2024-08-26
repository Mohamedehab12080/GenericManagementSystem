package com.MO.Software.product.productContainers.productMoreThanContainer.productMoreThanContainerService;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.product.productContainers.productMoreThanContainer.StoreProductMoreThanContainer;

public interface ProductMoreThanContainerServiceInterface 
extends baseServiceInterface<StoreProductMoreThanContainer,Long>{

	StoreProductMoreThanContainer findByStoreProductIdAndContainerName(Long storeProductId, String containerName);

}

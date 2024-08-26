package com.MO.Software.product.productContainers.productContainerService;

import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.product.productContainers.ProductContainer;
import com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO;
import com.MO.Software.product.service.responseOperations;

public interface productContainerServiceInterface 
extends baseServiceInterface<ProductContainer,Long>{

	responseOperations<ProductContainerDTO> findByProductId(Long productId);
	List<Long> findProductIdByContainerId(Long containerId);
	responseOperations<ProductContainerDTO> insertProductContainer(ProductContainerDTO dto);
}

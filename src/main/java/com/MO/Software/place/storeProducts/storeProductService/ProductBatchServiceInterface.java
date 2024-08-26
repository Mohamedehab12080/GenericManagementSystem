package com.MO.Software.place.storeProducts.storeProductService;

import java.util.List;



import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.place.storeProducts.ProductBatchModel;
import com.MO.Software.place.storeProducts.storeProductsDTO.ProductBatchDTO;
import com.MO.Software.product.service.responseOperations;

public interface ProductBatchServiceInterface 
extends baseServiceInterface<ProductBatchModel,Long>{


	ProductBatchDTO calculateNumberOfContainersFromSingle(Long StoreProductId);
	ProductBuyPriceAndSellAndQuantityAndIdRetrieve findProductQuantityByProductId(Long productId,List<Long> places);
	Double calculateTotalQuantity(Long productId);
	responseOperations<ProductBatchDTO> createProductBatchProduct(ProductBatchDTO dto);
	List<InventoryIdAndName> findInventoryIdAndNameByProductId(Long productId);
	List<ProductBatchDTO> findProductBatchesWithCriteria(ProductBatchSearch productBatchSearch);
}

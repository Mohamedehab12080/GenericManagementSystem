package com.MO.Software.product.inventoryProductLowStockThreshold.inventoryProductLowStockThresholdService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.product.inventoryProductLowStockThreshold.InventoryProductLowStockThresholdModel;

@Repository
public interface InventoryProductLowStockThresholdRepository extends baseRepository<InventoryProductLowStockThresholdModel,Long>{

	@Query("SELECT inp from InventoryProductLowStockThresholdModel inp where inp.placeModel.id=:placeId And inp.productModel.id=:productId")
	List<InventoryProductLowStockThresholdModel> findByProductModelIdAndPlaceModelId(Long productId,Long placeId);
	
}

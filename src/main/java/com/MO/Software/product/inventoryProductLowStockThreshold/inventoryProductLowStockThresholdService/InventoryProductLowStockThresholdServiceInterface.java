package com.MO.Software.product.inventoryProductLowStockThreshold.inventoryProductLowStockThresholdService;

import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.product.inventoryProductLowStockThreshold.InventoryProductLowStockThresholdModel;

public interface InventoryProductLowStockThresholdServiceInterface extends baseServiceInterface<InventoryProductLowStockThresholdModel,Long>{

	List<InventoryProductLowStockThresholdModel> findByProductIdAndPlaceId(Long productId,Long placeId);
}

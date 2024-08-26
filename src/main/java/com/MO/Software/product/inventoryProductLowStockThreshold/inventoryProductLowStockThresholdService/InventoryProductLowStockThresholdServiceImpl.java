package com.MO.Software.product.inventoryProductLowStockThreshold.inventoryProductLowStockThresholdService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.product.inventoryProductLowStockThreshold.InventoryProductLowStockThresholdModel;

@Service
public class InventoryProductLowStockThresholdServiceImpl extends baseServiceImpl<InventoryProductLowStockThresholdModel,Long>
 implements InventoryProductLowStockThresholdServiceInterface{

	@Autowired
	private InventoryProductLowStockThresholdRepository InventoryProductLowStockThresholdRepository;
	
	@Override
	protected baseRepository<InventoryProductLowStockThresholdModel, Long> getRepository() {
		return InventoryProductLowStockThresholdRepository;
	}

	@Override
	public List<InventoryProductLowStockThresholdModel> findByProductIdAndPlaceId(Long productId, Long placeId) {
		return InventoryProductLowStockThresholdRepository.findByProductModelIdAndPlaceModelId(productId, placeId);
	}
	

}

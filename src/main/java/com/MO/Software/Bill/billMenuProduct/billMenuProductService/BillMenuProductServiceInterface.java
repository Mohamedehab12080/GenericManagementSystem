package com.MO.Software.Bill.billMenuProduct.billMenuProductService;

import java.util.List;

import com.MO.Software.Bill.billMenuProduct.BillMenuProductsModel;
import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.base.baseServiceInterface;

public interface BillMenuProductServiceInterface extends baseServiceInterface<BillMenuProductsModel,Long>{
	List<BillMenuProductsModel> findByBillModelId(Long billModelId);
	List<ProductSummaryDTO> findByCategoryId(Long categoryId,List<Long> billIds);
	List<ProductSummaryDTO> findByBillIds(List<Long> billIds);
}

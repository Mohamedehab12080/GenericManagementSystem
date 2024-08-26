package com.MO.Software.Bill.billMenuProduct.billMenuProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billMenuProduct.BillMenuProductsModel;
import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class BillMenuProductServiceImpl 
extends baseServiceImpl<BillMenuProductsModel,Long> implements BillMenuProductServiceInterface{

	@Autowired
	private BillMenuProductRepository BillMenuProductRepository;
	
	@Override
	protected baseRepository<BillMenuProductsModel, Long> getRepository() {
		return BillMenuProductRepository;
	}

	@Override
	public List<BillMenuProductsModel> findByBillModelId(Long billModelId) {
		return BillMenuProductRepository.findByBillModelId(billModelId);
	}

	@Override
	public List<ProductSummaryDTO> findByCategoryId(Long categoryId,List<Long> billIds) {
		
		return BillMenuProductRepository.findProductSummariesByCategoryIdAndBillModelIds(categoryId,billIds);
									
	}

	@Override
	public List<ProductSummaryDTO> findByBillIds(List<Long> billIds)
	{
		return BillMenuProductRepository.findProductSummariesByBillModelIds(billIds);
	}
}

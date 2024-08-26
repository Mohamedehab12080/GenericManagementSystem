package com.MO.Software.Bill.billProducts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billProducts.billProductModel;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class billProductServiceImpl 
extends baseServiceImpl<billProductModel,Long>
implements billProductServiceInterface{

	@Autowired
	private billProductRepository billProductRepository;
	
	@Override
	public List<billProductModel> findByBillModelId(Long billModelId) {
		return billProductRepository.findByBillModelId(billModelId);
	}

	@Override
	protected baseRepository<billProductModel, Long> getRepository() {
		return billProductRepository;
	}

	@Override
	public List<ProductSummaryDTO> findByCategoryId(Long categoryId,List<Long> billIds) {
		
		return billProductRepository.findProductSummariesByCategoryIdAndBillModelIds(categoryId,billIds);
									
	}

	@Override
	public List<ProductSummaryDTO> findByBillIds(List<Long> billIds)
	{
		return billProductRepository.findProductSummariesByBillModelIds(billIds);
	}
}

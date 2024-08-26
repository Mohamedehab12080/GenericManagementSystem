package com.MO.Software.Bill.billProducts.service;

import java.util.List;

import com.MO.Software.Bill.billProducts.billProductModel;
import com.MO.Software.Bill.billProducts.DTO.billProductDTO;
import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeService.billSearch;

public interface billProductServiceInterface  extends baseServiceInterface<billProductModel,Long>{

	List<billProductModel> findByBillModelId(Long billModelId);
	List<ProductSummaryDTO> findByCategoryId(Long categoryId,List<Long> billIds);
	List<ProductSummaryDTO> findByBillIds(List<Long> billIds);
}

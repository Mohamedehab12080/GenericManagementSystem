package com.MO.Software.product.service;

import java.util.List;

import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.productModel;
import com.MO.Software.product.DTO.productDTO;

public interface productServiceInterface extends baseServiceInterface<productModel,Long>{

	List<productModel> findProductModelByCategoryId(Long id);
	responseOperations<productDTO> findByName(String productName);
	responseOperations<productDTO> saveProduct(productModel mapDTOToProductModel);
	responseOperations<productDTO> updateProductAllData(Long productId,productDTO productDto);
	List<productDTO> findByCategoryModelIdAndBuyPrice(Long categoryModelId,Double buyPrice);
	List<productDTO> findByCategoryModelIdAndSellPrice(Long categoryModelId,Double sellPrice);
	List<productDTO> findByCategoryModelIdAndGainPercentage(Long categoryModelId,Double gainPercentage);
	/**
	 * @author BOBO
	 * @param billSearch
	 * @return Report (ProductSummaryDTO) products groub by category id and product id 
	 */
	List<ProductSummaryDTO> productReportwithBillSearch(billSearch billSearch);
	
	/**
	 * @author BOBO
	 * @param productId
	 * @return buy price & sell price & quantity & id
	 */
}

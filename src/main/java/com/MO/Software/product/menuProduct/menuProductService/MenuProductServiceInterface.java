package com.MO.Software.product.menuProduct.menuProductService;

import java.util.List;

import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.productModel;
import com.MO.Software.product.DTO.productDTO;
import com.MO.Software.product.menuProduct.MenuProductModel;
import com.MO.Software.product.menuProduct.DTO.MenuProductCreateRequest;
import com.MO.Software.product.menuProduct.DTO.MenuProductDTO;
import com.MO.Software.product.menuProduct.menuProductService.menuProductSearch.MenuProductSearch;
import com.MO.Software.product.service.responseOperations;

public interface MenuProductServiceInterface 
extends baseServiceInterface<MenuProductModel,Long> {

	responseOperations<MenuProductDTO> createMenuProduct(MenuProductCreateRequest createRequest);

	List<MenuProductModel> searchByProductName(String productName);
	MenuProductModel searchByExactProductName(String productName);
	List<MenuProductModel> findProductModelByCategoryId(Long id);
	
	/**
	 * @author BOBO
	 * @param billSearch
	 * @return Report (ProductSummaryDTO) products groub by category id and product id 
	 */
	List<ProductSummaryDTO>  menuProductReportwithBillSearch(billSearch billSearch);

	List<MenuProductModel> searchMenuProduct(MenuProductSearch menuProductSearch);


	responseOperations<MenuProductDTO> updateProductAllData(MenuProductUpdateRequest menuProductUpdateRequest);
	
}

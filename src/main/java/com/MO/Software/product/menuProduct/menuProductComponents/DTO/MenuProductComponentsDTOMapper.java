package com.MO.Software.product.menuProduct.menuProductComponents.DTO;

import com.MO.Software.product.productModel;
import com.MO.Software.product.menuProduct.menuProductComponents.MenuProductComponents;

public class MenuProductComponentsDTOMapper {

	public static MenuProductComponentsDTO mapMenuProductComponentsToDTO(MenuProductComponents men)
	{
		MenuProductComponentsDTO dto=new MenuProductComponentsDTO();
		dto.setId(men.getId());
		productModel prodModel=men.getProductModel();
		if(prodModel!=null)
		{
			dto.setComponentBuyPrice(prodModel.getBuyPrice());
			dto.setComponentId(prodModel.getId());
			dto.setComponentName(prodModel.getName());
		}
		
		return dto;
		
	}
}

package com.MO.Software.product.menuProduct.DTO;

import com.MO.Software.category.menuCategory.MenuCategoryModel;
import com.MO.Software.product.menuProduct.MenuProductModel;

public class MenuProductDTOMapper {

	public static MenuProductDTO mapMenuProductModelToDTO(MenuProductModel mp)
	{
		MenuProductDTO dto=new MenuProductDTO();
		dto.setBuyPrice(mp.getBuyPrice());
		dto.setGainPercentage(mp.getGainedPercentage());
		dto.setSellPrice(mp.getSellPrice());
		dto.setId(mp.getId());
		MenuCategoryModel menuCat=mp.getMenuCategoryModel();
		if(menuCat!=null)
		{
			dto.setMenuCategoryId(menuCat.getId());
			dto.setMenuCategoryName(menuCat.getCategoryName());
		}
		dto.setProductName(mp.getProductName());
		dto.setCount(mp.getCount());
		return dto;
	}
	
	public static MenuProductModel mapDTOToMenuProductsModel(MenuProductDTO mp)
	{
		MenuProductModel dto=new MenuProductModel();
		dto.setBuyPrice(mp.getBuyPrice());
		dto.setGainedPercentage(mp.getGainPercentage());
		dto.setSellPrice(mp.getSellPrice());
		dto.setId(mp.getId());
		MenuCategoryModel menuCat=new MenuCategoryModel();
		menuCat.setId(mp.getMenuCategoryId());
		dto.setProductName(mp.getProductName());
		dto.setCount(mp.getCount());
		return dto;
	}
}

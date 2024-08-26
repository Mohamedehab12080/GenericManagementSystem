package com.MO.Software.product.DTO;

import com.MO.Software.category.categoryModel;
import com.MO.Software.product.productModel;

public class productDTOMapper {

	public static productDTO mapProductToDTO(productModel prod)
	{
		productDTO dto=new productDTO();
		dto.setId(prod.getId());
		dto.setName(prod.getName());
		Double gainedPercent=prod.getGainPercentage();
		Double buyPrice=prod.getBuyPrice();
		Double sellPrice=prod.getSellPrice();
		dto.setBuyPrice(buyPrice);
		dto.setSellPrice(sellPrice);
		dto.setGainPercentage(gainedPercent);
		dto.setLowStockThreshold(prod.getLowStockThreshold());
		if(gainedPercent!=null)
		{
			if( buyPrice!=null && sellPrice!=null)
			{
				if(buyPrice > sellPrice)
				{
					if(((sellPrice-buyPrice)/buyPrice)>=(gainedPercent/buyPrice))
					{
						dto.setState("حقق التارجت");
					}else
					{
						dto.setState("لم يحقق التارجت");
					}
					dto.setGainedAmount(sellPrice-buyPrice);

				}
			}
		}
		categoryModel cat=prod.getCategoryModel();
		if(cat!=null)
		{
			dto.setCategoryId(cat.getId());
			dto.setCategoryName(cat.getName());
		}
		return dto;
	}
	
	public static productModel mapDTOToProductModel(productDTO dto)
	{
		productModel prod=new productModel();
		prod.setId(dto.getId());
		prod.setName(dto.getName());
		prod.setBuyPrice(dto.getBuyPrice());
		prod.setSellPrice(dto.getSellPrice());
		prod.setGainPercentage(dto.getGainPercentage());
		if(dto.getCategoryId()!=null)
		{
			categoryModel catMode=new categoryModel();
			catMode.setId(dto.getCategoryId());
			catMode.setName(dto.getCategoryName());
			prod.setCategoryModel(catMode);
		}
		prod.setLowStockThreshold(dto.getLowStockThreshold());
		return prod;
	}
}

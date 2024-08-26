package com.MO.Software.product.productsConstantsAdds.productsConstantsAddsDTO;

import com.MO.Software.product.productsConstantsAdds.ProductsConstantAdds;
import com.MO.Software.product.productsConstantsAdds.constantsCategory.ConstantsCategory;

public class ProductsConstantsAddsDTOMapper {

	public static ProductsConstantsAddsDTO mapProductsConstantsAddsToDTO(ProductsConstantAdds adds)
	{
		ProductsConstantsAddsDTO dto=new ProductsConstantsAddsDTO();
		ConstantsCategory cat=adds.getConstantsCategory();
		if(cat!=null)
		{
			dto.setCategoryId(cat.getId());
			dto.setCategoryName(cat.getCategoryName());
		}
		dto.setId(adds.getId());
		dto.setConstantName(adds.getConstantName());
		dto.setFree(adds.isFree());
		dto.setPrice(adds.getPrice());
		return dto;
	}
	
	public static ProductsConstantAdds mapProductsConstantsAddsToDTO(ProductsConstantsAddsDTO adds)
	{
		ProductsConstantAdds dto=new ProductsConstantAdds();
		ConstantsCategory cat=new ConstantsCategory();
		if(adds.getCategoryId()!=null)
		{
			cat.setId(adds.getCategoryId());
			dto.setConstantsCategory(cat);
		}
		dto.setId(adds.getId());
		dto.setConstantName(adds.getConstantName());
		dto.setFree(adds.isFree());
		dto.setPrice(adds.getPrice());
		return dto;
	}
}

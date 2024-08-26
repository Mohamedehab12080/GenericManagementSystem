package com.MO.Software.product.productContainers.productContainerDTO;

import com.MO.Software.place.storeProducts.containers.Container;
import com.MO.Software.product.productModel;
import com.MO.Software.product.productContainers.ProductContainer;

public class ProductContainerDTOMapper {

	public static ProductContainerDTO mapProductContainerToDTO(ProductContainer prod)
	{
		ProductContainerDTO dto=new ProductContainerDTO();
		dto.setId(prod.getId());
		dto.setProductContainerQuantity(prod.getQuantity());
		productModel product=prod.getProductModel();
		if(product!=null)
		{
			dto.setProductId(product.getId());
			dto.setProductName(product.getName());
		}
		Container cont=prod.getContainer();
		if(cont!=null)
		{
			dto.setContainerId(cont.getId());
			dto.setContainerName(cont.getName());
		}
		return dto;
	}
	
	public static ProductContainer mapDTOToProductContainer(ProductContainerDTO dto)
	{
		ProductContainer prod=new ProductContainer();
		prod.setId(dto.getId());
		Container cont=new Container();
		if(dto.getContainerId()!=null)
		{
			cont.setId(dto.getContainerId());
		}
		if(dto.getContainerName()!=null)
		{
			cont.setName(dto.getContainerName());
		}
		productModel product=new productModel();
		if(dto.getProductId()!=null)
		{
			product.setId(dto.getProductId());
		}
		if(dto.getProductName()!=null)
		{
			product.setName(dto.getProductName());
		}
		prod.setContainer(cont);
		prod.setProductModel(product);
		return prod;

	}
}

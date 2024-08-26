package com.MO.Software.offers.offersProducts.offerProductsDTO;

import com.MO.Software.offers.OfferModel;
import com.MO.Software.offers.offersProducts.OfferProductsModel;

public class OfferProductsDTOMapper {

	public static OfferProductsDTO mapOfferProductsToDTO(OfferProductsModel of)
	{
		OfferProductsDTO dto=new OfferProductsDTO();
		dto.setId(of.getId());
		OfferModel ofmode=of.getOfferModel();
		if(ofmode!=null)
		{
			dto.setOfferId(ofmode.getId());
			dto.setOfferName(ofmode.getName());
		}
		dto.setProductId(of.getProductId());
		dto.setProductName(of.getProductName());
		dto.setQuantity(of.getQuantity());
		return dto;
	}
	
	
	public static OfferProductsModel mapDTOToOfferProducts(OfferProductsDTO of)
	{
		OfferProductsModel dto=new OfferProductsModel();
		dto.setId(of.getId());
		OfferModel ofmode=new OfferModel();
		if(of.getOfferId()!=null)
		{
			ofmode.setId(of.getOfferId());
		}
		dto.setOfferModel(ofmode);
		dto.setProductId(of.getProductId());
		dto.setProductName(of.getProductName());
		dto.setQuantity(of.getQuantity());
		return dto;
	}
}

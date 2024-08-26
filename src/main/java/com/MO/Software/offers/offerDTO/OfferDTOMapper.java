package com.MO.Software.offers.offerDTO;

import com.MO.Software.offers.OfferModel;

public class OfferDTOMapper {

	public static OfferDTO mapOfferToDTO(OfferModel off)
	{
		OfferDTO dto=new OfferDTO();
		dto.setEndDate(off.getEndDate());
		dto.setStartDate(off.getStartDate());
		dto.setExpired(off.isExpired());
		dto.setId(off.getId());
		dto.setName(off.getName());
		dto.setOfferBuyPrice(off.getOfferBuyPrice());
		dto.setOfferSellPrice(off.getOfferSellPrice());
		return dto;
	}
	
	public static OfferModel mapDTOToOffer(OfferDTO off)
	{
		OfferModel dto=new OfferModel();
		dto.setEndDate(off.getEndDate());
		dto.setStartDate(off.getStartDate());
		dto.setExpired(off.isExpired());
		dto.setId(off.getId());
		dto.setName(off.getName());
		dto.setOfferBuyPrice(off.getOfferBuyPrice());
		dto.setOfferSellPrice(off.getOfferSellPrice());
		return dto;
	}
}

package com.MO.Software.offers.offerService;

import java.util.List;

import com.MO.Software.offers.offerDTO.OfferDTO;
import com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTO;

public class UpdateOfferRequest {

	private List<Long> offerProductsToDelete;
	private List<OfferProductsDTO> offerProductsDTOListToAdd;
	private OfferDTO offerDTO;
	
	public OfferDTO getOfferDTO() {
		return offerDTO;
	}
	public void setOfferDTO(OfferDTO offerDTO) {
		this.offerDTO = offerDTO;
	}
	public List<Long> getOfferProductsToDelete() {
		return offerProductsToDelete;
	}
	public void setOfferProductsToDelete(List<Long> offerProductsToDelete) {
		this.offerProductsToDelete = offerProductsToDelete;
	}
	public List<OfferProductsDTO> getOfferProductsDTOListToAdd() {
		return offerProductsDTOListToAdd;
	}
	public void setOfferProductsDTOListToAdd(List<OfferProductsDTO> offerProductsDTOListToAdd) {
		this.offerProductsDTOListToAdd = offerProductsDTOListToAdd;
	}
	
}

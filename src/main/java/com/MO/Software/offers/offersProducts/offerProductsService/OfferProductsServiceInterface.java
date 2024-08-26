package com.MO.Software.offers.offersProducts.offerProductsService;

import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.offers.offersProducts.OfferProductsModel;
import com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTO;

public interface OfferProductsServiceInterface 
extends baseServiceInterface<OfferProductsModel, Long>{

	List<OfferProductsModel> findByOfferModelId(Long offerModelId);
	OfferProductsDTO findByOfferIdAndProductId(Long offerId,Long ProductId);
}

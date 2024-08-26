package com.MO.Software.offers.offersProducts.offerProductsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.offers.offersProducts.OfferProductsModel;
import com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTO;

@Service
public class OfferProductsServiceImpl 
extends baseServiceImpl<OfferProductsModel,Long>
 implements OfferProductsServiceInterface{

	@Autowired
	private OfferProductsRepository OfferProductsRepository;
	
	@Override
	protected baseRepository<OfferProductsModel, Long> getRepository() {
		return OfferProductsRepository;
	}

	@Override
	public List<OfferProductsModel> findByOfferModelId(Long offerModelId)
	{
		return OfferProductsRepository.findByOfferModelId(offerModelId);
	}

	@Override
	public OfferProductsDTO findByOfferIdAndProductId(Long offerId, Long ProductId) {
		return OfferProductsRepository.findByOfferIdAndProductId(offerId,ProductId);
	}
	
}

package com.MO.Software.Bill.billOffers.billOffersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billOffers.BillOfferModel;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class BillOffersServiceImpl 
extends baseServiceImpl<BillOfferModel,Long> 
implements BillOffersServiceInterface{

	@Autowired
	private BillOffersRepository BillOffersRepository;
	
	@Override
	protected baseRepository<BillOfferModel, Long> getRepository() {
		return BillOffersRepository;
	}

	@Override
	public List<OfferSummaryDTO> findOffersSummaryByBillModelIds(List<Long> ids) {
		return BillOffersRepository.findOfferSummariesByBillModelIds(ids);
	}

	@Override
	public List<BillOfferModel> findByBillModelId(Long billModelId) {
		return BillOffersRepository.findByBillModelId(billModelId);
	}

	@Override
	public List<OfferSummaryDTO> findOffersSummaryByBillModelIdsAndOfferIds(List<Long> billModelIds,
			List<Long> offerIds) {
		
		return BillOffersRepository.findOffersSummaryByBillModelIdsAndOfferIds(billModelIds,offerIds);
	}

}

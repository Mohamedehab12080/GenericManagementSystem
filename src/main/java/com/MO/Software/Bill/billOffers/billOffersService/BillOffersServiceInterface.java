package com.MO.Software.Bill.billOffers.billOffersService;

import java.util.List;

import com.MO.Software.Bill.billOffers.BillOfferModel;
import com.MO.Software.base.baseServiceInterface;

public interface BillOffersServiceInterface 
extends baseServiceInterface<BillOfferModel,Long>{

	List<OfferSummaryDTO> findOffersSummaryByBillModelIds(List<Long> ids);
	List<OfferSummaryDTO> findOffersSummaryByBillModelIdsAndOfferIds(List<Long> billModelIds,List<Long> offerIds);
	List<BillOfferModel> findByBillModelId(Long billModelId);
}

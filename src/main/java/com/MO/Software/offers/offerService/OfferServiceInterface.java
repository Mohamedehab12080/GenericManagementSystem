package com.MO.Software.offers.offerService;

import java.util.List;

import com.MO.Software.Bill.billOffers.billOffersService.OfferSummaryDTO;
import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.offers.OfferModel;
import com.MO.Software.offers.offerDTO.OfferDTO;
import com.MO.Software.offers.offerService.offerSearch.OfferSearch;
import com.MO.Software.product.service.responseOperations;

public interface OfferServiceInterface 
extends baseServiceInterface<OfferModel,Long>{

	List<OfferModel> searchOffers(OfferSearch offerSearch);
	void handleExpiredOffers();
    boolean checkIfExpired(OfferModel offer);
    List<OfferModel> getExpiredOffers();
    List<OfferModel> getLiveOffers();
    
    /**
     * @author BOBO
     * @param offerDTO contains List of products inside the offer and the offer sell price and the offer buy price and the details
     * @return response contains offerDTO Object and a message with success or a message with failure
     * 
     */
	responseOperations<OfferDTO> createOffer(OfferDTO offerDTO);
	
	responseOperations<OfferDTO> updateOffer(UpdateOfferRequest updateRequest);
	
	List<OfferSummaryDTO> findSummaryOfSoldOffersDependOnBillsSearch(billSearch billSearch);
	
	List<OfferSummaryDTO> findOffersSummaryByBillSearchAndOfferIds(billSearch billSearch, OfferSearch offerSearch);
}

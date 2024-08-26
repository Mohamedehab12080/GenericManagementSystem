package com.MO.Software.Bill.billOffers.billOffersService;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.Bill.billOffers.BillOfferModel;
import com.MO.Software.base.baseRepository;

@Repository
public interface BillOffersRepository 
extends baseRepository<BillOfferModel,Long>{
	
	@Query("Select bp from BillOfferModel bp where bp.billModel.id=:billModelId")
	List<BillOfferModel> findByBillModelId(Long billModelId);

	@Query("SELECT new com.MO.Software.Bill.billOffers.billOffersService.OfferSummaryDTO(" +
            "bp.offerId, " +
            "bp.offerName, " +
            "bp.offerBuyPrice, " +
            "bp.offerSellPrice, " +
            "SUM(bp.Quantity), " +
            "SUM(bp.rowTotal)) " +
           "FROM BillOfferModel bp " +
           "WHERE bp.billModel.id IN :billIds " +
           "GROUP BY "
           + "bp.offerId,"
           + "bp.offerName,"
           + "bp.offerSellPrice,"
           + "bp.offerBuyPrice")
    List<OfferSummaryDTO> findOfferSummariesByBillModelIds(
    		 @Param("billIds") List<Long> billIds);

	@Query("SELECT new com.MO.Software.Bill.billOffers.billOffersService.OfferSummaryDTO(" +
            "bp.offerId, " +
            "bp.offerName, " +
            "bp.offerBuyPrice, " +
            "bp.offerSellPrice, " +
            "SUM(bp.Quantity), " +
            "SUM(bp.rowTotal)) " +
           "FROM BillOfferModel bp " +
           "WHERE bp.billModel.id IN :billModelIds And bp.offerId IN :offerIds" +
           "GROUP BY "
           + "bp.offerId,"
           + "bp.offerName,"
           + "bp.offerSellPrice,"
           + "bp.offerBuyPrice")
	List<OfferSummaryDTO> findOffersSummaryByBillModelIdsAndOfferIds(
			List<Long> billModelIds, 
			List<Long> offerIds);

	
}

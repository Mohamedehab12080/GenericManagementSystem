package com.MO.Software.offers.offersProducts.offerProductsService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.offers.offersProducts.OfferProductsModel;
import com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTO;


@Repository
public interface OfferProductsRepository 
extends baseRepository<OfferProductsModel,Long>
,JpaSpecificationExecutor<OfferProductsModel>{

	@Query("SELECT of From OfferProductsModel of where of.offerModel.id=:offerModelId")
	List<OfferProductsModel> findByOfferModelId(@Param("offerModelId") Long offerModelId);

	@Query("SELECT new com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTO("
			+ "of.id,"
			+ "of.productName,"
			+ "of.productId,"
			+ "of.quantity,"
			+ "of.offerModel.id,"
			+ "of.offerModel.name)"
			+ " From OfferProductsModel of where of.offerModel.id=:offerId And of.productId=:productId")
	OfferProductsDTO findByOfferIdAndProductId(@Param("offerId") Long offerId,
											   @Param("productId") Long productId);

	
}

package com.MO.Software.offers.offerService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.offers.OfferModel;

@Repository
public interface OfferRepository 
extends baseRepository<OfferModel,Long>,
JpaSpecificationExecutor<OfferModel>{

	@Query("SELECT of From OfferModel of where of.expired=true")
	List<OfferModel> findExpired();

	@Query("SELECT of From OfferModel of where of.expired=false")
	List<OfferModel> findNotExpired();

	
}

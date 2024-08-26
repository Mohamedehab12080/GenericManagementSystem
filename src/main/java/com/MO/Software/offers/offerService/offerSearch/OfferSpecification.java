package com.MO.Software.offers.offerService.offerSearch;

import org.springframework.data.jpa.domain.Specification;
import com.MO.Software.offers.OfferModel;

import java.time.LocalDate;

public class OfferSpecification {

	   public static Specification<OfferModel> hasName(String name) {
	        return (root, query, criteriaBuilder) -> 
	                name == null ? null : criteriaBuilder.like(root.get("name"), name);
	    }
	 public static Specification<OfferModel> hasStartDateYear(int year) {
	        return (root, query, criteriaBuilder) -> 
	                criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, root.get("startDate")), year);
	    }

	    public static Specification<OfferModel> hasStartDateYearAndMonth(int year, int month) {
	        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
	                criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, root.get("startDate")), year),
	                criteriaBuilder.equal(criteriaBuilder.function("MONTH", Integer.class, root.get("startDate")), month)
	        );
	    }

	    public static Specification<OfferModel> hasStartDate(LocalDate startDate) {
	        return (root, query, criteriaBuilder) -> 
	                criteriaBuilder.equal(root.get("startDate"), startDate);
	    }

	    public static Specification<OfferModel> hasEndDateYear(int year) {
	        return (root, query, criteriaBuilder) -> 
	                criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, root.get("endDate")), year);
	    }

	    public static Specification<OfferModel> hasEndDateYearAndMonth(int year, int month) {
	        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
	                criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, root.get("endDate")), year),
	                criteriaBuilder.equal(criteriaBuilder.function("MONTH", Integer.class, root.get("endDate")), month)
	        );
	    }

	    public static Specification<OfferModel> hasEndDate(LocalDate endDate) {
	        return (root, query, criteriaBuilder) -> 
	                criteriaBuilder.equal(root.get("endDate"), endDate);
	    }
	    
	    public static Specification<OfferModel> hasExpired(Boolean expired) {
	    	  return (root, query, criteriaBuilder) -> 
              criteriaBuilder.equal(root.get("expired"), expired);
		}
	    
    public static Specification<OfferModel> offerBuyPriceBetween(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("offerBuyPrice"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("offerBuyPrice"), minPrice);
            } else if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("offerBuyPrice"), maxPrice);
            } else {
                return null;
            }
        };
    }

    public static Specification<OfferModel> offerSellPriceBetween(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("offerSellPrice"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("offerSellPrice"), minPrice);
            } else if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("offerSellPrice"), maxPrice);
            } else {
                return null;
            }
        };
    }
	
}

package com.MO.Software.place.storeProducts.storeProductService;

import org.springframework.data.jpa.domain.Specification;

import com.MO.Software.place.PlaceModel;
import com.MO.Software.place.storeProducts.ProductBatchModel;
import com.MO.Software.product.productModel;

import java.time.LocalDate;

public class ProductBatchSpecifications {

    public static Specification<ProductBatchModel> hasNotExpired() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("expirDate"), LocalDate.now());
    }
    
    public static Specification<ProductBatchModel> hasExpired() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("expirDate"), LocalDate.now());
    }

    public static Specification<ProductBatchModel> hasReceivedDateBetween(LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("receivedDate"), startDate, endDate);
    }
    
    public static Specification<ProductBatchModel> hasReceivedDateStart(LocalDate startDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("receivedDate"), startDate);
    }
    
    public static Specification<ProductBatchModel> hasReceivedDateEnd(LocalDate endDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("receivedDate"), endDate);
    }
    public static Specification<ProductBatchModel> hasExpirBetween(LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("expirDate"), startDate, endDate);
    }
    
    public static Specification<ProductBatchModel> hasExpirStart(LocalDate startDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("expirDate"), startDate);
    }
    
    public static Specification<ProductBatchModel> hasExpirEnd(LocalDate endDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("expirDate"), endDate);
    }
    public static Specification<ProductBatchModel> hasProductId(Long productId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("productModel").get("id"), productId);
    }

    public static Specification<ProductBatchModel> hasPlaceId(Long placeId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("placeModel").get("id"), placeId);
    }
}

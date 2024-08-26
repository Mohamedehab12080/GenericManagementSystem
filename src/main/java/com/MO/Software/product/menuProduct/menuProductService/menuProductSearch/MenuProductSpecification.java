package com.MO.Software.product.menuProduct.menuProductService.menuProductSearch;


import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.MO.Software.product.menuProduct.MenuProductModel;

public class MenuProductSpecification {
	
 public static Specification<MenuProductModel> hasName(String name) {
	  return (root, query, criteriaBuilder) ->
      name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
}

	    
 public static Specification<MenuProductModel> menuProductBuyPriceBetween(Double minPrice, Double maxPrice) {
     return (root, query, criteriaBuilder) -> {
         if (minPrice != null && maxPrice != null) {
             return criteriaBuilder.between(root.get("buyPrice"), minPrice, maxPrice);
         } else if (minPrice != null) {
             return criteriaBuilder.greaterThanOrEqualTo(root.get("buyPrice"), minPrice);
         } else if (maxPrice != null) {
             return criteriaBuilder.lessThanOrEqualTo(root.get("buyPrice"), maxPrice);
         } else {
             return null;
         }
     };
 }

 public static Specification<MenuProductModel> menuProductSellPriceBetween(Double minPrice, Double maxPrice) {
     return (root, query, criteriaBuilder) -> {
         if (minPrice != null && maxPrice != null) {
             return criteriaBuilder.between(root.get("sellPrice"), minPrice, maxPrice);
         } else if (minPrice != null) {
             return criteriaBuilder.greaterThanOrEqualTo(root.get("sellPrice"), minPrice);
         } else if (maxPrice != null) {
             return criteriaBuilder.lessThanOrEqualTo(root.get("sellPrice"), maxPrice);
         } else {
             return null;
         }
     };
 }
 
	 public static Specification<MenuProductModel> hasIdInList(List<Long> ids) {
	     return (root, query, criteriaBuilder) -> {
	         if (ids == null || ids.isEmpty()) {
	             return null;
	         }
	         return root.get("id").in(ids);
	     };
	 }
	 
	 public static Specification<MenuProductModel> hasCategoryId(Long categoryId) {
	        return (root, query, criteriaBuilder) -> {
	            if (categoryId == null) {
	                return null;
	            }
	            return criteriaBuilder.equal(root.get("menuCategoryModel").get("id"), categoryId);
	        };
	    }
}

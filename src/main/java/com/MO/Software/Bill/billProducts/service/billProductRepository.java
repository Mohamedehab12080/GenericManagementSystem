package com.MO.Software.Bill.billProducts.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.Bill.billProducts.billProductModel;
import com.MO.Software.base.baseRepository;

@Repository
public interface billProductRepository extends baseRepository<billProductModel,Long>{

	@Query("Select bp from billProductModel bp where bp.billModel.id=:billModelId")
	List<billProductModel> findByBillModelId(Long billModelId);

	@Query("SELECT new com.MO.Software.Bill.billProducts.service.ProductSummaryDTO(" +
            "bp.categoryId, " +
            "bp.categoryName, " +
            "bp.productId, " +
            "bp.productName, " +
            "bp.productSellPrice, " +
            "bp.productBuyPrice, " +
            "SUM(bp.quantity), " +
            "SUM(bp.rowTotal)) " +
           "FROM billProductModel bp " +
           "WHERE bp.categoryId = :categoryId AND bp.billModel.id IN :billIds " +
           "GROUP BY "
           + "bp.productId,"
           + "bp.productName,"
           + "bp.productSellPrice,"
           + "bp.productBuyPrice")
    List<ProductSummaryDTO> findProductSummariesByCategoryIdAndBillModelIds(@Param("categoryId") Long categoryId, @Param("billIds") List<Long> billIds);
	
	@Query("SELECT new "
			+ "com.MO.Software.Bill.billProducts.service.ProductSummaryDTO(" +
            "bp.categoryId, " +
            "bp.categoryName, " +
            "bp.productId, " +
            "bp.productName, " +
            "bp.productSellPrice, " +
            "bp.productBuyPrice, " +
            "SUM(bp.quantity), " +
            "SUM(bp.rowTotal)) " +
           "FROM billProductModel bp " +
           "WHERE bp.billModel.id IN :billIds " +
           "GROUP BY "
           + " bp.productId,"
           + " bp.productName,"
           + " bp.productSellPrice,"
           + " bp.productBuyPrice")
    List<ProductSummaryDTO> findProductSummariesByBillModelIds(@Param("billIds") List<Long> billIds);

}

package com.MO.Software.place.storeProducts.storeProductService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.place.storeProducts.ProductBatchModel;
import com.MO.Software.place.storeProducts.storeProductsDTO.ProductBatchDTO;

@Repository
public interface StoreProductRepository 
extends baseRepository<ProductBatchModel,Long> , JpaSpecificationExecutor<ProductBatchModel>{


	@Query("Select new com.MO.Software.dto.ProductBatchDTO(pb.id, pb.quantity,pm.id,pm.name,pr.name,pr.id,pb.expirDate,pb.receivedDate) "
			+ " From ProductBatchModel sp JOIN sp.placeModel pm JOIN sp.productModel pr  where sp.id=:ProductBatchId")
	ProductBatchDTO findProductBatchDTOById(@Param("ProductBatchId") Long ProductBatchId);

	@Query("Select new com.MO.Software.place.storeProducts.storeProductService.ProductBuyPriceAndSellAndQuantityAndIdRetrieve("
			+ "SUM(sp.quantity),"
			+ "sp.productModel.buyPrice,"
			+ "sp.productModel.sellPrice,"
			+ "sp.productModel.name)"
			+ " from From ProductBatchModel sp"
			+ " where sp.productModel.id=:productId And sp.placeModel.id IN :placeIds"
			+ " Group by sp.productModel.id")
	ProductBuyPriceAndSellAndQuantityAndIdRetrieve findSumQuantityAndProductNameAndProductModelBuyPriceAndProductModelSellPriceByProductModelId(Long productId,List<Long>placeIds);
	 
	@Query("SELECT new com.MO.Software.dto.ProductBatchDTO(pb.id, pb.quantity, pb.receivedDate, pb.expirDate, pm.name) " +
	           "FROM ProductBatchModel pb " +
	           "JOIN pb.placeModel pm " +
	           "JOIN pb.productModel pr " +
	           "WHERE (:placeId IS NULL OR pm.id = :placeId) " +
	           "AND (:productId IS NULL OR pr.id = :productId) " +
	           "AND (:receivedDateStart IS NULL OR pb.receivedDate >= :receivedDateStart) " +
	           "AND (:receivedDateEnd IS NULL OR pb.receivedDate <= :receivedDateEnd) " +
	           "AND (:expirDateStart IS NULL OR pb.expirDate >= :expirDateStart) " +
	           "AND (:expirDateEnd IS NULL OR pb.expirDate <= :expirDateEnd) " +
	           "AND ((:isExpired = true AND pb.expirDate < CURRENT_DATE) " +
	           "     OR (:isExpired = false AND pb.expirDate >= CURRENT_DATE))")
	    List<ProductBatchDTO> findProductBatchesWithCriteria(
	        @Param("placeId") Long placeId,
	        @Param("productId") Long productId,
	        @Param("receivedDateStart") LocalDate receivedDateStart,
	        @Param("receivedDateEnd") LocalDate receivedDateEnd,
	        @Param("expirDateStart") LocalDate expirDateStart,
	        @Param("expirDateEnd") LocalDate expirDateEnd,
	        @Param("isExpired") boolean isExpired);
	
	@Query("SELECT SUM(p.quantity) from ProductBatchModel p "
			+ "where p.productModel.id=:productId group by p.productModel.id")
	Double findSumQuantityByProductId(Long productId);

	@Query("Select new com.MO.Software.place.storeProducts.storeProductService.InventoryIdAndName(sp.placeModel.id,sp.placeModel.name) from ProductBatchModel sp where sp.productModel.id=:productId")
	List<InventoryIdAndName> findPlaceModelIdsAndPlaceModelNameByProductModelId(Long productId);


}

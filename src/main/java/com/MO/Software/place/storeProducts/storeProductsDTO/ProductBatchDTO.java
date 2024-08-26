package com.MO.Software.place.storeProducts.storeProductsDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO;
import com.MO.Software.product.productContainers.productMoreThanContainer.DTO.StoreProductMoreThanContainerDTO;

public class ProductBatchDTO {

	private Long id;
	private List<ProductContainerDTO> productContainerDTOList;
	private Double singleQuantity;
	private Double containerQuantity;
	private Long placeId;
	private String placeName;
	private String productName;
	private Long productId;
	private List<StoreProductMoreThanContainerDTO> StoreProductMoreThanContainerDTOList=new ArrayList<StoreProductMoreThanContainerDTO>();
	private LocalDate receivedDate;
	private LocalDate expirDate;

	public ProductBatchDTO() {
		super();
	}
	
	public ProductBatchDTO(Long id, Double singleQuantity, Long placeId, String placeName,
			String productName, Long productId,LocalDate expirDate,LocalDate receiveDate) {
		super();
		this.id = id;
		this.singleQuantity = singleQuantity;
		this.placeId = placeId;
		this.placeName = placeName;
		this.productName = productName;
		this.productId = productId;
		this.expirDate=expirDate;
		this.receivedDate=receiveDate;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public LocalDate getExpirDate() {
		return expirDate;
	}

	public void setExpirDate(LocalDate expirDate) {
		this.expirDate = expirDate;
	}


	
	
	public List<ProductContainerDTO> getProductContainerDTOList() {
		return productContainerDTOList;
	}

	public void setProductContainerDTOList(List<ProductContainerDTO> productContainerDTOList) {
		this.productContainerDTOList = productContainerDTOList;
	}

	public List<StoreProductMoreThanContainerDTO> getStoreProductMoreThanContainerDTOList() {
		return StoreProductMoreThanContainerDTOList;
	}

	public void setStoreProductMoreThanContainerDTOList(
			List<StoreProductMoreThanContainerDTO> storeProductMoreThanContainerDTOList) {
		StoreProductMoreThanContainerDTOList = storeProductMoreThanContainerDTOList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSingleQuantity() {
		return singleQuantity;
	}
	public void setSingleQuantity(Double singleQuantity) {
		this.singleQuantity = singleQuantity;
	}
	public Double getContainerQuantity() {
		return containerQuantity;
	}
	public void setContainerQuantity(Double containerQuantity) {
		this.containerQuantity = containerQuantity;
	}
	public Long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}

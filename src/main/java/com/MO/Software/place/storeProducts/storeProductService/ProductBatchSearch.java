package com.MO.Software.place.storeProducts.storeProductService;

import java.time.LocalDate;

public class ProductBatchSearch {

	private Long id;
	private LocalDate receivedDateStart;
	private LocalDate receivedDateEnd;
	private LocalDate expirDateStart;
	private LocalDate expirDateEnd;
	private Long placeId;
	private Long productId;
	private boolean expired;
	
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getReceivedDateStart() {
		return receivedDateStart;
	}
	public void setReceivedDateStart(LocalDate receivedDateStart) {
		this.receivedDateStart = receivedDateStart;
	}
	public LocalDate getReceivedDateEnd() {
		return receivedDateEnd;
	}
	public void setReceivedDateEnd(LocalDate receivedDateEnd) {
		this.receivedDateEnd = receivedDateEnd;
	}
	public LocalDate getExpirDateStart() {
		return expirDateStart;
	}
	public void setExpirDateStart(LocalDate expirDateStart) {
		this.expirDateStart = expirDateStart;
	}
	public LocalDate getExpirDateEnd() {
		return expirDateEnd;
	}
	public void setExpirDateEnd(LocalDate expirDateEnd) {
		this.expirDateEnd = expirDateEnd;
	}
	public Long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}

package com.MO.Software.offers.offersProducts.offerProductsDTO;

public class OfferProductsDTO {

	private Long id;
	private String productName;
	private Long productId;
	private Double quantity;
	private Long offerId;
	private String offerName;
	
	public OfferProductsDTO() {
		super();
	}
	public OfferProductsDTO(Long id, String productName, Long productId, Double quantity, Long offerId,
			String offerName) {
		super();
		this.id = id;
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
		this.offerId = offerId;
		this.offerName = offerName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Long getOfferId() {
		return offerId;
	}
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	
}

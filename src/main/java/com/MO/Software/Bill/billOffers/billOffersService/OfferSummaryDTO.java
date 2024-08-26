package com.MO.Software.Bill.billOffers.billOffersService;


public class OfferSummaryDTO {

	private Long id; 
	private String name;
	private Double offerBuyPrice;
	private Double offerSellPrice;
	private Integer totalQuantity;
	private Double totalPrice;
	public OfferSummaryDTO() {
	
	}
	
	public OfferSummaryDTO(
			Long id,
			String name,
			Double offerBuyPrice,
			Double offerSellPrice,
			Integer totalQuantity,
			Double totalPrice) {
		super();
		this.id = id;
		this.name = name;
		this.offerBuyPrice = offerBuyPrice;
		this.offerSellPrice = offerSellPrice;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getOfferBuyPrice() {
		return offerBuyPrice;
	}
	public void setOfferBuyPrice(Double offerBuyPrice) {
		this.offerBuyPrice = offerBuyPrice;
	}
	public Double getOfferSellPrice() {
		return offerSellPrice;
	}
	public void setOfferSellPrice(Double offerSellPrice) {
		this.offerSellPrice = offerSellPrice;
	}
	
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	 
}

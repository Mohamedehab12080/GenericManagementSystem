package com.MO.Software.Bill.billOffers.billOffersDTO;

public class BillOfferDTO {
	
	private Long id;
	private Double offerPrice;
	private Double Quantity;
	private Long offerId;
	private Double offerBuyPrice;
	private Double offerSellPrice;
	private String offerName;
	private Double rowTotal;
	private Long billModelId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Double getQuantity() {
		return Quantity;
	}
	public void setQuantity(Double quantity) {
		Quantity = quantity;
	}
	public Long getOfferId() {
		return offerId;
	}
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
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
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public Double getRowTotal() {
		return rowTotal;
	}
	public void setRowTotal(Double rowTotal) {
		this.rowTotal = rowTotal;
	}
	public Long getBillModelId() {
		return billModelId;
	}
	public void setBillModelId(Long billModelId) {
		this.billModelId = billModelId;
	}
	
}

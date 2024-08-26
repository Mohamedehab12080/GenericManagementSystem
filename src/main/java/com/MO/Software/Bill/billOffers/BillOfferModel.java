package com.MO.Software.Bill.billOffers;

import com.MO.Software.Bill.billModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BillOfferModel {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double Quantity;
	private Long offerId;
	private Double offerBuyPrice;
	private Double offerSellPrice;
	private String offerName;
	private Double rowTotal;
    @ManyToOne
    @JoinColumn(name = "billModelId")
    private billModel billModel;
    
    
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getQuantity() {
		return Quantity;
	}
	public void setQuantity(Double quantity) {
		Quantity = quantity;
	}
	public Double getRowTotal() {
		return rowTotal;
	}
	public void setRowTotal(Double rowTotal) {
		this.rowTotal = rowTotal;
	}
	public billModel getBillModel() {
		return billModel;
	}
	public void setBillModel(billModel billModel) {
		this.billModel = billModel;
	}

	
}

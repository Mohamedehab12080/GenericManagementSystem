package com.MO.Software.offers;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OfferModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double offerBuyPrice;
	private Double offerSellPrice;
	private boolean expired;
	
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}

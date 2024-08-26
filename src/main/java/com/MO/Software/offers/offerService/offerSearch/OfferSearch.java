package com.MO.Software.offers.offerService.offerSearch;

import java.time.LocalDate;

public class OfferSearch {
	
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double minBuyPrice;
	private Double maxBuyPrice;
	private Double minSellPrice;
	private Double maxSellPrice;
	private Boolean expired;
	private Integer startYear;
	private Integer startMonth;


	
	public OfferSearch(String name, LocalDate startDate, LocalDate endDate, Double minBuyPrice, Double maxBuyPrice,
			Double minSellPrice, Double maxSellPrice, Boolean expired, Integer startYear, Integer startMonth) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minBuyPrice = minBuyPrice;
		this.maxBuyPrice = maxBuyPrice;
		this.minSellPrice = minSellPrice;
		this.maxSellPrice = maxSellPrice;
		this.expired = expired;
		this.startYear = startYear;
		this.startMonth = startMonth;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(Integer startMonth) {
		this.startMonth = startMonth;
	}

	public OfferSearch() {
		super();
		// TODO Auto-generated constructor stub
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
	public Double getMinBuyPrice() {
		return minBuyPrice;
	}
	public void setMinBuyPrice(Double minBuyPrice) {
		this.minBuyPrice = minBuyPrice;
	}
	public Double getMaxBuyPrice() {
		return maxBuyPrice;
	}
	public void setMaxBuyPrice(Double maxBuyPrice) {
		this.maxBuyPrice = maxBuyPrice;
	}
	public Double getMinSellPrice() {
		return minSellPrice;
	}
	public void setMinSellPrice(Double minSellPrice) {
		this.minSellPrice = minSellPrice;
	}
	public Double getMaxSellPrice() {
		return maxSellPrice;
	}
	public void setMaxSellPrice(Double maxSellPrice) {
		this.maxSellPrice = maxSellPrice;
	}
	public Boolean getExpired() {
		return expired;
	}
	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
	
}

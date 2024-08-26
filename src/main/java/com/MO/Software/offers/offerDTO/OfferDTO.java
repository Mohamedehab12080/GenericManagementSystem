package com.MO.Software.offers.offerDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTO;

public class OfferDTO {

	private Long id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double offerBuyPrice;
	private Double offerSellPrice;
	private boolean expired;
	private List<OfferProductsDTO> offerProductsDTOList=new ArrayList<OfferProductsDTO>();
	
	
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
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public List<OfferProductsDTO> getOfferProductsDTOList() {
		return offerProductsDTOList;
	}
	public void setOfferProductsDTOList(List<OfferProductsDTO> offerProductsDTOList) {
		this.offerProductsDTOList = offerProductsDTOList;
	}
	
}

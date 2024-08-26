package com.MO.Software.product.menuProduct.menuProductService.menuProductSearch;

public class MenuProductSearch {

	private String productName;
	private Double minSellPrice;
	private Double minBuyPrice;
	private Double gainePercentage;
	private Double maxBuyPrice;
	private Double maxSellPrice;
	private Long MenuCategoryId;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Double getMinSellPrice() {
		return minSellPrice;
	}
	public void setMinSellPrice(Double minSellPrice) {
		this.minSellPrice = minSellPrice;
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
	public Double getMaxSellPrice() {
		return maxSellPrice;
	}
	public void setMaxSellPrice(Double maxSellPrice) {
		this.maxSellPrice = maxSellPrice;
	}
	public Double getGainePercentage() {
		return gainePercentage;
	}
	public void setGainePercentage(Double gainePercentage) {
		this.gainePercentage = gainePercentage;
	}
	public Long getMenuCategoryId() {
		return MenuCategoryId;
	}
	public void setMenuCategoryId(Long menuCategoryId) {
		MenuCategoryId = menuCategoryId;
	}
	
	
}

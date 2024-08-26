package com.MO.Software.product.DTO;

public class productDTO {

	private Long id;
	private String name;
	private Double buyPrice;
    private Double sellPrice;
    private Double gainPercentage;
    private String categoryName;
    private Long categoryId;
    private String state;
    private Double gainedAmount;
    private Double lowStockThreshold;
    
	public Double getLowStockThreshold() {
		return lowStockThreshold;
	}
	public void setLowStockThreshold(Double lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getGainedAmount() {
		return gainedAmount;
	}
	public void setGainedAmount(Double gainedAmount) {
		this.gainedAmount = gainedAmount;
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
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Double getGainPercentage() {
		return gainPercentage;
	}
	public void setGainPercentage(Double gainPercentage) {
		this.gainPercentage = gainPercentage;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
    
}

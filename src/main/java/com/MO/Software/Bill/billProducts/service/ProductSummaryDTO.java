package com.MO.Software.Bill.billProducts.service;


public class ProductSummaryDTO {
    
	private Long categoryId;
    private String categoryName;
    private Long productId;
    private String productName;
    private Double productSellPrice;
    private Double productBuyPrice;
    private Double totalQuantity;
    private Double totalRowTotal;

    // Constructors
    public ProductSummaryDTO(Long categoryId,String categoryName, Long productId, String productName, Double productSellPrice, Double productBuyPrice, Double totalQuantity, Double totalRowTotal) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.productName = productName;
        this.productSellPrice = productSellPrice;
        this.productBuyPrice = productBuyPrice;
        this.totalQuantity = totalQuantity;
        this.totalRowTotal = totalRowTotal;
        this.categoryName=categoryName;
    }

    
    public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	// Getters and setters
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductSellPrice() {
        return productSellPrice;
    }

    public void setProductSellPrice(Double productSellPrice) {
        this.productSellPrice = productSellPrice;
    }

    public Double getProductBuyPrice() {
        return productBuyPrice;
    }

    public void setProductBuyPrice(Double productBuyPrice) {
        this.productBuyPrice = productBuyPrice;
    }

    public Double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getTotalRowTotal() {
        return totalRowTotal;
    }

    public void setTotalRowTotal(Double totalRowTotal) {
        this.totalRowTotal = totalRowTotal;
    }
}

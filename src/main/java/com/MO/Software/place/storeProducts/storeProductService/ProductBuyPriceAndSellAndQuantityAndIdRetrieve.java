package com.MO.Software.place.storeProducts.storeProductService;

public class ProductBuyPriceAndSellAndQuantityAndIdRetrieve {

	private Double quantity;
	private Double buyPrice;
	private Double sellPrice;
	private String productName;
	
	public ProductBuyPriceAndSellAndQuantityAndIdRetrieve() {}
	public ProductBuyPriceAndSellAndQuantityAndIdRetrieve(Long id, Double quantity, Double buyPrice, Double sellPrice,
			String productName) {
		super();
		this.quantity = quantity;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.productName = productName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
	
}

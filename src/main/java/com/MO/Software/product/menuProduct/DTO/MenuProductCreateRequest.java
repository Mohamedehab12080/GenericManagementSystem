package com.MO.Software.product.menuProduct.DTO;

import java.util.List;

import com.MO.Software.product.menuProduct.menuProductComponents.DTO.MenuProductComponentsCreateRequest;

public class MenuProductCreateRequest {

	private String productName;
	private Double sellPrice;
	private Double buyPrice;
	private Double gainPercentage;
	private Long menuCategoryId;
	private String menuCategoryName;
	private List<MenuProductComponentsCreateRequest> menuProductComponentsCreateRequestList;
	
	public String getMenuCategoryName() {
		return menuCategoryName;
	}
	public void setMenuCategoryName(String menuCategoryName) {
		this.menuCategoryName = menuCategoryName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Long getMenuCategoryId() {
		return menuCategoryId;
	}
	public void setMenuCategoryId(Long menuCategoryId) {
		this.menuCategoryId = menuCategoryId;
	}
	public Double getGainPercentage() {
		return gainPercentage;
	}
	public void setGainPercentage(Double gainPercentage) {
		this.gainPercentage = gainPercentage;
	}
	public List<MenuProductComponentsCreateRequest> getMenuProductComponentsCreateRequestList() {
		return menuProductComponentsCreateRequestList;
	}
	public void setMenuProductComponentsCreateRequestList(
			List<MenuProductComponentsCreateRequest> menuProductComponentsCreateRequestList) {
		this.menuProductComponentsCreateRequestList = menuProductComponentsCreateRequestList;
	}
	
}

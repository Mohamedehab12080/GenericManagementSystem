package com.MO.Software.product.menuProduct.menuProductService;

import java.util.List;

import com.MO.Software.product.menuProduct.menuProductComponents.DTO.MenuProductComponentsCreateRequest;

public class MenuProductUpdateRequest {

	private Long menuProductId;
	private String productName;
	private Double sellPrice;
	private Double buyPrice;
	private Double gainPercentage;
	private Long menuCategoryId;
	private String menuCategoryName;
	private List<MenuProductComponentsCreateRequest> menuProductComponentsCreateRequestList;
	private List<Long> componentsToDelete;
	
	
	public Long getMenuProductId() {
		return menuProductId;
	}
	public void setMenuProductId(Long menuProductId) {
		this.menuProductId = menuProductId;
	}
	public List<Long> getComponentsToDelete() {
		return componentsToDelete;
	}
	public void setComponentsToDelete(List<Long> componentsToDelete) {
		this.componentsToDelete = componentsToDelete;
	}
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

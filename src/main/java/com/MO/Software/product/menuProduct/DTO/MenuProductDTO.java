package com.MO.Software.product.menuProduct.DTO;

import java.util.List;

import com.MO.Software.product.menuProduct.menuProductComponents.DTO.MenuProductComponentsDTO;

public class MenuProductDTO {

	private Long id;
	private String productName;
	private Double sellPrice;
	private Double buyPrice;
	private Long menuCategoryId;
	private String menuCategoryName;
	private Double gainPercentage;
	private List<MenuProductComponentsDTO> menuProductComponentsDTOList;
	private Double count;
	
	public Double getCount() {
		return count;
	}
	public void setCount(Double count) {
		this.count = count;
	}
	public List<MenuProductComponentsDTO> getMenuProductComponentsDTOList() {
		return menuProductComponentsDTOList;
	}
	public void setMenuProductComponentsDTOList(List<MenuProductComponentsDTO> menuProductComponentsDTOList) {
		this.menuProductComponentsDTOList = menuProductComponentsDTOList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getMenuCategoryName() {
		return menuCategoryName;
	}
	public void setMenuCategoryName(String menuCategoryName) {
		this.menuCategoryName = menuCategoryName;
	}
	public Double getGainPercentage() {
		return gainPercentage;
	}
	public void setGainPercentage(Double gainPercentage) {
		this.gainPercentage = gainPercentage;
	}
	
}

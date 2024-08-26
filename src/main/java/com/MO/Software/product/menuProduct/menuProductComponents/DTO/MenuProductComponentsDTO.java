package com.MO.Software.product.menuProduct.menuProductComponents.DTO;

public class MenuProductComponentsDTO {

	private Long id;
	private String componentName;
	private String menuProductName;
	private Long componentId;
	private Long menuProductId;
	private Double componentBuyPrice;
	private Double menuProductBuyPrice;
	private Double quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getMenuProductName() {
		return menuProductName;
	}
	public void setMenuProductName(String menuProductName) {
		this.menuProductName = menuProductName;
	}
	public Long getComponentId() {
		return componentId;
	}
	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}
	public Long getMenuProductId() {
		return menuProductId;
	}
	public void setMenuProductId(Long menuProductId) {
		this.menuProductId = menuProductId;
	}
	public Double getComponentBuyPrice() {
		return componentBuyPrice;
	}
	public void setComponentBuyPrice(Double componentBuyPrice) {
		this.componentBuyPrice = componentBuyPrice;
	}
	public Double getMenuProductBuyPrice() {
		return menuProductBuyPrice;
	}
	public void setMenuProductBuyPrice(Double menuProductBuyPrice) {
		this.menuProductBuyPrice = menuProductBuyPrice;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	 
}

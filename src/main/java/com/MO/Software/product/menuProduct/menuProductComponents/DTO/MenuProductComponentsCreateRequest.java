package com.MO.Software.product.menuProduct.menuProductComponents.DTO;

import java.util.List;

public class MenuProductComponentsCreateRequest {
	private Long menuProductComponentId;
	private Long productId;
	private Double quantity;
	private Long menuProductId;
	private List<Long> placeForConsumingId;
	
	
	public Long getMenuProductComponentId() {
		return menuProductComponentId;
	}
	public void setMenuProductComponentId(Long menuProductComponentId) {
		this.menuProductComponentId = menuProductComponentId;
	}
	public List<Long> getPlaceForConsumingId() {
		return placeForConsumingId;
	}
	public void setPlaceForConsumingId(List<Long> placeForConsumingId) {
		this.placeForConsumingId = placeForConsumingId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Long getMenuProductId() {
		return menuProductId;
	}
	public void setMenuProductId(Long menuProductId) {
		this.menuProductId = menuProductId;
	}
	
	
}

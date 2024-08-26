package com.MO.Software.product.menuProduct.menuProductComponents;


import com.MO.Software.product.productModel;
import com.MO.Software.product.menuProduct.MenuProductModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MenuProductComponents {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="menuProductModel")
	private MenuProductModel menuProductModel;
	
	@ManyToOne
	@JoinColumn(name="productModelId")
	private productModel productModel;
	
	private Double quantity;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MenuProductModel getMenuProductModel() {
		return menuProductModel;
	}

	public void setMenuProductModel(MenuProductModel menuProductModel) {
		this.menuProductModel = menuProductModel;
	}

	public productModel getProductModel() {
		return productModel;
	}

	public void setProductModel(productModel productModel) {
		this.productModel = productModel;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	
	
}

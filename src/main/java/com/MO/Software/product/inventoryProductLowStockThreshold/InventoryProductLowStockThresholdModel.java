package com.MO.Software.product.inventoryProductLowStockThreshold;

import com.MO.Software.operation.pages.pageModel;
import com.MO.Software.product.productModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InventoryProductLowStockThresholdModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="productModelId")
	private productModel productModel;
	
	@ManyToOne
	@JoinColumn(name="placeModelId")
	private pageModel placeModel;
	
	private Double threshold;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public productModel getProductModel() {
		return productModel;
	}

	public void setProductModel(productModel productModel) {
		this.productModel = productModel;
	}

	public pageModel getPlaceModel() {
		return placeModel;
	}

	public void setPlaceModel(pageModel placeModel) {
		this.placeModel = placeModel;
	}

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}
	
	
}

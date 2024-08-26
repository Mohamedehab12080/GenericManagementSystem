package com.MO.Software.product.productContainers;

import com.MO.Software.place.storeProducts.containers.Container;
import com.MO.Software.product.productModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductContainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "productModelId")
	private productModel productModel;
    
    @ManyToOne
    @JoinColumn(name = "containerId")
    private Container container;
    
	private Double quantity;

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

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

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}
    
    
}

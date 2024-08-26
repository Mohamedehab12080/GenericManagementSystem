package com.MO.Software.product.productContainers.productMoreThanContainer;

import com.MO.Software.place.storeProducts.ProductBatchModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StoreProductMoreThanContainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String containerName;	
	private Double quantityOfProductContainer;
	
	@ManyToOne
    @JoinColumn(name = "productBatchModelId")
	private ProductBatchModel productBatchModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public Double getQuantityOfProductContainer() {
		return quantityOfProductContainer;
	}

	public void setQuantityOfProductContainer(Double quantityOfProductContainer) {
		this.quantityOfProductContainer = quantityOfProductContainer;
	}

	public ProductBatchModel getProductBatchModel() {
		return productBatchModel;
	}

	public void setProductBatchModel(ProductBatchModel productBatchModel) {
		this.productBatchModel = productBatchModel;
	}

	
	
}

package com.MO.Software.product.productContainers.productMoreThanContainer.DTO;

public class StoreProductMoreThanContainerDTO {

	private Long id;
	private Long storeProductId;
	private String containerName;
	private Double quantityOfProductContainer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStoreProductId() {
		return storeProductId;
	}
	public void setStoreProductId(Long storeProductId) {
		this.storeProductId = storeProductId;
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
	
	
}

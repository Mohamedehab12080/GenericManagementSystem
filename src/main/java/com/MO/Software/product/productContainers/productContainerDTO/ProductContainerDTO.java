package com.MO.Software.product.productContainers.productContainerDTO;

public class ProductContainerDTO {

	private Long id;
	private Long productId;
	private String productName;
	private Long containerId;
	private String containerName;
	private Double productContainerQuantity;
	
	
	public ProductContainerDTO() {
		super();
	}
	
	public ProductContainerDTO(Long id, Long productId, String productName, Long containerId, String containerName,
			Double productContainerQuantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.containerId = containerId;
		this.containerName = containerName;
		this.productContainerQuantity = productContainerQuantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getContainerId() {
		return containerId;
	}
	public void setContainerId(Long containerId) {
		this.containerId = containerId;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public Double getProductContainerQuantity() {
		return productContainerQuantity;
	}

	public void setProductContainerQuantity(Double productContainerQuantity) {
		this.productContainerQuantity = productContainerQuantity;
	}


	
	
}

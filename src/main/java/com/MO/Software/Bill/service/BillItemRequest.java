package com.MO.Software.Bill.service;

public class BillItemRequest {

	private Long productBatchId;
    private Long inventoryId;  
    private int quantity;
    private String type;
    
	public Long getProductBatchId() {
		return productBatchId;
	}
	public void setProductBatchId(Long productBatchId) {
		this.productBatchId = productBatchId;
	}
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
}

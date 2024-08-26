package com.MO.Software.Bill.billMenuProduct;

import com.MO.Software.Bill.billModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BillMenuProductsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private Double productBuyPrice;
    private Double productSellPrice;
    private Double quantity;
    
    private Double rowTotal;
    
    private Double discountPercentage;
    private String productName;
    private Long productId;
    private String categoryName;
    private Long categoryId;
        
    @ManyToOne
    @JoinColumn(name = "billModelId")
    private billModel billModel;
    
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getProductBuyPrice() {
		return productBuyPrice;
	}

	public void setProductBuyPrice(Double productBuyPrice) {
		this.productBuyPrice = productBuyPrice;
	}

	public Double getProductSellPrice() {
		return productSellPrice;
	}

	public void setProductSellPrice(Double productSellPrice) {
		this.productSellPrice = productSellPrice;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(Double rowTotal) {
		this.rowTotal = rowTotal;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public billModel getBillModel() {
		return billModel;
	}

	public void setBillModel(billModel billModel) {
		this.billModel = billModel;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
package com.MO.Software.category.DTO;

import java.util.List;

import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;

public class categoryProductsResponse {

	private String categoryName;
	private Long categoryId;
	private Double categoryTotalSells;
	private List<ProductSummaryDTO> productSummaryDTO;
	
	public categoryProductsResponse() {
		super();
	}
	
	public categoryProductsResponse(String categoryName, Long categoryId, Double categoryTotalSells,List<ProductSummaryDTO> productSummaryDTO) {
		super();
		this.categoryName = categoryName;
		this.categoryId = categoryId;
		this.categoryTotalSells = categoryTotalSells;
		this.productSummaryDTO=productSummaryDTO;
	}
	
	public List<ProductSummaryDTO> getProductSummaryDTO() {
		return productSummaryDTO;
	}
	public void setProductSummaryDTO(List<ProductSummaryDTO> productSummaryDTO) {
		this.productSummaryDTO = productSummaryDTO;
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
	public Double getCategoryTotalSells() {
		return categoryTotalSells;
	}
	public void setCategoryTotalSells(Double categoryTotalSells) {
		this.categoryTotalSells = categoryTotalSells;
	}
	
}

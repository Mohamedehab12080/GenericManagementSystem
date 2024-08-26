package com.MO.Software.product.menuProduct;

import com.MO.Software.category.menuCategory.MenuCategoryModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class MenuProductModel {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_prod_seq")
    @SequenceGenerator(name = "menu_product_seq", sequenceName = "menu_product_sequence", allocationSize = 1)
	private Long id;
	
	private String productName;
	
	private Double sellPrice;
	
	private Double buyPrice;
	
	private Double gainedPercentage;
	
	private Double count;

	@ManyToOne
	@JoinColumn(name="menuCategoryModelId")
	private MenuCategoryModel menuCategoryModel;

	
	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public Double getGainedPercentage() {
		return gainedPercentage;
	}

	public void setGainedPercentage(Double gainedPercentage) {
		this.gainedPercentage = gainedPercentage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public MenuCategoryModel getMenuCategoryModel() {
		return menuCategoryModel;
	}

	public void setMenuCategoryModel(MenuCategoryModel menuCategoryModel) {
		this.menuCategoryModel = menuCategoryModel;
	}
	
}

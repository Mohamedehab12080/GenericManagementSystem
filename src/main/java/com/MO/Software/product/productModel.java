package com.MO.Software.product;


import com.MO.Software.category.categoryModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class productModel {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double buyPrice;
    private Double sellPrice;
    private Double gainPercentage;

    private Double lowStockThreshold;
    
    @ManyToOne
    @JoinColumn(name = "categoryModelId")
    private categoryModel categoryModel;

	public Double getLowStockThreshold() {
		return lowStockThreshold;
	}

	public void setLowStockThreshold(Double lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getGainPercentage() {
		return gainPercentage;
	}

	public void setGainPercentage(Double gainPercentage) {
		this.gainPercentage = gainPercentage;
	}

	public categoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(categoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

   
}

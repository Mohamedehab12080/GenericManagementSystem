package com.MO.Software.product.productsConstantsAdds;

import com.MO.Software.product.productsConstantsAdds.constantsCategory.ConstantsCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductsConstantAdds {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String constantName;
	private boolean free;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="ConstantsCategoryId")
	private ConstantsCategory ConstantsCategory;
	
	
	public ConstantsCategory getConstantsCategory() {
		return ConstantsCategory;
	}
	public void setConstantsCategory(ConstantsCategory constantsCategory) {
		ConstantsCategory = constantsCategory;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}

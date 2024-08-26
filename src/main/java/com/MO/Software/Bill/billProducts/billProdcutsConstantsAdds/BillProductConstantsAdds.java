package com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BillProductConstantsAdds {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long constantId;
	private Long billProductId;
	private String constantName;
	private Double constantPrice;
	
	public Double getConstantPrice() {
		return constantPrice;
	}
	public void setConstantPrice(Double constantPrice) {
		this.constantPrice = constantPrice;
	}
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getConstantId() {
		return constantId;
	}
	public void setConstantId(Long constantId) {
		this.constantId = constantId;
	}
	public Long getBillProductId() {
		return billProductId;
	}
	public void setBillProductId(Long billProductId) {
		this.billProductId = billProductId;
	}

	
}

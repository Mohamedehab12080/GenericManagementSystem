package com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.DTO;

public class BillProductConstantsAddsDTO {

	private Long id;
	private Long constantId;
	private Long billProductId;
	private String constantName;
	private Double constantPrice;
	
	public BillProductConstantsAddsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillProductConstantsAddsDTO(Long id, Long constantId, Long billProductId, String constantName,
			Double constantPrice) {
		super();
		this.id = id;
		this.constantId = constantId;
		this.billProductId = billProductId;
		this.constantName = constantName;
		this.constantPrice = constantPrice;
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
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public Double getConstantPrice() {
		return constantPrice;
	}
	public void setConstantPrice(Double constantPrice) {
		this.constantPrice = constantPrice;
	}
	
}

package com.MO.Software.Bill.billProducts.DTO;

import java.util.ArrayList;
import java.util.List;

import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.DTO.BillProductConstantsAddsDTO;

public class billProductDTO {

    private Long id;
    private Double productBuyPrice;
    private Double productSellPrice;
    private Double quantity;
    private Double discountPercentage;
    private String productName;
    private Long productId;
    private Long billId;
    private String categoryName;
    private Long categoryId;
    private boolean changeSellPrice;
    private Double rowTotal;
    private List<BillProductConstantsAddsDTO> listOfAdds=new ArrayList<BillProductConstantsAddsDTO>();
    private boolean menuProduct;
    
    public boolean isMenuProduct() {
		return menuProduct;
	}

	public void setMenuProduct(boolean menuProduct) {
		this.menuProduct = menuProduct;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public List<BillProductConstantsAddsDTO> getListOfAdds() {
		return listOfAdds;
	}

	public void setListOfAdds(List<BillProductConstantsAddsDTO> listOfAdds) {
		this.listOfAdds = listOfAdds;
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

	public Double getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(Double rowTotal) {
		this.rowTotal = rowTotal;
	}

	public boolean isChangeSellPrice() {
		return changeSellPrice;
	}

	public void setChangeSellPrice(boolean changeSellPrice) {
		this.changeSellPrice = changeSellPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProductBuyPrice(Double productBuyPrice) {
		this.productBuyPrice = productBuyPrice;
	}

	public void setProductSellPrice(Double productSellPrice) {
		this.productSellPrice = productSellPrice;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Long getId() {
        return id;
    }

    public Double getProductBuyPrice() {
        return productBuyPrice;
    }

    public Double getProductSellPrice() {
        return productSellPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBillId() {
        return billId;
    }
}

package com.MO.Software.Bill.billProducts.DTO;

import com.MO.Software.Bill.billModel;
import com.MO.Software.Bill.billProducts.billProductModel;

public class billProductDTOMapper {
	
	
	public static billProductDTO mapBillProductToDTO(billProductModel bill) {
	    billProductDTO dto = new billProductDTO();
	    dto.setId(bill.getId());
	    dto.setProductBuyPrice(bill.getProductBuyPrice());
	    dto.setProductSellPrice(bill.getProductSellPrice());
	    dto.setQuantity(bill.getQuantity());
	    dto.setDiscountPercentage(bill.getDiscountPercentage());
	    dto.setProductName(bill.getProductName());
	    dto.setProductId(bill.getProductId());
	    dto.setBillId(bill.getBillModel() != null ? bill.getBillModel().getId() : null);
	    dto.setRowTotal(bill.getRowTotal());
	    dto.setCategoryId(bill.getCategoryId());
	    dto.setCategoryName(bill.getCategoryName());
	    return dto;
	}
	 
	 public static billProductModel mapDTOToBillProduct(billProductDTO dto) {
	        billProductModel billProduct = new billProductModel();
	        billProduct.setId(dto.getId());
	        billProduct.setProductBuyPrice(dto.getProductBuyPrice());
	        billProduct.setProductSellPrice(dto.getProductSellPrice());
	        billProduct.setQuantity(dto.getQuantity());
	        billProduct.setDiscountPercentage(dto.getDiscountPercentage());
	        billProduct.setProductName(dto.getProductName());
	        billProduct.setProductId(dto.getProductId());
	        billModel billMode=new billModel();
	        billMode.setId(dto.getBillId()!=null ? dto.getBillId() : null);
	        billProduct.setCategoryId(dto.getCategoryId());
	        billProduct.setCategoryName(dto.getCategoryName());
	        billProduct.setBillModel(billMode);
//	        billProduct.setRowTotal(dto.getRowTotal());
	        return billProduct;
	    }
}

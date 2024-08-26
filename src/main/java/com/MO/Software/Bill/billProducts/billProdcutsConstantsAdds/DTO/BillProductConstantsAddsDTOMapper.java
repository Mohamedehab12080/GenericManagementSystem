package com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.DTO;

import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductConstantsAdds;

public class BillProductConstantsAddsDTOMapper {

	public static BillProductConstantsAddsDTO mapBillProductConstantsAddsToDTO(BillProductConstantsAdds adds)
	{
		BillProductConstantsAddsDTO dto=new BillProductConstantsAddsDTO();
		dto.setBillProductId(adds.getBillProductId());
		dto.setId(adds.getId());
		dto.setConstantId(adds.getConstantId());
		dto.setConstantName(adds.getConstantName());
		dto.setConstantPrice(adds.getConstantPrice());
		return dto;
	}
	
	public static BillProductConstantsAdds mapDTOToBillProductConstantsAdds(BillProductConstantsAddsDTO adds)
	{
		BillProductConstantsAdds dto=new BillProductConstantsAdds();
		dto.setBillProductId(adds.getBillProductId());
		dto.setId(adds.getId());
		dto.setConstantId(adds.getConstantId());
		dto.setConstantName(adds.getConstantName());
		dto.setConstantPrice(adds.getConstantPrice());
		return dto;
	}
}

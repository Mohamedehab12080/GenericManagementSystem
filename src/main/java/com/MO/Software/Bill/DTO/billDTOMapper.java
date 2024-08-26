package com.MO.Software.Bill.DTO;

import com.MO.Software.Bill.billModel;
import com.MO.Software.Bill.billType.billType;
import com.MO.Software.Day.dayModel;

public class billDTOMapper {

	
	public static billDTO mapBillModelTOBillDTO(billModel bill)
	{
		
		billDTO dto=new billDTO();
		dto.setId(bill.getId());
		dto.setEmployeeName(bill.getEmployeeName());
		dto.setEmployeeId(bill.getEmployeeId());
		dto.setDayId(bill.getDayModel() != null ? bill.getDayModel().getId() : null);
		dto.setDateTime(bill.getDateTime());
		dto.setBillTotal(bill.getBillTotal());
		dto.setBillPayed(bill.getBillPayed());
		dto.setBillRemained(bill.getBillRemained());
		dto.setCustomerId(bill.getCustomerId());
		dto.setCustomerName(bill.getCustomerName());
		dto.setBillTypeId(bill.getBillType() != null ? bill.getBillType().getId() : null);
		dto.setBillTypeName(bill.getBillType() != null ? bill.getBillType().getName() : null);
		dto.setReturnedBill(bill.isReturnedBill());
		return dto;
	}
	
	
	public static billModel mapDTOToBillModel(billDTO dto)
	{
		billModel bill=new billModel();
		
		bill.setId(dto.getId());
		bill.setCustomerId(dto.getCustomerId());
		bill.setCustomerName(dto.getCustomerName());
		bill.setEmployeeId(dto.getEmployeeId());
		bill.setEmployeeName(dto.getEmployeeName());
		dayModel day=new dayModel();
		day.setId(dto.getDayId()!=null ? dto.getDayId() :null);
		bill.setDayModel(day);
		bill.setDateTime(dto.getDateTime());
		bill.setBillTotal(dto.getBillTotal());
		bill.setBillPayed(dto.getBillPayed());
		bill.setBillRemained(dto.getBillRemained());
		bill.setCustomerId(dto.getCustomerId());
		bill.setCustomerName(dto.getCustomerName());
		billType billType=new billType();
		billType.setId(dto.getBillTypeId() !=null ? dto.getBillTypeId() :null);
		bill.setBillType(billType);
		bill.setReturnedBill(dto.isReturnedBill());
		bill.setBillDayCounter(dto.getBillDayCounter());
		return bill;
	}
}

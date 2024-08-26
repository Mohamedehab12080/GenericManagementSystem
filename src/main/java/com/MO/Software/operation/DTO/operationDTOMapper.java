package com.MO.Software.operation.DTO;

import com.MO.Software.operation.operationModel;
import com.MO.Software.operation.pages.pageModel;

public class operationDTOMapper {

	
	public static operationDTO mapOperationModelToDTO(operationModel op)
	{
		operationDTO dto=new operationDTO();
		dto.setId(op.getId());
		dto.setName(op.getName());
		dto.setNote(op.getNote());
		pageModel page=op.getPageModel();
		if(page!=null)
		{
			dto.setPageName(page.getName());
			dto.setPageId(page.getId());
		}
		return dto;
	}
	
	public static operationModel mapOperationModelToDTO(operationDTO dto)
	{
		operationModel op=new operationModel();
		op.setId(dto.getId());
		op.setName(dto.getName());
		op.setNote(dto.getNote());
		if(dto.getPageId()!=null)
		{
			pageModel page=new pageModel();
			page.setId(dto.getPageId());
			op.setPageModel(page);
		}
		return op;
	}
}

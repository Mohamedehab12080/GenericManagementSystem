package com.MO.Software.employee.employeeAccess.DTO;

import com.MO.Software.employee.employeeModel;
import com.MO.Software.employee.employeeAccess.employeeAccessesModel;
import com.MO.Software.employee.employeeAccess.controller.employeeAccessResponseForMostafa;
import com.MO.Software.operation.operationModel;
import com.MO.Software.operation.DTO.operationDTO;
import com.MO.Software.operation.DTO.operationDTOMapper;

public class employeeAccessDTOMapper {

	public static employeeAccessDTO mapEmployeeAccessTODTO(employeeAccessesModel emp)
	{
		employeeAccessDTO dto=new employeeAccessDTO();
		dto.setId(emp.getId());
		employeeModel empModel=emp.getEmployeeModel();
		if(empModel!=null)
		{
			dto.setEmployeeId(empModel.getId());
		}
		
		operationModel opModel=emp.getOperationModel();
		if(opModel!=null)
		{
			operationDTO dtoOp=operationDTOMapper.mapOperationModelToDTO(opModel);
			dto.setOperationId(dtoOp.getId());
			dto.setOperationName(dtoOp.getName());
			dto.setPageId(dtoOp.getPageId());
			dto.setPageName(dtoOp.getPageName());
		}
		return dto;
	}
	public static employeeAccessResponseForMostafa mapEmployeeAccessModelForResponse(employeeAccessesModel emp)
	{
		employeeAccessResponseForMostafa dto=new employeeAccessResponseForMostafa();
		
		operationModel opModel=emp.getOperationModel();
		if(opModel!=null)
		{
			operationDTO dtoOp=operationDTOMapper.mapOperationModelToDTO(opModel);
			dto.setOperationId(dtoOp.getId());
			dto.setPageId(dtoOp.getPageId());
		}
		return dto;
	}
	
	
	public static employeeAccessesModel mapEmployeeAccessDTOToEmployeeAccessModel(employeeAccessDTO dto)
	{
		employeeAccessesModel empAc=new employeeAccessesModel();
		empAc.setId(dto.getId());
		if(dto.getEmployeeId()!=null)
		{
			employeeModel empMode=new employeeModel();
			empMode.setId(dto.getEmployeeId());
			empAc.setEmployeeModel(empMode);
		}
		if(dto.getOperationId()!=null)
		{
			operationModel opModel=new operationModel();
			opModel.setId(dto.getOperationId());
			empAc.setOperationModel(opModel);
		}
		return empAc;
	}
}

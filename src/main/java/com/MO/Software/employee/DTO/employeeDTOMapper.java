package com.MO.Software.employee.DTO;

import com.MO.Software.employee.employeeModel;

import com.MO.Software.employee.jobType.jobTypeModel;

public class employeeDTOMapper {

	public static employeeDTO mapEmployeeToDTO(employeeModel emp)
	{
		employeeDTO dto=new employeeDTO();
		jobTypeModel jobType=emp.getJobTypeModel();
		if(jobType!=null)
		{
			dto.setJobTypeId(jobType.getId());
			dto.setJobTypeName(jobType.getName());
		}
		dto.setSalary(emp.getSalary());
		dto.setId(emp.getId());
		dto.setEmpName(emp.getName());
		return dto;
	}
	
	public static employeeModel mapDTOTOEmployee(employeeDTO dto)
	{
		employeeModel emp=new employeeModel();
		if(dto.getJobTypeId()!=null)
		{
			jobTypeModel jobType=new jobTypeModel();
			jobType.setId(dto.getJobTypeId());
			emp.setJobTypeModel(jobType);
		}
		emp.setSalary(dto.getSalary());
		emp.setId(dto.getId());
		emp.setName(dto.getEmpName());
		return emp;
	}
}

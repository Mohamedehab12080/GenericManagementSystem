package com.MO.Software.employee.employeeAccess.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeAccess.employeeAccessesModel;
import com.MO.Software.employee.employeeAccess.DTO.employeeAccessDTO;
import com.MO.Software.product.service.responseOperations;

public interface employeeAccessServiceInterface extends baseServiceInterface<employeeAccessesModel,Integer> {

	List<employeeAccessesModel>findByEmployeeModelId(Long employeeId);
	List<employeeAccessDTO> findByEmployeeModelIdAndOperationModelPageModelId(Long employeeId,Integer pageModelId);
	responseOperations<employeeAccessDTO> updateEmployeeAccess(Long employeeId,List<Integer> operationIdsInsert,List<Integer> operationIdsDelete);
	employeeAccessDTO findByEmployeeModelIdAndOperationModelId(Long employeeId,Integer operationId);
}

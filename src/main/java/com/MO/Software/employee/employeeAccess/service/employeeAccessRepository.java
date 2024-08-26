package com.MO.Software.employee.employeeAccess.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.employee.employeeAccess.employeeAccessesModel;

@Repository
public interface employeeAccessRepository extends baseRepository<employeeAccessesModel,Integer>{
	@Query("SELECT eA From employeeAccessesModel eA where eA.employeeModel.id=:employeeId")
	public List<employeeAccessesModel> findByEmployeeModelId(Long employeeId);

	@Query("SELECT eA From employeeAccessesModel eA where eA.employeeModel.id=:employeeId And eA.operationModel.pageModel.id=:pageModelId")
	public List<employeeAccessesModel> findByEmployeeModelIdAndOperationModelPageModelId(Long employeeId,
			Integer pageModelId);
	@Query("SELECT eA From employeeAccessesModel eA where eA.employeeModel.id=:employeeId And eA.operationModel.id=:opertationModelId")
	public employeeAccessesModel findByEmployeeModelIdAndOperationModelId(Long employeeId,
			Integer opertationModelId);
}

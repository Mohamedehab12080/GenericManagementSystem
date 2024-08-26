package com.MO.Software.employee.employeeAccess.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.employee.employeeModel;
import com.MO.Software.employee.employeeAccess.employeeAccessesModel;
import com.MO.Software.employee.employeeAccess.DTO.employeeAccessDTO;
import com.MO.Software.employee.employeeAccess.DTO.employeeAccessDTOMapper;
import com.MO.Software.operation.operationModel;
import com.MO.Software.product.service.responseOperations;

@Service
public class employeeAccessServiceImpl 
extends baseServiceImpl<employeeAccessesModel,Integer>
implements employeeAccessServiceInterface{

	@Autowired
	private employeeAccessRepository employeeAccessRepository;
	
	@Override
	protected baseRepository<employeeAccessesModel, Integer> getRepository() {

		return employeeAccessRepository;
	}

	@Override
	public List<employeeAccessesModel> findByEmployeeModelId(Long employeeId) {
		List<employeeAccessesModel> founded=employeeAccessRepository.findByEmployeeModelId(employeeId);
		if(founded!=null)
		{
			return founded;
		}else
		{
			return Collections.emptyList();
		}
	}

	@Override
	public employeeAccessesModel save(employeeAccessesModel empAcModel)
	{
		employeeAccessesModel founded=employeeAccessRepository.findByEmployeeModelIdAndOperationModelId(empAcModel.getEmployeeModel().getId(),empAcModel.getOperationModel().getId());;

		if(founded!=null)
		{
			return null;
		}else
		{
			employeeAccessesModel inserted=employeeAccessRepository.save(empAcModel);
			return inserted;
		}
		
	}
	
	@Override
	public List<employeeAccessDTO> findByEmployeeModelIdAndOperationModelPageModelId(Long employeeId,
			Integer pageModelId) {
		List<employeeAccessesModel> founded= employeeAccessRepository
				.findByEmployeeModelIdAndOperationModelPageModelId(employeeId,pageModelId);
		if(founded!=null)
		{
			return founded.stream().map(employeeAccessDTOMapper::mapEmployeeAccessTODTO).collect(Collectors.toList());
		}else
		{
			return Collections.emptyList();
		}
		
	}

	@Override
	public responseOperations<employeeAccessDTO> updateEmployeeAccess(Long employeeId, List<Integer> operationIds,List<Integer> operationIdsDelete) 
	{
		List<employeeAccessDTO> listOfDto=new ArrayList<employeeAccessDTO>();
		responseOperations<employeeAccessDTO> response=new responseOperations<>();
		for(Integer opId:operationIdsDelete)
		{
			employeeAccessDTO foundedObj =findByEmployeeModelIdAndOperationModelId(employeeId,opId);
			if(foundedObj!=null)
			{
				employeeAccessRepository.deleteById(foundedObj.getId());
			}
		}
		
		for(Integer opId:operationIds)
		{
			employeeAccessDTO foundedObj =findByEmployeeModelIdAndOperationModelId(employeeId,opId);
			if(foundedObj!=null)
			{
				listOfDto.add(foundedObj);
			}else
			{
				employeeAccessesModel empAcModel=new employeeAccessesModel();
				employeeModel empModel=new employeeModel();
				empModel.setId(employeeId);
				operationModel opModelIns=new operationModel();
				opModelIns.setId(opId);
				empAcModel.setOperationModel(opModelIns);
				empAcModel.setEmployeeModel(empModel);
				employeeAccessesModel insertednew=save(empAcModel);
				empAcModel.setId(insertednew.getId());
				listOfDto.add(employeeAccessDTOMapper.mapEmployeeAccessTODTO(empAcModel));
			}
		}
		response.setMessage("تم التعديل");
		response.setState(true);
		response.setListOfDTO(listOfDto);
		
		return response;
	}

	@Override
	public employeeAccessDTO findByEmployeeModelIdAndOperationModelId(Long employeeId,Integer opertationModelId) {
		employeeAccessesModel founded= employeeAccessRepository
				.findByEmployeeModelIdAndOperationModelId(employeeId,opertationModelId);
		if(founded!=null)
		{
			return employeeAccessDTOMapper.mapEmployeeAccessTODTO(founded);
		}else
		{
			return null;
		}
	}

}

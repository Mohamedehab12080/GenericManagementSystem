package com.MO.Software.employee.employeeAccess.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.employee.employeeModel;
import com.MO.Software.employee.employeeAccess.employeeAccessesModel;
import com.MO.Software.employee.employeeAccess.DTO.employeeAccessDTO;
import com.MO.Software.employee.employeeAccess.DTO.employeeAccessDTOMapper;
import com.MO.Software.employee.employeeAccess.service.employeeAccessServiceInterface;
import com.MO.Software.operation.operationModel;
import com.MO.Software.product.service.responseOperations;

@RestController
@RequestMapping("/employeeAccess")
@Service
public class employeeAccessRestController {

	@Autowired
	private employeeAccessServiceInterface employeeAccessServiceI;
	
	
	@RequestMapping("/giveAccess")
	public ResponseEntity<?> giveEmployeeAccsess(@RequestBody employeeAccessDTO employeeAccessDTO )
	{
		return new ResponseEntity< >(employeeAccessServiceI.save(employeeAccessDTOMapper.mapEmployeeAccessDTOToEmployeeAccessModel(employeeAccessDTO)),HttpStatus.CREATED);
	}
	
	@RequestMapping("/updateAccessAllData")
	public ResponseEntity<?> updateAccessAllData(
			@RequestBody employeeAccessUpdateRequest employeeAccessUpdateRequest)
	{
		return new ResponseEntity< >(employeeAccessServiceI.updateEmployeeAccess(employeeAccessUpdateRequest.getEmployeeId(), employeeAccessUpdateRequest.getOperationsIdInsert(),employeeAccessUpdateRequest.getOperationsIdDelet()),HttpStatus.CREATED);
	}
	
	/**
	 * @author BOBO
	 * @param employeeId
	 * @param operationsId
	 * @return
	 */
	public responseOperations<employeeAccessDTO> updateAccessAllDataMethod(employeeAccessUpdateRequest employeeAccessUpdateRequest)
	{
		return employeeAccessServiceI.updateEmployeeAccess(employeeAccessUpdateRequest.getEmployeeId(), employeeAccessUpdateRequest.getOperationsIdInsert(),employeeAccessUpdateRequest.getOperationsIdDelet());
	}
	
	/**
	 * @author BOBO
	 * @param employeeAccessDTO
	 * @return
	 */
	public responseOperations<employeeAccessDTO> giveEmployeeAccsessMethod(employeeAccessDTO employeeAccessDTO )
	{
		responseOperations<employeeAccessDTO> response=new responseOperations<>();
		employeeAccessesModel inserted =employeeAccessServiceI.save(employeeAccessDTOMapper.mapEmployeeAccessDTOToEmployeeAccessModel(employeeAccessDTO));
		if(inserted!=null)
		{
			response.setMessage("تم الاضافة");
			response.setState(true);
			response.setDTOObject(employeeAccessDTOMapper.mapEmployeeAccessTODTO(inserted));
			
		}else
		{
			response.setMessage("تم الاضافة مسبقا");
			response.setState(false);
			
		}
		return	response;
	}
	
	@RequestMapping("/giveAccessAllData/{employeeId}")
	public ResponseEntity<?> giveEmployeeAccsessAllData(@PathVariable("employeeId") Long employeeId,@RequestBody
			List<Integer> operationsId)
	{
		employeeModel empModel=new employeeModel();
		empModel.setId(empModel.getId());
		for(Integer opId:operationsId)
		{
			employeeAccessesModel empAc=new employeeAccessesModel();
			operationModel opModel=new operationModel();
			opModel.setId(opId);
			empAc.setEmployeeModel(empModel);
			empAc.setOperationModel(opModel);
			employeeAccessServiceI.save(empAc);
		}
		return new ResponseEntity< >("Created",HttpStatus.CREATED);
	}
	
	/**
	 * @author BOBO
	 * @param employeeId
	 * @param operationsId
	 * @return 
	 */
	public String giveEmployeeAccsessAllDataMethod(Long employeeId,List<Integer> operationsId)
	{
		employeeModel empModel=new employeeModel();
		empModel.setId(empModel.getId());
		for(Integer opId:operationsId)
		{
			employeeAccessesModel empAc=new employeeAccessesModel();
			operationModel opModel=new operationModel();
			opModel.setId(opId);
			empAc.setEmployeeModel(empModel);
			empAc.setOperationModel(opModel);
			employeeAccessServiceI.save(empAc);
		}
		return "Created";
	}
	
	
	
	@RequestMapping("/findByEmployeeId/{id}")
	public ResponseEntity<?> findAllEmployeeAccess(@PathVariable("id") Long id)
	{
		List<employeeAccessesModel> founded=employeeAccessServiceI.findByEmployeeModelId(id);
		if(founded!=null)
		{
			return new ResponseEntity< >(founded.stream().map(employeeAccessDTOMapper::mapEmployeeAccessTODTO).collect(Collectors.toList()),HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Access",HttpStatus.OK);
		}
	}
	
	@RequestMapping("/findByEmployeeIdIds/{id}")
	public ResponseEntity<?> findAllEmployeeAccessbyId(@PathVariable("id") Long id)
	{
		List<employeeAccessesModel> founded=employeeAccessServiceI.findByEmployeeModelId(id);
		if(founded!=null)
		{
			return new ResponseEntity< >(founded.stream().map(employeeAccessDTOMapper::mapEmployeeAccessModelForResponse).collect(Collectors.toList()),HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Access",HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> findAllEmployeeAccessbyIdForLoginMethod(Long id)
	{
		List<employeeAccessesModel> founded=employeeAccessServiceI.findByEmployeeModelId(id);
		if(founded!=null)
		{
			return new ResponseEntity< >(founded.stream().map(employeeAccessDTOMapper::mapEmployeeAccessModelForResponse).collect(Collectors.toList()),HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Access",HttpStatus.OK);
		}
	}
	
	/**
	 * @author BOBO
	 * @param employeeId
	 * @return List<employeeAccessDTO>
	 */
	public List<employeeAccessDTO> findAllEmployeeAccessMethod(Long employeeId)
	{
		List<employeeAccessesModel> founded=employeeAccessServiceI.findByEmployeeModelId(employeeId);
		if(founded!=null)
		{
			return founded.stream().map(employeeAccessDTOMapper::mapEmployeeAccessTODTO).collect(Collectors.toList());
		}else
		{
			return Collections.emptyList();
		}
	}
	
	
	@RequestMapping("/findByEmployeeIdAndPagId/{employeeId}/{pageId}")
	public ResponseEntity<?> findAllEmployeeAccessAndPageId(@PathVariable("employeeId") Long employeeId,@PathVariable("pageId") Integer pageId)
	{
		List<employeeAccessDTO> founded=employeeAccessServiceI.findByEmployeeModelIdAndOperationModelPageModelId(employeeId,pageId);
		if(founded!=null)
		{
			return new ResponseEntity< >(founded,HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Access",HttpStatus.OK);
		}
	}
	
	/**
	 * @author BOBO
	 * @param employeeId
	 * @return List<employeeAccessDTO>
	 */
	public List<employeeAccessDTO> findAllEmployeeAccessAndPageIdMethod(Long employeeId,Integer pageId)
	{
		List<employeeAccessDTO> founded=employeeAccessServiceI.findByEmployeeModelIdAndOperationModelPageModelId(employeeId,pageId);
		if(founded!=null)
		{
			return founded;
		}else
		{
			return Collections.emptyList();
		}
	}
	
}

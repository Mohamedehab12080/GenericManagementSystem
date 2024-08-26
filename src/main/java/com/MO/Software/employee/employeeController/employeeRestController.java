package com.MO.Software.employee.employeeController;

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
import com.MO.Software.employee.DTO.employeeDTO;
import com.MO.Software.employee.DTO.employeeDTOMapper;
import com.MO.Software.employee.employeeService.employeeServiceInterface;
import com.MO.Software.product.service.responseOperations;

@RestController
@RequestMapping("/employee")
@Service
public class employeeRestController {

	@Autowired
	private employeeServiceInterface employeeServiceI;
	
	@RequestMapping("/add")
	public ResponseEntity<responseOperations<employeeDTO>> insertEmployee(@RequestBody employeeOperationRequest employeeOperationRequest)
	{	
		
		responseOperations<employeeDTO> response=employeeServiceI.insertEmployeeWithAllData(employeeOperationRequest);
		return new ResponseEntity<> (response,HttpStatus.CREATED);
	}
	
	/**
	 * @author BOBO
	 * @param employeeDTO Taking parameter of object employeeDto for insert all data
	 * @return return employeeDto of inserted
	 */
	public responseOperations<employeeDTO> insertEmployeeMethod(employeeOperationRequest employeeOperationRequest)
	{	
		
		responseOperations<employeeDTO> response=employeeServiceI.insertEmployeeWithAllData(employeeOperationRequest);
		return response;
	}
	
	@RequestMapping("/findAll")
	public ResponseEntity<?> findAllEmployees()
	{
		List<employeeModel> founded=employeeServiceI.findAll();
		if(!founded.isEmpty())
		{
			return new ResponseEntity< >(founded,HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Employees",HttpStatus.OK);	
		}
	}
	
	/**
	 * @author BOBO
	 * @return List<employeeDTO>
	 */
	public List<employeeDTO> findAllEmployeesMethod()
	{
		List<employeeModel> founded=employeeServiceI.findAll();
		if(!founded.isEmpty())
		{
			return founded.stream().map(employeeDTOMapper::mapEmployeeToDTO).collect(Collectors.toList());
		}else
		{
			return Collections.emptyList();	
		}
	}
	
	@RequestMapping("/findByJobTypeName/{jobTypeName}")
	public ResponseEntity<?> findAllEmployeesByJobTypeName(@PathVariable("jobTypeName") String jobTypeName)
	{
		List<employeeDTO> founded=employeeServiceI.findByJobTypeName(jobTypeName);
		if(!founded.isEmpty())
		{
			return new ResponseEntity< >(founded,HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Employees",HttpStatus.OK);	
		}
	}
	@RequestMapping("/findByJobTypeId/{jobTypeId}")
	public ResponseEntity<?> findAllEmployeesByJobTypeId(@PathVariable("jobTypeId") Long id)
	{
		List<employeeDTO> founded=employeeServiceI.findByJobTypeId(id);
		if(!founded.isEmpty())
		{
			return new ResponseEntity< >(founded,HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Employees",HttpStatus.OK);	
		}
	}
	
	public List<employeeDTO> findAllEmployeesByJobTypeNameMethod(String jobTypeName)
	{
		List<employeeDTO> founded=employeeServiceI.findByJobTypeName(jobTypeName);
		if(founded != null && !founded.isEmpty())
		{
			return founded;
		}else
		{
			return Collections.emptyList();
		}
	}
	
	public List<employeeDTO> findAllEmployeesByJobTypeIdMethod( Long id)
	{
		List<employeeDTO> founded=employeeServiceI.findByJobTypeId(id);
		if(founded != null && !founded.isEmpty())
		{
			return founded;
		}else
		{
			return Collections.emptyList();
		}
	}
	
	
	
}

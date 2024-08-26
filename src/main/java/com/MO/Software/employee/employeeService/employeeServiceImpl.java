package com.MO.Software.employee.employeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeModel;
import com.MO.Software.employee.DTO.employeeDTO;
import com.MO.Software.employee.DTO.employeeDTOMapper;
import com.MO.Software.employee.employeeAccess.employeeAccessesModel;
import com.MO.Software.employee.employeeAccess.service.employeeAccessServiceInterface;
import com.MO.Software.employee.employeeController.employeeOperationRequest;
import com.MO.Software.employee.jobType.jobTypeModel;
import com.MO.Software.employee.jobType.service.jobTypeServiceInterface;
import com.MO.Software.operation.operationModel;
import com.MO.Software.product.service.responseOperations;
import com.MO.Software.reportBase.CustomJasperViewer;
import com.MO.Software.reportBase.reportRequest;
import com.MO.Software.reportBase.reportViewer;

import net.sf.jasperreports.engine.JRException;

@Service
public class employeeServiceImpl 
extends baseServiceImpl<employeeModel,Long>
implements employeeServiceInterface{

	@Autowired
	private employeeRepository employeeRepository;
	@Autowired
	private jobTypeServiceInterface jobTypeServiceI;

	@Autowired
	private employeeAccessServiceInterface employeeAccessServiceI;
	
	@Autowired
	private reportViewer reportViewer;
	
	@Override
	protected baseRepository<employeeModel, Long> getRepository() {
		return employeeRepository;
	}

	@Override
	public responseOperations<employeeDTO> insertEmployeeWithAllData(employeeOperationRequest empDto) {
		employeeModel empModelEmp=findByName(empDto.getEmpName());
		responseOperations<employeeDTO> response=new responseOperations<>();
		if(empModelEmp!=null)
		{
			response.setState(false);
			response.setMessage("موجود مسبقا");
		}else
		{
			employeeDTO returnedEmpDto=new employeeDTO();
			returnedEmpDto.setEmpName(empDto.getEmpName());
			if(empDto.getJobTypeId()!=null)
			{
				Optional<jobTypeModel> jobType=jobTypeServiceI.findById(empDto.getJobTypeId());
				if(jobType.isPresent())
				{
					returnedEmpDto.setJobTypeId(empDto.getJobTypeId());
				}else if(empDto.getJobTypeName()!=null || !empDto.getJobTypeName().isBlank())
				{
					jobTypeModel jobTypeByName=jobTypeServiceI.findByName(empDto.getJobTypeName());
					if(jobTypeByName!=null)
					{
						returnedEmpDto.setJobTypeId(jobTypeByName.getId());
					}else
					{
						jobTypeModel jobInsert=new jobTypeModel();
						jobInsert.setName(empDto.getJobTypeName());
						jobTypeModel jobInserted=jobTypeServiceI.save(jobInsert);
						if(jobInserted!=null)
						{
							returnedEmpDto.setJobTypeId(jobInserted.getId());
						}
					}
					returnedEmpDto.setJobTypeName(empDto.getJobTypeName());
				}
					
			}else
			{
				if(empDto.getJobTypeName()!=null || !empDto.getJobTypeName().isBlank())
				{
					jobTypeModel jobTypeByName=jobTypeServiceI.findByName(empDto.getJobTypeName());
					if(jobTypeByName!=null)
					{
						returnedEmpDto.setJobTypeId(jobTypeByName.getId());
					}else
					{
						jobTypeModel jobInsert=new jobTypeModel();
						jobInsert.setName(empDto.getJobTypeName());
						jobTypeModel jobInserted=jobTypeServiceI.save(jobInsert);
						if(jobInserted!=null)
						{
							returnedEmpDto.setJobTypeId(jobInserted.getId());
						}
					}
					returnedEmpDto.setJobTypeName(empDto.getJobTypeName());
				}
			}
			returnedEmpDto.setSalary(empDto.getSalary());
			employeeModel insertedEmployee=employeeRepository.save(employeeDTOMapper.mapDTOTOEmployee(returnedEmpDto));
			returnedEmpDto.setId(insertedEmployee.getId());
			
//			if(empDto.getEmployeeSalaryId()!=null)
//			{
//				Optional<employeeSalaryModel> empSalary=employeeSalaryServiceI.findById(empDto.getEmployeeSalaryId());
//				if(empSalary.isPresent())
//				{
//					returnedEmpDto.setEmployeeSalaryId(empDto.getEmployeeSalaryId());
//				}else
//				{
//					if(empDto.getSalary()!=null)
//					{
//						employeeSalaryModel empSalaryModel=new employeeSalaryModel();
//						empSalaryModel.setEmployeeModel(insertedEmployee);
//						empSalaryModel.setSalary(empDto.getSalary());
//						employeeSalaryModel insertedEmployeeSalary= employeeSalaryServiceI.save(empSalaryModel);
//						if(insertedEmployeeSalary!=null)
//						{
//							returnedEmpDto.setEmployeeSalaryId(insertedEmployeeSalary.getId());
//							returnedEmpDto.setSalary(empDto.getSalary());
//						}
//					}
//				}
//				
//			}else 
//			{
//				if(empDto.getSalary()!=null)
//				{
//					employeeSalaryModel empSalaryModel=new employeeSalaryModel();
//					empSalaryModel.setEmployeeModel(insertedEmployee);
//					empSalaryModel.setSalary(empDto.getSalary());
//					employeeSalaryModel insertedEmployeeSalary= employeeSalaryServiceI.save(empSalaryModel);
//					if(insertedEmployeeSalary!=null)
//					{
//						returnedEmpDto.setEmployeeSalaryId(insertedEmployeeSalary.getId());
//						returnedEmpDto.setSalary(empDto.getSalary());
//					}
//				}
//			}
			
			List<Integer> operationsId=empDto.getOperationsId();
			for(Integer opId:operationsId)
			{
				employeeAccessesModel empAc=new employeeAccessesModel();
				empAc.setEmployeeModel(insertedEmployee);
				operationModel opModel=new operationModel();
				opModel.setId(opId);
				empAc.setOperationModel(opModel);
				employeeAccessServiceI.save(empAc);
			}
			returnedEmpDto.setOpereationsId(operationsId);
			response.setState(false);
			response.setMessage("تم الاضافة بنجاح");
			response.setDTOObject(returnedEmpDto);
		}
		return response;
	}

	
	@Override
	public employeeModel findByName(String employeeName) {
		employeeModel empModel=employeeRepository.findByName(employeeName);
		if(empModel!=null)
		{
			return empModel;
		}else 
		{
			return null;
		}
	}

	
	@Override
	public List<employeeDTO> findByJobTypeName(String jobTypeName) {
		return employeeRepository.findByJobTypeModelName(jobTypeName).stream().map(employeeDTOMapper::mapEmployeeToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<employeeDTO> findByJobTypeId(Long jobTypeId) {
		return employeeRepository.findByJobTypeModelId(jobTypeId).stream().map(employeeDTOMapper::mapEmployeeToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<employeeDTO> findBySearchCriterya(employeeDTO employeeSearch) {
		String empName=employeeSearch.getEmpName();
		String jobTypeName=employeeSearch.getJobTypeName();
		Long id=employeeSearch.getId();
		Long jobTypeId=employeeSearch.getJobTypeId();
		Integer salary=employeeSearch.getSalary();
		List<Integer> operationsId=employeeSearch.getOpereationsId();
		List<Long> fetchedEmployeesIds=new ArrayList<Long>();
		if(id!=null)
		{
			List<employeeDTO> returnList=new ArrayList<employeeDTO>();
			Optional<employeeModel> findByIdres=findById(id);
			if(findByIdres.isPresent())
			{
				returnList.add(employeeDTOMapper.mapEmployeeToDTO(findByIdres.get()));
			}
			return returnList;
		}else 
		{
			if(jobTypeId!=null)
			{
				List<employeeDTO> founded=findByJobTypeId(jobTypeId);
				for(employeeDTO fo:founded)
				{
					fetchedEmployeesIds.add(fo.getId());
				}
			}else if (jobTypeName!=null)
			{
				List<employeeDTO> founded=findByJobTypeName(jobTypeName);
				for(employeeDTO fo:founded)
				{
					fetchedEmployeesIds.add(fo.getId());
				}
			}
			
			return employeeRepository.findEmployeeModel(
					empName != null && !empName.isEmpty() ? empName : null,
				    salary !=null ? salary :null ,
				    fetchedEmployeesIds !=null && !fetchedEmployeesIds.isEmpty() ? fetchedEmployeesIds :null)
					.stream().map(employeeDTOMapper::mapEmployeeToDTO).collect(Collectors.toList());
		}
		
	}
	
	@Override
	public CustomJasperViewer<employeeDTO> employeeReportBySearch(employeeDTO empDTO,reportRequest reportRequest) throws JRException, SQLException
	{
		CustomJasperViewer<?> empK=reportViewer.mainViewerResponse(reportRequest);
		CustomJasperViewer<employeeDTO> empRet=new CustomJasperViewer<employeeDTO>();
		empRet.setHtmlContent(empK.getHtmlContent());
		empRet.setJasperViewer(empK.getJasperViewer());
		empRet.setListofReport(findBySearchCriterya(empDTO));
		empRet.setPdfContent(empK.getPdfContent());
		return empRet;
	}

}

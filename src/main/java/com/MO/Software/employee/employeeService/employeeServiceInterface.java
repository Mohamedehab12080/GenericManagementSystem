package com.MO.Software.employee.employeeService;

import java.sql.SQLException;
import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeModel;
import com.MO.Software.employee.DTO.employeeDTO;
import com.MO.Software.employee.employeeController.employeeOperationRequest;
import com.MO.Software.product.service.responseOperations;
import com.MO.Software.reportBase.CustomJasperViewer;
import com.MO.Software.reportBase.reportRequest;

import net.sf.jasperreports.engine.JRException;

public interface employeeServiceInterface extends baseServiceInterface<employeeModel, Long>{

	responseOperations<employeeDTO> insertEmployeeWithAllData(employeeOperationRequest empDto);
	employeeModel findByName(String employeeName);
	List<employeeDTO> findByJobTypeName(String jobTypeName);
	List<employeeDTO> findByJobTypeId(Long jobTypeId);
	List<employeeDTO> findBySearchCriterya(employeeDTO employeeSearch);
	CustomJasperViewer<employeeDTO> employeeReportBySearch(employeeDTO empDTO, reportRequest reportRequest)
			throws JRException, SQLException;
}

package com.MO.Software.employee.employeeReports;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.employee.DTO.employeeDTO;
import com.MO.Software.employee.employeeService.employeeServiceInterface;
import com.MO.Software.reportBase.CustomJasperViewer;
import com.MO.Software.reportBase.reportRequest;
import com.MO.Software.reportBase.reportViewer;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/employeeReports")
public class employeeReportsRestController {

	@Autowired
	private employeeServiceInterface employeeServiceI;
	
	@RequestMapping("/reportRequest")
	public ResponseEntity<?> reportRequest(@RequestBody employeeReportRequest empRepRequest) throws FileNotFoundException, JRException, SQLException 
	{
		return new ResponseEntity< >(employeeServiceI.employeeReportBySearch(empRepRequest.getEmpDTO(), empRepRequest.getReportRequest()),HttpStatus.OK);
	}

	
	public CustomJasperViewer<employeeDTO> employeeReportRequestMethod(employeeReportRequest empRepRequest) throws FileNotFoundException, JRException, SQLException 
	{
		
		return employeeServiceI.employeeReportBySearch(empRepRequest.getEmpDTO(), empRepRequest.getReportRequest());
	}
	
//	@RequestMapping("/requestWithDataSource")
//	public ResponseEntity<?> viewWithJRBeanDataSource(@RequestBody reportRequest reportRequest) throws FileNotFoundException, JRException, SQLException 
//	{
//		if(!reportRequest.getPara().isEmpty())
//		{
//			return new ResponseEntity< >(reportViewer.viewJRBeanCollectionWithParams(reportRequest.getReportFormat(),ResourceUtils.getFile("classpath:employeeReport.jrxml").getAbsolutePath(), 
//					reportRequest.getDestinationPath(),reportRequest.getFileDestinationName(), reportRequest.getPara()),HttpStatus.OK);
//		}
//		
//		else
//		{
//			return new ResponseEntity< >(reportViewer.viewDBConnection(reportRequest.getReportFormat(),ResourceUtils.getFile("classpath:employeeReport.jrxml").getAbsolutePath(), 
//					reportRequest.getDestinationPath(),reportRequest.getFileDestinationName()),HttpStatus.OK);
//		}
//	}
}

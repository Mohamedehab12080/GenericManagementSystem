package com.MO.Software.employee.employeeReports;

import com.MO.Software.employee.DTO.employeeDTO;

public class employeeReportRequest {

	private com.MO.Software.reportBase.reportRequest reportRequest;
	private employeeDTO empDTO;
	
	public com.MO.Software.reportBase.reportRequest getReportRequest() {
		return reportRequest;
	}
	public void setReportRequest(com.MO.Software.reportBase.reportRequest reportRequest) {
		this.reportRequest = reportRequest;
	}
	public employeeDTO getEmpDTO() {
		return empDTO;
	}
	public void setEmpDTO(employeeDTO empDTO) {
		this.empDTO = empDTO;
	}
	
	
	
}

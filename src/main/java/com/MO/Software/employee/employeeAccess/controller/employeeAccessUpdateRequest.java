package com.MO.Software.employee.employeeAccess.controller;

import java.util.List;

public class employeeAccessUpdateRequest {

	private List<Integer> operationsIdInsert;
	private List<Integer> operationsIdDelet;
	private Long employeeId ;
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public List<Integer> getOperationsIdInsert() {
		return operationsIdInsert;
	}
	public void setOperationsIdInsert(List<Integer> operationsIdInsert) {
		this.operationsIdInsert = operationsIdInsert;
	}
	public List<Integer> getOperationsIdDelet() {
		return operationsIdDelet;
	}
	public void setOperationsIdDelet(List<Integer> operationsIdDelet) {
		this.operationsIdDelet = operationsIdDelet;
	}
	
}

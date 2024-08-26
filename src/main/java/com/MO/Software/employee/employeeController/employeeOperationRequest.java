package com.MO.Software.employee.employeeController;

import java.util.List;

public class employeeOperationRequest {

	private String empName;
	private String jobTypeName;
	private Long jobTypeId;
	private List<Integer> operationsId;
	private String userName;
	private String password;
	private Integer salary;
	
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJobTypeName() {
		return jobTypeName;
	}
	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
	public Long getJobTypeId() {
		return jobTypeId;
	}
	public void setJobTypeId(Long jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	public List<Integer> getOperationsId() {
		return operationsId;
	}
	public void setOperationsId(List<Integer> operationsId) {
		this.operationsId = operationsId;
	}
	
}

package com.MO.Software.employee.DTO;

import java.util.List;

public class employeeDTO {

	private String empName;
	private String jobTypeName;
	private Long id;
	private Long jobTypeId;
	private Integer salary;
	private Integer remainedSalary;
	private List<Integer> opereationsId;
	
	public List<Integer> getOpereationsId() {
		return opereationsId;
	}
	public void setOpereationsId(List<Integer> opereationsId) {
		this.opereationsId = opereationsId;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getRemainedSalary() {
		return remainedSalary;
	}
	public void setRemainedSalary(Integer remainedSalary) {
		this.remainedSalary = remainedSalary;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getJobTypeId() {
		return jobTypeId;
	}
	public void setJobTypeId(Long jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	 
}

package com.MO.Software.employee;

import com.MO.Software.employee.jobType.jobTypeModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class employeeModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer salary;
    
    @ManyToOne
    @JoinColumn(name = "jobTypeModelId")
    private jobTypeModel jobTypeModel;

    
    
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public jobTypeModel getJobTypeModel() {
		return jobTypeModel;
	}

	public void setJobTypeModel(jobTypeModel jobTypeModel) {
		this.jobTypeModel = jobTypeModel;
	}
    
    


}

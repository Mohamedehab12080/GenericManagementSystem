package com.MO.Software.employee.employeeAccess;

import com.MO.Software.employee.employeeModel;
import com.MO.Software.operation.operationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class employeeAccessesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "operationModelId")
    private operationModel operationModel;

    @ManyToOne
    @JoinColumn(name = "employeeModelId")
    private employeeModel employeeModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public operationModel getOperationModel() {
		return operationModel;
	}

	public void setOperationModel(operationModel operationModel) {
		this.operationModel = operationModel;
	}

	public employeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(employeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}
    
    
}
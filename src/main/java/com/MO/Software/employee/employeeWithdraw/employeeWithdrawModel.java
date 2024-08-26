package com.MO.Software.employee.employeeWithdraw;

import java.time.LocalDateTime;


import com.MO.Software.Day.dayModel;
import com.MO.Software.employee.employeeModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class employeeWithdrawModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employeeModelId")
    private employeeModel employeeModel;

    private LocalDateTime dateTime;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "dayModelId")
    private dayModel dayModel;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public employeeModel getEmployee() {
		return employeeModel;
	}

	public void setEmployee(employeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public dayModel getDayModel() {
		return dayModel;
	}

	public void setDayModel(dayModel dayModel) {
		this.dayModel = dayModel;
	}

    
}

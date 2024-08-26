package com.MO.Software.Bill;

import java.time.LocalDateTime;

import org.hibernate.annotations.Formula;

import com.MO.Software.Bill.billType.billType;
import com.MO.Software.Day.dayModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class billModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "dayModelId")
    private dayModel dayModel;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private LocalDateTime dateTime;

    private Long customerId;
    private String customerName;

//    @Formula("(SELECT COALESCE(SUM(bp.row_total), 0) FROM bill_product_model bp WHERE bp.bill_model_id = id)")
    private Double billTotal;

    private Double billPayed;

//    @Formula("COALESCE(billTotal, 0) - COALESCE(billPayed, 0)")
    private Double billRemained;

    
    private Integer billDayCounter;
    
    @ManyToOne
    @JoinColumn(name = "billTypeId")
    private billType billType;

    private boolean returnedBill;

    
    
    
    public Integer getBillDayCounter() {
		return billDayCounter;
	}

	public void setBillDayCounter(Integer billDayCounter) {
		this.billDayCounter = billDayCounter;
	}

	public boolean isReturnedBill() {
        return returnedBill;
    }

    public void setReturnedBill(boolean returnedBill) {
        this.returnedBill = returnedBill;
    }

//    
    public Long getId() {
        return id;
    }

    public Double getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(Double billTotal) {
		this.billTotal = billTotal;
	}

	public Double getBillPayed() {
		return billPayed;
	}

	public void setBillPayed(Double billPayed) {
		this.billPayed = billPayed;
	}

	public Double getBillRemained() {
		return billRemained;
	}

	public void setBillRemained(Double billRemained) {
		this.billRemained = billRemained;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public dayModel getDayModel() {
        return dayModel;
    }

    public void setDayModel(dayModel dayModel) {
        this.dayModel = dayModel;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public billType getBillType() {
        return billType;
    }

    public void setBillType(billType billType) {
        this.billType = billType;
    }
}

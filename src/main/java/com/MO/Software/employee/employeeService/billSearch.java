package com.MO.Software.employee.employeeService;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class billSearch {
    
	private Long id;
    private String employeeName;
    private Long employeeId;
    private Integer billTypeId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Integer month;
    private Integer year;
    private Integer billTotal;
    private Boolean returnedBill;    
    

    public Long getId() {
        return id;
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

    public Integer getBillTypeId() {
        return billTypeId;
    }

    public void setBillTypeId(Integer billTypeId) {
        this.billTypeId = billTypeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(Integer billTotal) {
        this.billTotal = billTotal;
    }

    public Boolean getReturnedBill() {
        return returnedBill;
    }

    public void setReturnedBill(Boolean returnedBill) {
        this.returnedBill = returnedBill;
    }
}

package com.MO.Software.Day.DTO;

import java.time.LocalDate;
import java.util.Set;

import com.MO.Software.Bill.DTO.billDTO;

public class dayDTO {

	private Long id;
	private LocalDate date;
	private Double totalBillsCost;
	private Double totalBillsBuyCost;
	private Set<billDTO> bills;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getTotalBillsCost() {
		return totalBillsCost;
	}
	public void setTotalBillsCost(Double totalBillsCost) {
		this.totalBillsCost = totalBillsCost;
	}
	public Double getTotalBillsBuyCost() {
		return totalBillsBuyCost;
	}
	public void setTotalBillsBuyCost(Double totalBillsBuyCost) {
		this.totalBillsBuyCost = totalBillsBuyCost;
	}
	public Set<billDTO> getBills() {
		return bills;
	}
	public void setBills(Set<billDTO> bills) {
		this.bills = bills;
	}
	
}

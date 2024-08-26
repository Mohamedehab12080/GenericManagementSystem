package com.MO.Software.Day;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.Formula;

import com.MO.Software.Bill.billModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class dayModel {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate date;
	    
	    
	    @OneToMany(mappedBy = "dayModel")
	    private Set<billModel> bills;
	    
	    @Formula("(SELECT SUM(b.billTotal) FROM bill_model b WHERE b.day_model_id = id)")
	    private Double totalBillsCost;

	    @Formula("(SELECT SUM(bp.product_buy_price * bp.quantity) " +
                 "FROM bill_product_model bp " +
                 "JOIN bill_model b ON bp.bill_model_id = b.id " +
                 "WHERE b.day_model_id = id)")
	    private Double totalBillsBuyCost;
	    
	    
		public Set<billModel> getBills() {
			return bills;
		}
		public void setBills(Set<billModel> bills) {
			this.bills = bills;
		}
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

}

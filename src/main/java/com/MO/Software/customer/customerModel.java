package com.MO.Software.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class customerModel {
		  @Id
		  @GeneratedValue(strategy = GenerationType.IDENTITY)
		  private Long id;

	    @Column(nullable = false)
	    private String name;
	
	    private String phone;	
	    private String address;
		
	    private Double remained;
	    
	    
	    public Double getRemained() {
			return remained;
		}
		public void setRemained(Double remained) {
			this.remained = remained;
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
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	    
	    

}

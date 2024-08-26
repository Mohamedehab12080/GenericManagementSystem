package com.MO.Software.customer.customerPayment;

import java.time.LocalDateTime;

import com.MO.Software.Day.dayModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CustomerPaymentBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String customerName;
	private Long customerId;
	private Double remainedBeforePayment;
	private Double payed;
	private Double remainedAfterPayment;
	
	@ManyToOne
    @JoinColumn(name = "dayModelId")
    private dayModel dayModel;
	
	 @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
	 private LocalDateTime dateTime;
	 
	 private String note;
	 
}

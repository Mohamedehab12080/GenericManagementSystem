package com.MO.Software.DailyCosts;

import java.time.LocalDateTime;

import com.MO.Software.DailyCosts.costsName.costsNameModel;
import com.MO.Software.Day.dayModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class dailyCostsModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "costsNameModelId")
    private costsNameModel costsNameModel;

    @ManyToOne
    @JoinColumn(name = "dayModelId")
    private dayModel dayModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public costsNameModel getCostsNameModel() {
		return costsNameModel;
	}

	public void setCostsNameModel(costsNameModel costsNameModel) {
		this.costsNameModel = costsNameModel;
	}

	public dayModel getDayModel() {
		return dayModel;
	}

	public void setDayModel(dayModel dayModel) {
		this.dayModel = dayModel;
	}

   
}
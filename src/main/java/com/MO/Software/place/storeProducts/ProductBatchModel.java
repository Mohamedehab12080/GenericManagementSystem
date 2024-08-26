package com.MO.Software.place.storeProducts;

import java.time.LocalDate;

import com.MO.Software.place.PlaceModel;
import com.MO.Software.product.productModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductBatchModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double quantity;
	
	private LocalDate receivedDate;
	private LocalDate expirDate;
	
	@ManyToOne
    @JoinColumn(name = "placeModelId")
    private PlaceModel placeModel;
	
	@ManyToOne
    @JoinColumn(name = "productModelId")
    private productModel productModel;

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public LocalDate getExpirDate() {
		return expirDate;
	}

	public void setExpirDate(LocalDate expirDate) {
		this.expirDate = expirDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public PlaceModel getPlaceModel() {
		return placeModel;
	}

	public void setPlaceModel(PlaceModel placeModel) {
		this.placeModel = placeModel;
	}

	public productModel getProductModel() {
		return productModel;
	}

	public void setProductModel(productModel productModel) {
		this.productModel = productModel;
	}
	
	
}

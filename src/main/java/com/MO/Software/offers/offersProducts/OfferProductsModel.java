package com.MO.Software.offers.offersProducts;

import com.MO.Software.offers.OfferModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OfferProductsModel {

	 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String productName;
		private Long productId;
		private Double quantity;
		
		@ManyToOne
		@JoinColumn(name="OfferModelId")
		private OfferModel offerModel;
		
		public Double getQuantity() {
			return quantity;
		}
		public void setQuantity(Double quantity) {
			this.quantity = quantity;
		}
		public OfferModel getOfferModel() {
			return offerModel;
		}
		public void setOfferModel(OfferModel offerModel) {
			this.offerModel = offerModel;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public Long getProductId() {
			return productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		
}

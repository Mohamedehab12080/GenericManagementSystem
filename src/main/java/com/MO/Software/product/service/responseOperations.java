package com.MO.Software.product.service;

import java.util.ArrayList;
import java.util.List;


public class responseOperations <T>{

	private String message;
	private boolean state;
	private List<T> ListOfDTO=new ArrayList<T>();
	private T DTOObject;
	private Double Total;
	
	
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public List<T> getListOfDTO() {
		return ListOfDTO;
	}
	public void setListOfDTO(List<T> listOfDTO) {
		ListOfDTO = listOfDTO;
	}
	public T getDTOObject() {
		return DTOObject;
	}
	public void setDTOObject(T dTOObject) {
		DTOObject = dTOObject;
	}
	
	
}

package com.MO.Software.operation;

import com.MO.Software.operation.pages.pageModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class operationModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String note;
    
    @ManyToOne
    @JoinColumn(name="pageModelId")
    private pageModel pageModel;
    
	public pageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(pageModel pageModel) {
		this.pageModel = pageModel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

    
}

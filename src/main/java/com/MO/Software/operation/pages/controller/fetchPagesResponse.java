package com.MO.Software.operation.pages.controller;

import java.util.List;

import com.MO.Software.operation.DTO.operationDTO;

public class fetchPagesResponse {

	private Integer pageId;
	private String pageName;
	private List<operationDTO> operationsList;
	
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public List<operationDTO> getOperationsList() {
		return operationsList;
	}
	public void setOperationsList(List<operationDTO> operationsList) {
		this.operationsList = operationsList;
	}
	
	
	
}

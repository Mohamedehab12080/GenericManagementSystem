package com.MO.Software.reportBase;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class reportRequest {

	private String reportPath;
	private String reportFormat;
	private String fileDestinationName;
	private String destinationPath;
	private JRBeanCollectionDataSource dataSource;
	private HashMap<String,Object> para;
	
	
	
	public String getReportPath() {
		return reportPath;
	}
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	public HashMap<String, Object> getPara() {
		return para;
	}
	public void setPara(HashMap<String, Object> para) {
		this.para = para;
	}
	public String getDestinationPath() {
		return destinationPath;
	}
	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}
	public JRBeanCollectionDataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(JRBeanCollectionDataSource dataSource) {
		this.dataSource = dataSource;
	}
	public String getReportFormat() {
		return reportFormat;
	}
	public void setReportFormat(String reportFormat) {
		this.reportFormat = reportFormat;
	}
	public String getFileDestinationName() {
		return fileDestinationName;
	}
	public void setFileDestinationName(String fileDestinationName) {
		this.fileDestinationName = fileDestinationName;
	}
	
}

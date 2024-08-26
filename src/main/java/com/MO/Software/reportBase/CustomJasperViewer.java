package com.MO.Software.reportBase;
import java.util.List;

import net.sf.jasperreports.view.JasperViewer;

public class CustomJasperViewer <T>{
    
	private String htmlContent;
    private byte[] pdfContent;
    private JasperViewer JasperViewer;
    private List<T> listofReport;
    
    
    public List<T> getListofReport() {
		return listofReport;
	}

	public void setListofReport(List<T> listofReport) {
		this.listofReport = listofReport;
	}

	public JasperViewer getJasperViewer() {
		return JasperViewer;
	}

	public void setJasperViewer(JasperViewer jasperViewer) {
		JasperViewer = jasperViewer;
	}

	public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

	public byte[] getPdfContent() {
		return pdfContent;
	}

	public void setPdfContent(byte[] pdfContent) {
		this.pdfContent = pdfContent;
	}
    
    
}
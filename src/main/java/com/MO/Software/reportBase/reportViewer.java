package com.MO.Software.reportBase;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.connectionService.ConnectionService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.view.JasperViewer;


@Service
public class reportViewer 
{
	
	@Autowired
	private ConnectionService connectionService;
	
//    public JasperViewer viewWithDBConnection(String fileName, HashMap<String, Object> para) throws SQLException
//    {
//        Connection con=null;
//        try
//        {
//            con= connectionService.getConnection();
//            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
//            JasperViewer viewer = new JasperViewer(print);
//            return viewer;
//        } 
//        catch (JRException jRException)
//        {
//           JOptionPane.showMessageDialog(null, jRException);
//           return null;
//        }
//        
//    }
//       
    
    public JasperViewer viewTableDataSource(DefaultTableModel JRModel,String reportSource)
    {
        try
        {
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            JasperPrint print = JasperFillManager.fillReport(jr, null, new JRTableModelDataSource(JRModel));
            JasperViewer viewer = new JasperViewer(print,false);
            return viewer;
        } 
        catch (JRException jRException)
        {
           JOptionPane.showMessageDialog(null, jRException);
           return null;
        }
        
    }
    
    public JasperViewer viewJRBeanCollectionWithParams(
    		String reportFormat,
    		JRBeanCollectionDataSource dataSource,
    		String filePath,
    		String destinationPath,
    		String fileDestinationName,
    		HashMap<String, Object> para) throws JRException
    {
    	JasperReport jsReport=JasperCompileManager.compileReport(filePath);
		JasperPrint print=JasperFillManager.fillReport(jsReport,para,dataSource);

    	if(reportFormat.equalsIgnoreCase("Html"))
    	{
    		JasperExportManager.exportReportToHtmlFile(print, destinationPath+""+fileDestinationName+".html");
    		return null;
    	}else if(reportFormat.equalsIgnoreCase("pdf"))
    	{
    		JasperExportManager.exportReportToPdfFile(print, destinationPath+""+fileDestinationName+".pdf");
    		return null;
    	}else if(reportFormat.equalsIgnoreCase("printer"))
    	{
            JasperPrintManager.printReport(print, false);
            return null;
    	}else
    	{
    		 JasperViewer viewer = new JasperViewer(print);
           return viewer;
    	}
    }
    
    /**
     * 
     * @param print
     * @return String of Html
     */
    private static String generateHtmlContent(JasperPrint print) {
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(print));
        
        StringWriter stringWriter = new StringWriter();
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(stringWriter));
        
        try {
            exporter.exportReport();
        } catch (JRException e) {
            e.printStackTrace();
            return "<html><body>Error generating report</body></html>";
        }
        
        return stringWriter.toString();
    }
     
    /**
     * 
     * @param print
     * @return byte array of pdf file
     */
    private byte[] generatePdfContent(JasperPrint print) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            JasperExportManager.exportReportToPdfStream(print, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
   
    /**
     * 
     * @param reportFormat
     * @param filePath
     * @param destinationPath
     * @param fileDestinationName
     * @param para
     * @param dataSource
     * @return customJasperViewer which contains String of html content or byte[] of pdf content and a jasperViewer which contains the content pane
     * @throws JRException
     * @throws SQLException
     */
    public CustomJasperViewer<?> mainViewerResponse(reportRequest request) throws JRException, SQLException
    {
    	JasperReport jsReport=JasperCompileManager.compileReport(request.getReportPath());
    	JasperPrint print;
        if(request.getDataSource()==null)
        {
        	Connection dataSourceCon=connectionService.getConnection();
        	print=JasperFillManager.fillReport(jsReport,request.getPara(),dataSourceCon);

        }else
        {
        	print=JasperFillManager.fillReport(jsReport,request.getPara(),request.getDataSource());
        }

    	if(request.getReportFormat().equalsIgnoreCase("Html"))
    	{
    		if(request.getDestinationPath()!=null && request.getFileDestinationName()!=null)
    		{
    			JasperExportManager.exportReportToHtmlFile(print, request.getDestinationPath()+""+request.getFileDestinationName()+".html");
    		}
    		
    		String htmlContent = generateHtmlContent(print);
    		JasperViewer viewer = new JasperViewer(print,false);

            return new CustomJasperViewer < >() {
                {
                    setHtmlContent(htmlContent);
                    setJasperViewer(viewer);
                }
            };
    	}else if(request.getReportFormat().equalsIgnoreCase("pdf"))
    	{

    		if(request.getDestinationPath()!=null && request.getFileDestinationName()!=null)
    		{
        		JasperExportManager.exportReportToPdfFile(print, request.getDestinationPath()+""+request.getFileDestinationName()+".pdf");
    		}
    		byte[] pdfContent = generatePdfContent(print);
    		JasperViewer viewer = new JasperViewer(print,false);
    		return new CustomJasperViewer< >() {
                {
                    setPdfContent(pdfContent);
                    setJasperViewer(viewer);
                }
            };
    	}else if(request.getReportFormat().equalsIgnoreCase("printer"))
    	{
            JasperPrintManager.printReport(print, false);
            return null;
    	}else
    	{
    		 JasperViewer viewer = new JasperViewer(print);
    		 return new CustomJasperViewer< >() {
                 {
                     setJasperViewer(viewer);
                 }
             };
    	}
    }
    
    
    public JasperViewer viewDBConnection(
    		String reportFormat,
    		String filePath,
    		String destinationPath,
    		String fileDestinationName) throws JRException, SQLException
    {
		Connection dataSource=connectionService.getConnection();
    	JasperReport jsReport=JasperCompileManager.compileReport(filePath);
		JasperPrint print=JasperFillManager.fillReport(jsReport,null,dataSource);
    	if(reportFormat.equalsIgnoreCase("Html"))
    	{
    		JasperExportManager.exportReportToHtmlFile(print, destinationPath+"\\"+fileDestinationName+".html");
            return null;

    	}else if(reportFormat.equalsIgnoreCase("pdf"))
    	{
    		JasperExportManager.exportReportToPdfFile(print, destinationPath+"\\"+fileDestinationName+".pdf");
            return null;

    	}else if(reportFormat.equalsIgnoreCase("printer"))
    	{
            JasperPrintManager.printReport(print, false);
            return null;
    	}else
    	{
    		 JasperViewer viewer = new JasperViewer(print);
    		 return viewer;
    	}
    }
    
    public JasperViewer viewJRBeanCollection(
    		String reportFormat,
    		JRBeanCollectionDataSource dataSource,
    		String filePath,
    		String destinationPath,String fileDestinationName) throws JRException
    {
    	JasperReport jsReport=JasperCompileManager.compileReport(filePath);
		JasperPrint print=JasperFillManager.fillReport(jsReport,null,dataSource);
    	if(reportFormat.equalsIgnoreCase("Html"))
    	{
    		JasperExportManager.exportReportToHtmlFile(print, destinationPath+"\\"+fileDestinationName+".html");
            return null;

    	}else if(reportFormat.equalsIgnoreCase("pdf"))
    	{
    		JasperExportManager.exportReportToPdfFile(print, destinationPath+"\\"+fileDestinationName+".pdf");
            return null;

    	}else if(reportFormat.equalsIgnoreCase("printer"))
    	{
            JasperPrintManager.printReport(print, false);
            return null;
    	}else
    	{
    		 JasperViewer viewer = new JasperViewer(print);
    		 return viewer;
    	}
    }
    
     public JasperViewer viewTableDataSourceWithParameters(DefaultTableModel JRModel,String reportSource,
    		 HashMap<String, Object> para)
    {
        try
        {
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            JasperPrint print = JasperFillManager.fillReport(jr, para, new JRTableModelDataSource(JRModel));
            JasperViewer viewer = new JasperViewer(print,false);
            return viewer;

        } 
        catch (JRException jRException)
        {
           JOptionPane.showMessageDialog(null, jRException);
           return null;
        }
        
    }
     
    public void print() { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

package com.MO.Software.product.productController.ProductReports;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.product.service.productServiceImpl;
import com.MO.Software.product.service.productServiceInterface;
import com.MO.Software.reportBase.CustomJasperViewer;
import com.MO.Software.reportBase.reportRequest;
import com.MO.Software.reportBase.reportViewer;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/productReports")
public class ProductReportsController {

	@Autowired
	private  productServiceInterface productServiceI;
	
	@Autowired
	private reportViewer reportViewerService;
	
	@RequestMapping("/productsSummaryReport")
	public ResponseEntity<?> productsReportNotDirectlySqlRequest(@RequestBody ReportRequestProducts reportRequestProducts) throws JRException, SQLException
	{
		reportRequest reportReq=reportRequestProducts.getReportRequest();
		reportReq.setDataSource(new JRBeanCollectionDataSource(productServiceI.productReportwithBillSearch(reportRequestProducts.getBillSearch())));
		return new ResponseEntity< >(reportViewerService.mainViewerResponse(reportReq),HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param reportRequestProducts
	 * @return customJasperViewer which contains htmlContent or byte[] pdfContent or JasperViewer object which contians content pane
	 * @throws JRException
	 * @throws SQLException
	 */
	public CustomJasperViewer productsReportRequestNotDirectlySqlMethod(@RequestBody ReportRequestProducts reportRequestProducts) throws JRException, SQLException
	{
		reportRequest reportReq=reportRequestProducts.getReportRequest();
		reportReq.setDataSource(new JRBeanCollectionDataSource(productServiceI.productReportwithBillSearch(reportRequestProducts.getBillSearch())));
		return reportViewerService.mainViewerResponse(reportReq);
	}
}

package com.MO.Software.category.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.category.Service.categoryServiceInterface;
import com.MO.Software.product.productController.ProductReports.ReportRequestProducts;
import com.MO.Software.reportBase.CustomJasperViewer;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

	@Autowired
	private categoryServiceInterface categoryServiceI;
	
	@RequestMapping("/productsReport1/{categoryId}")
	public ResponseEntity<?> productsReportsWithCategoryId(@PathVariable("categoryId") Long categoryId,@RequestBody ReportRequestProducts reportRequestProducts) throws JRException, SQLException
	{
		return new ResponseEntity< >(categoryServiceI.categoryProductsReport(categoryId, reportRequestProducts),HttpStatus.OK);
	}
	
	public CustomJasperViewer productsReportsWithCategoryIdMehod(Long categoryId,ReportRequestProducts reportRequestProducts) throws JRException, SQLException
	{
		return categoryServiceI.categoryProductsReport(categoryId, reportRequestProducts);
	}
	
	@RequestMapping("/productsReport2")
	public ResponseEntity<?> productsReportsWithBillSearch(@RequestBody ReportRequestProducts reportRequestProducts) throws JRException, SQLException
	{
		return new ResponseEntity< >(categoryServiceI.categoriesStructureProductsReport(reportRequestProducts),HttpStatus.OK);
	}
	
	public CustomJasperViewer productsReportsWithBillSearchMethod(ReportRequestProducts reportRequestProducts) throws JRException, SQLException
	{
		return categoryServiceI.categoriesStructureProductsReport(reportRequestProducts);
	} 
	
	
}

package com.MO.Software.category.Service;

import java.sql.SQLException;
import java.util.List;


import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.category.categoryModel;
import com.MO.Software.category.DTO.categoryProductsResponse;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.productController.ProductReports.ReportRequestProducts;
import com.MO.Software.reportBase.CustomJasperViewer;

import net.sf.jasperreports.engine.JRException;

public interface categoryServiceInterface extends baseServiceInterface<categoryModel,Long>{

	

	CustomJasperViewer categoriesStructureProductsReport(ReportRequestProducts reportRequestProducts) throws JRException, SQLException;

	CustomJasperViewer categoryProductsReport(Long categoryId, ReportRequestProducts reportRequestProducts) throws JRException, SQLException;

}

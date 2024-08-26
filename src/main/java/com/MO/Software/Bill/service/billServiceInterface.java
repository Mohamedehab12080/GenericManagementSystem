package com.MO.Software.Bill.service;

import java.sql.SQLException;
import java.util.List;

import com.MO.Software.Bill.billModel;
import com.MO.Software.Bill.DTO.billDTO;
import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.productController.ProductReports.ReportRequestProducts;
import com.MO.Software.product.service.responseOperations;
import com.MO.Software.reportBase.CustomJasperViewer;

import net.sf.jasperreports.engine.JRException;

public interface billServiceInterface extends baseServiceInterface<billModel,Long>{

	responseOperations<billDTO> saveBill(billDTO bill);
	responseOperations<billDTO> updateBill(billDTO bill);
	List<billDTO> findAllBillsReturned();
//	List<billDTO> findAllBillsForSpecificDate();
	responseOperations<billDTO> findBySearchCriteria(billSearch billSearch);
	List<Long> findBillIdsBySearch(billSearch billSearch);
	CustomJasperViewer billsReport(ReportRequestProducts reportRequestForbillsReport) throws JRException, SQLException;
	int countBillsByDay(Long dayId);
}

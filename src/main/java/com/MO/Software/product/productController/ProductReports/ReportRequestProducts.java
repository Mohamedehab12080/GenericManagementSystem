package com.MO.Software.product.productController.ProductReports;

import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.reportBase.reportRequest;

public class ReportRequestProducts  {

	private reportRequest reportRequest;
	private billSearch billSearch;

	
	public ReportRequestProducts() {}
	public ReportRequestProducts(
			reportRequest reportRequest,
			billSearch billSearch) {
		super();
		this.reportRequest = reportRequest;
		this.billSearch = billSearch;
	}

	public reportRequest getReportRequest() {
		return reportRequest;
	}

	public void setReportRequest(reportRequest reportRequest) {
		this.reportRequest = reportRequest;
	}

	public billSearch getBillSearch() {
		return billSearch;
	}

	public void setBillSearch(billSearch billSearch) {
		this.billSearch = billSearch;
	}
	
}

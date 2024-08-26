package com.MO.Software.category.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.Bill.billProducts.service.billProductServiceInterface;
import com.MO.Software.Bill.service.billServiceInterface;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.category.categoryModel;
import com.MO.Software.category.DTO.categoryProductsResponse;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.productController.ProductReports.ReportRequestProducts;
import com.MO.Software.product.service.productServiceInterface;
import com.MO.Software.reportBase.CustomJasperViewer;
import com.MO.Software.reportBase.reportRequest;
import com.MO.Software.reportBase.reportViewer;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class categoryServiceImpl 
extends baseServiceImpl<categoryModel, Long> 
implements categoryServiceInterface{

	@Autowired
	private categoryRepository categoryRepository;
	@Autowired
	private billProductServiceInterface billProductServiceI;
	@Autowired
	private billServiceInterface billServiceI;

	@Autowired
	private reportViewer reportViewerService;
	
	@Autowired
	private productServiceInterface productServiceI;
	@Override
	protected baseRepository<categoryModel, Long> getRepository() {
		return categoryRepository;
	}

	@Override
	public CustomJasperViewer categoryProductsReport(Long categoryId,ReportRequestProducts reportRequestProducts) throws JRException, SQLException {
		List<ProductSummaryDTO> productSummaryDTOList= billProductServiceI.findByCategoryId(
				categoryId,
				billServiceI.findBillIdsBySearch(reportRequestProducts.getBillSearch()));
		Double MainTotalSells=0.0;
		String categoryName="";
		for(ProductSummaryDTO ProductSummaryDTO:productSummaryDTOList)
		{
			MainTotalSells+=ProductSummaryDTO.getTotalRowTotal();
			categoryName=ProductSummaryDTO.getCategoryName();
		}
		List<categoryProductsResponse> listCatg=new ArrayList<categoryProductsResponse>();
		listCatg.add(new categoryProductsResponse(categoryName, categoryId, MainTotalSells, productSummaryDTOList));
		reportRequest reportReq=reportRequestProducts.getReportRequest();
		reportReq.setDataSource(new JRBeanCollectionDataSource(listCatg));
		return reportViewerService.mainViewerResponse(reportReq) ;
	}
	
	@Override
	public CustomJasperViewer categoriesStructureProductsReport(ReportRequestProducts reportRequestProducts) throws JRException, SQLException {
		List<ProductSummaryDTO> productSummaryDTOList= productServiceI.productReportwithBillSearch(reportRequestProducts.getBillSearch());
		Double MainTotalSells=0.0;
		String categoryName="";

		if(productSummaryDTOList!=null)
		{
			categoryName=productSummaryDTOList.get(0).getCategoryName();
		}
		
		List<categoryProductsResponse> categoryProductsList=new ArrayList<categoryProductsResponse>();
		
		for(ProductSummaryDTO ProductSummaryDTO:productSummaryDTOList)
		{
			MainTotalSells+=ProductSummaryDTO.getTotalRowTotal();
			List<ProductSummaryDTO> prodSum=new ArrayList<ProductSummaryDTO>();
			categoryProductsResponse categoryProductsResponse=null;
			if(ProductSummaryDTO.getCategoryName()==categoryName)
			{
				prodSum.add(ProductSummaryDTO);
			}else
			{
				Double mainTotalForEachCategory=0.0;
				categoryName=ProductSummaryDTO.getCategoryName();
				for(ProductSummaryDTO productSummarySub:prodSum)
				{
					mainTotalForEachCategory+=productSummarySub.getTotalRowTotal();
				}
				categoryProductsResponse=new categoryProductsResponse(
						categoryName,
						ProductSummaryDTO.getCategoryId(),
						mainTotalForEachCategory,
						prodSum);
			}
			if(categoryProductsResponse !=null)
			{
				categoryProductsList.add(categoryProductsResponse);
			}
		}
		reportRequest reportReq=reportRequestProducts.getReportRequest();
		reportReq.setDataSource(new JRBeanCollectionDataSource(categoryProductsList));
		return reportViewerService.mainViewerResponse(reportReq) ;
	}

}

package com.MO.Software.Bill.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billModel;
import com.MO.Software.Bill.DTO.billDTO;
import com.MO.Software.Bill.DTO.billDTOMapper;
import com.MO.Software.Bill.billProducts.billProductModel;
import com.MO.Software.Bill.billProducts.DTO.billProductDTO;
import com.MO.Software.Bill.billProducts.DTO.billProductDTOMapper;
import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductConstantsAdds;
import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductsConstantsAddsService.BillProductsConstantsAddsServiceInterface;
import com.MO.Software.Bill.billProducts.service.billProductServiceInterface;
import com.MO.Software.Bill.billType.billType;
import com.MO.Software.Bill.billType.service.billTypeServiceInterface;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.productModel;
import com.MO.Software.product.DTO.productDTO;
import com.MO.Software.product.DTO.productDTOMapper;
import com.MO.Software.product.productController.ProductReports.ReportRequestProducts;
import com.MO.Software.product.service.productServiceImpl;
import com.MO.Software.product.service.productServiceInterface;
import com.MO.Software.product.service.responseOperations;
import com.MO.Software.reportBase.CustomJasperViewer;
import com.MO.Software.reportBase.reportRequest;
import com.MO.Software.reportBase.reportViewer;

import groovy.lang.Lazy;
import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class billServiceImpl extends baseServiceImpl<billModel,Long>
implements billServiceInterface{

	@Autowired
	private billRepository billRepository;
	
	@Autowired
	private billProductServiceInterface billProductServiceI;
	
	@Lazy
	@Autowired
	private productServiceImpl productServiceI; 
	
	@Autowired
	private billTypeServiceInterface billTypeServiceI;
	
	@Autowired
	private BillProductsConstantsAddsServiceInterface BillProductsConstantsAddsServiceI;
	
	@Autowired
	private reportViewer reportViewerService;
	
	@Override
	protected baseRepository<billModel, Long> getRepository() {
		return billRepository;
	}

	
//	@Transactional
//	@Override
//	public responseOperations<billDTO> saveBill(billDTO bill) {
//		
//	    responseOperations<billDTO> response = new responseOperations<>();
//	    if(bill.getBillTypeId()==null && ( bill.getBillTypeName()!=null))
//	    {
//	    	billType billTypeModel=billTypeServiceI.findByName(bill.getBillTypeName());
//	    	if(billTypeModel!=null)
//	    	{
//	    		bill.setBillTypeId(billTypeModel.getId());
//	    		bill.setBillTypeName(billTypeModel.getName());
//	    	}else
//	    	{
//	    		billType billTypeModelInsert=new billType();
//	    		billTypeModelInsert.setName(bill.getBillTypeName());
//	    		billTypeModel=billTypeServiceI.save(billTypeModelInsert);
//	    		bill.setBillTypeId(billTypeModel.getId());
//	    	}
//	    }else
//	    {
//    		bill.setBillTypeId(bill.getBillTypeId());
//	    }
//	    
//	    billModel billModel = billDTOMapper.mapDTOToBillModel(bill);
//	    billModel insertedBillModel = billRepository.save(billModel);
//	    if (insertedBillModel == null) {
//	        response.setMessage("لم يتم تسجيل الفاتورة");
//	        response.setState(false);
//	        return response;
//	    }
//
//	    List<billProductDTO> billProductDTOsInserted = new ArrayList<>();
//	    bill.setId(insertedBillModel.getId());
//
//	    for (billProductDTO billProductDTO : bill.getBillProductModelList()) {
//	        Long productId = billProductDTO.getId();
//	        Optional<productModel> prodModelOpt = productServiceI.findById(productId);
//	        
//	        if (!prodModelOpt.isPresent()) {
//	            response.setMessage("لم يتم العثور على المنتج مع المعرف: " + productId);
//	            response.setState(false);
//	            return response;
//	        }
//
//	        productModel prodModel = prodModelOpt.get();
//
//	        if (billProductDTO.getProductSellPrice() != null && billProductDTO.isChangeSellPrice()) {
//	            prodModel.setSellPrice(billProductDTO.getProductSellPrice());
//	            productDTO updatedProductDTO = productServiceI.updateProductAllData(
//	                prodModel.getId(), productDTOMapper.mapProductToDTO(prodModel)
//	            ).getDTOObject();
//	            prodModel = productDTOMapper.mapDTOToProductModel(updatedProductDTO);
//	        }
//
//	        billProductDTO.setProductBuyPrice(prodModel.getBuyPrice());
//	        billProductDTO.setProductSellPrice(
//	            billProductDTO.getProductSellPrice() != null ? billProductDTO.getProductSellPrice() : prodModel.getSellPrice()
//	        );
//
//	        billProductModel billProdModel = billProductDTOMapper.mapDTOToBillProduct(billProductDTO);
//	        billProdModel.setBillModel(insertedBillModel); 
//	        billProductModel insertedBillProductModel = billProductServiceI.save(billProdModel);
//
//	        billProductDTO.setId(insertedBillProductModel.getId());
//	        billProductDTO.setRowTotal(insertedBillProductModel.getRowTotal());
//	        billProductDTOsInserted.add(billProductDTO);
//	    }
//
//	    bill.setBillProductModelList(billProductDTOsInserted);
//
//	    response.setMessage("تم تسجيل الفاتورة");
//	    response.setState(true);
//	    response.setDTOObject(bill);
//
//	    return response;
//	}

//	@Transactional
//	@Override
//	public responseOperations<billDTO> saveBill(billDTO bill) {
//
//	    responseOperations<billDTO> response = new responseOperations<>();
//
//	    // Handle bill type
//	    if (bill.getBillTypeId() == null && bill.getBillTypeName() != null) {
//	        billType billTypeModel = billTypeServiceI.findByName(bill.getBillTypeName());
//	        if (billTypeModel != null) {
//	            bill.setBillTypeId(billTypeModel.getId());
//	            bill.setBillTypeName(billTypeModel.getName());
//	        } else {
//	            billType billTypeModelInsert = new billType();
//	            billTypeModelInsert.setName(bill.getBillTypeName());
//	            billTypeModel = billTypeServiceI.save(billTypeModelInsert);
//	            bill.setBillTypeId(billTypeModel.getId());
//	        }
//	    } else if (bill.getBillTypeId() != null) {
//	        // Ensure BillType exists if BillTypeId is provided
//	        Optional<billType> existingBillType = billTypeServiceI.findById(bill.getBillTypeId());
//	        if (!existingBillType.isPresent()) {
//	            response.setMessage("Bill Type with ID " + bill.getBillTypeId() + " not found.");
//	            response.setState(false);
//	            return response;
//	        }
//	    }
//
//	    billModel billModel = billDTOMapper.mapDTOToBillModel(bill);
//	    billModel insertedBillModel = billRepository.save(billModel);
//	    if (insertedBillModel == null) {
//	        response.setMessage("لم يتم تسجيل الفاتورة");
//	        response.setState(false);
//	        return response;
//	    }
//
//	    List<billProductDTO> billProductDTOsInserted = new ArrayList<>();
//	    bill.setId(insertedBillModel.getId());
//
//	    // Process bill products
//	    for (billProductDTO billProductDTO : bill.getBillProductModelList()) {
//	        Long productId = billProductDTO.getId();
//	        
//	        if (productId == null) {
//	            response.setMessage("Product ID must not be null.");
//	            response.setState(false);
//	            return response;
//	        }
//	        
//	        Optional<productModel> prodModelOpt = productServiceI.findById(productId);
//
//	        if (!prodModelOpt.isPresent()) {
//	            response.setMessage("لم يتم العثور على المنتج مع المعرف: " + productId);
//	            response.setState(false);
//	            return response;
//	        }
//
//	        productModel prodModel = prodModelOpt.get();
//
//	        if (billProductDTO.getProductSellPrice() != null && billProductDTO.isChangeSellPrice()) {
//	            prodModel.setSellPrice(billProductDTO.getProductSellPrice());
//	            productDTO updatedProductDTO = productServiceI.updateProductAllData(
//	                prodModel.getId(), productDTOMapper.mapProductToDTO(prodModel)
//	            ).getDTOObject();
//	            prodModel = productDTOMapper.mapDTOToProductModel(updatedProductDTO);
//	        }
//
//	        billProductDTO.setProductBuyPrice(prodModel.getBuyPrice());
//	        billProductDTO.setProductSellPrice(
//	            billProductDTO.getProductSellPrice() != null ? billProductDTO.getProductSellPrice() : prodModel.getSellPrice()
//	        );
//
//	        billProductModel billProdModel = billProductDTOMapper.mapDTOToBillProduct(billProductDTO);
//	        billProdModel.setBillModel(insertedBillModel); 
//	        billProductModel insertedBillProductModel = billProductServiceI.save(billProdModel);
//
//	        billProductDTO.setId(insertedBillProductModel.getId());
//	        billProductDTO.setRowTotal(insertedBillProductModel.getRowTotal());
//	        billProductDTOsInserted.add(billProductDTO);
//	    }
//
//	    bill.setBillProductModelList(billProductDTOsInserted);
//
//	    response.setMessage("تم تسجيل الفاتورة");
//	    response.setState(true);
//	    response.setDTOObject(bill);
//
//	    return response;
//	}
	@Transactional
	@Override
	public responseOperations<billDTO> saveBill(billDTO bill) {
	    responseOperations<billDTO> response = new responseOperations<>();

	    int currentCounter=countBillsByDay(bill.getDayId());
	    bill.setBillDayCounter(currentCounter+1);
	    // Handle bill type
	    if (bill.getBillTypeId() == null && bill.getBillTypeName() != null) {
	        billType billTypeModel = billTypeServiceI.findByName(bill.getBillTypeName());
	        if (billTypeModel != null) {
	            bill.setBillTypeId(billTypeModel.getId());
	            bill.setBillTypeName(billTypeModel.getName());
	        } else {
	            billType billTypeModelInsert = new billType();
	            billTypeModelInsert.setName(bill.getBillTypeName());
	            billTypeModel = billTypeServiceI.save(billTypeModelInsert);
	            bill.setBillTypeId(billTypeModel.getId());
	        }
	    }

	    // Save the bill
	    billModel billModel = billDTOMapper.mapDTOToBillModel(bill);
	    billModel insertedBillModel = billRepository.save(billModel);
	    if (insertedBillModel == null) {
	        response.setMessage("لم يتم تسجيل الفاتورة");
	        response.setState(false);
	        return response;
	    }

	    List<billProductDTO> billProductDTOsInserted = new ArrayList<>();
	    bill.setId(insertedBillModel.getId());

	    // Process bill products
	    for (billProductDTO billProductDTO : bill.getBillProductModelList()) {
	        Long productId = billProductDTO.getProductId();
	        
	        if (productId == null) {
	            response.setMessage("Product ID must not be null.");
	            response.setState(false);
	            return response;
	        }

	        Optional<productModel> prodModelOpt = productServiceI.findById(productId);

	        if (!prodModelOpt.isPresent()) {
	            response.setMessage("لم يتم العثور على المنتج مع المعرف: " + productId);
	            response.setState(false);
	            return response;
	        }

	        productModel prodModel = prodModelOpt.get();

	        if (billProductDTO.getProductSellPrice() != null && billProductDTO.isChangeSellPrice()) {
	            prodModel.setSellPrice(billProductDTO.getProductSellPrice());
	            productDTO updatedProductDTO = productServiceI.updateProductAllData(
	                prodModel.getId(), productDTOMapper.mapProductToDTO(prodModel)
	            ).getDTOObject();
	            prodModel = productDTOMapper.mapDTOToProductModel(updatedProductDTO);
	        }

	        billProductDTO.setProductBuyPrice(prodModel.getBuyPrice());
	        billProductDTO.setProductSellPrice(
	            billProductDTO.getProductSellPrice() != null ? billProductDTO.getProductSellPrice() : prodModel.getSellPrice()
	        );
	        billProductDTO.setProductName(billProductDTO.getProductName() != null ? billProductDTO.getProductName() : prodModel.getName());
	        billProductModel billProdModel = billProductDTOMapper.mapDTOToBillProduct(billProductDTO);
	        billProdModel.setBillModel(insertedBillModel); 
	        billProductModel insertedBillProductModel = billProductServiceI.save(billProdModel);

	        billProductDTO.setId(insertedBillProductModel.getId());
	        billProductDTO.setRowTotal(insertedBillProductModel.getRowTotal());
	        billProductDTOsInserted.add(billProductDTO);
	    }

	    bill.setBillProductModelList(billProductDTOsInserted);

	    response.setMessage("تم تسجيل الفاتورة");
	    response.setState(true);
	    response.setDTOObject(bill);

	    return response;
	}

	@Override
	public responseOperations<billDTO> updateBill(billDTO bill) {
		Optional<billModel> founded=findById(bill.getId());
		billDTO oldBill= founded.isPresent() ?billDTOMapper.mapBillModelTOBillDTO(founded.get()):null;
		responseOperations<billDTO> response=new responseOperations<>();
		if(oldBill!=null)
		{
			if(bill.getBillPayed()!=null)
			{
				oldBill.setBillPayed(bill.getBillPayed());
			}
			if(bill.getBillProductModelList()!=null || !bill.getBillProductModelList().isEmpty())
			{
				oldBill.setBillProductModelList(bill.getBillProductModelList());
			}
			if(bill.getCustomerId()!=null)
			{
				oldBill.setCustomerId(bill.getCustomerId());
			}
			if(bill.getCustomerName()!=null)
			{
				oldBill.setCustomerName(bill.getCustomerName());
			}
			if(bill.getBillTypeId()!=null)
			{
				oldBill.setBillTypeId(bill.getBillTypeId());
			}
			if(bill.getBillTypeName()!=null)
			{
				oldBill.setBillTypeName(bill.getBillTypeName());
			}
			if(bill.getDateTime()!=null)
			{
				oldBill.setDateTime(bill.getDateTime());
			}
			if(bill.getDayId()!=null)
			{
				oldBill.setDayId(bill.getDayId());
			}
			if(bill.getEmployeeId()!=null)
			{
				oldBill.setCustomerId(bill.getCustomerId());
			}
			if(bill.getCustomerName()!=null)
			{
				oldBill.setCustomerName(bill.getCustomerName());
			}
			
				oldBill.setReturnedBill(bill.isReturnedBill()?true:false);
				response.setMessage("تم تعديل الفاتورة");
				response.setState(true);
				billRepository.save(billDTOMapper.mapDTOToBillModel(oldBill));
				response.setDTOObject(oldBill);
		}else
		{
			response.setMessage("الفاتورة غير موجودة");
			response.setState(false);
		}
		return response;
	}

	@Override
	public List<billDTO> findAllBillsReturned() {
		return billRepository
				.findByReturnedBill()
				.stream()
				.map(billDTOMapper::mapBillModelTOBillDTO)
				.collect(Collectors.toList());
	}
	
//	@Override
//	public responseOperations<billDTO> findBySearchCriteria(billSearch billSearch) {
//    	responseOperations<billDTO> response=new responseOperations<billDTO>();
//		try {
//	    	String employeeName = billSearch.getEmployeeName();
//		    Long employeeId = billSearch.getEmployeeId();
//		    Integer billTypeId = billSearch.getBillTypeId();
//		    Integer billTotal = billSearch.getBillTotal();
//		    Boolean returnedBill = billSearch.getReturnedBill(); 
//		    List<Long> fetchedBillIds = new ArrayList<>();
//		    
//		    LocalDateTime startDate = null;
//		    LocalDateTime endDate = null;
//
//		    if (billSearch.getDate() != null) {
//		        // Search by specific date
//		        startDate = billSearch.getDate().atStartOfDay();
//		        endDate = startDate.plusDays(1).minusNanos(1);
//		    } else if (billSearch.getMonth() != null && billSearch.getYear() != null) {
//		        // Search by month in a specific year
//		        startDate = LocalDateTime.of(billSearch.getYear(), billSearch.getMonth(), 1, 0, 0);
//		        endDate = startDate.plusMonths(1).minusNanos(1);
//		    } else if (billSearch.getYear() != null) {
//		        // Search by year
//		        startDate = LocalDateTime.of(billSearch.getYear(), 1, 1, 0, 0);
//		        endDate = startDate.plusYears(1).minusNanos(1);
//		    }
//
//		    if (billSearch.getId() != null) {
//		        List<billDTO> returnList = new ArrayList<>();
//		        Optional<billModel> findByIdRes = billRepository.findById(billSearch.getId());
//		        if (findByIdRes.isPresent()) {
//		        	billDTO billD=billDTOMapper.mapBillModelTOBillDTO(findByIdRes.get());
//		        	List<billProductDTO> billProducts=billProductServiceI.findByBillModelId(billSearch.getId()).stream().map(billProductDTOMapper::mapBillProductToDTO).collect(Collectors.toList());
//		        	List<billProductDTO> billProductsNew=new ArrayList<billProductDTO>();
//		        	for(billProductDTO dotBillProduct:billProducts)
//		        	{
//		        		dotBillProduct.setListOfAdds(BillProductsConstantsAddsServiceI.findByBillProductId(dotBillProduct.getId()));
//		        		billProductsNew.add(dotBillProduct);
//		        	}
//		        	billD.setBillProductModelList(billProductsNew);
//		            returnList.add(billD);
//		        }
//		        response.setListOfDTO(returnList);
//		        response.setState(true);
//		        response.setMessage("Data fetched successfully");
//		        return response;
//		    } else {
//		        // You can add specific methods in your repository for filtering by billTypeId and employeeId if needed
//		        if (billTypeId != null) {
//		            List<billDTO> foundedByBillType = billRepository.findByBillTypeId(billTypeId);
//		            for (billDTO bill : foundedByBillType) {
//		                fetchedBillIds.add(bill.getId());
//		            }
//		        }
//
//		        List<billDTO> billD=billRepository.findBillModels(
//		                employeeName != null && !employeeName.isEmpty() ? employeeName : null,
//		                employeeId != null ? employeeId : null,
//		                billTypeId != null ? billTypeId : null,
//		                startDate,
//		                endDate,
//		                billTotal != null ? billTotal : null,
//		                returnedBill != null ? returnedBill : null,
//		                fetchedBillIds != null && !fetchedBillIds.isEmpty() ? fetchedBillIds : null
//		        ).stream()
//		          .map(billDTOMapper::mapBillModelTOBillDTO)
//		          .collect(Collectors.toList());
//		        Long total=0L;
//		        
//		        for(billDTO bil:billD)
//		        {
//		        	total+=bil.getBillTotal();
//		        }
//		        List<billDTO> finalBillDTOs=new ArrayList<billDTO>();
//		        for(billDTO bill:finalBillDTOs)
//		        {
//		        	List<billProductDTO> billProducts=billProductServiceI.findByBillModelId(bill.getId()).stream().map(billProductDTOMapper::mapBillProductToDTO).collect(Collectors.toList());
//		        	List<billProductDTO> billProductsNew=new ArrayList<billProductDTO>();
//		        	for(billProductDTO dotBillProduct:billProducts)
//		        	{
//		        		dotBillProduct.setListOfAdds(BillProductsConstantsAddsServiceI.findByBillProductId(dotBillProduct.getId()));
//		        		billProductsNew.add(dotBillProduct);
//		        	}
//		        	bill.setBillProductModelList(billProductsNew);
//		        	finalBillDTOs.add(bill);
//		        }
//		        response.setListOfDTO(billD);
//		        response.setTotal(total);
//		        response.setState(true);
//
//		}
//		    } catch (Exception e) {
//		    	response.setMessage("Error Occured and its details { "+e.getMessage()+" }");
//		    	response.setState(false);
//		    }
//        return response;
//	}

	@Override
	public responseOperations<billDTO> findBySearchCriteria(billSearch billSearch) {
	    responseOperations<billDTO> response = new responseOperations<>();

	    try {
	        // Initialize variables
	        String employeeName = billSearch.getEmployeeName();
	        Long employeeId = billSearch.getEmployeeId();
	        Integer billTypeId = billSearch.getBillTypeId();
	        Integer billTotal = billSearch.getBillTotal();
	        Boolean returnedBill = billSearch.getReturnedBill();
	        List<Long> fetchedBillIds = new ArrayList<>();

	        LocalDateTime startDate = null;
	        LocalDateTime endDate = null;

	        // Determine the date range based on the search criteria
	        if (billSearch.getDate() != null) {
	            startDate = billSearch.getDate().atStartOfDay();
	            endDate = startDate.plusDays(1).minusNanos(1);
	        } else if (billSearch.getMonth() != null && billSearch.getYear() != null) {
	            startDate = LocalDateTime.of(billSearch.getYear(), billSearch.getMonth(), 1, 0, 0);
	            endDate = startDate.plusMonths(1).minusNanos(1);
	        } else if (billSearch.getYear() != null) {
	            startDate = LocalDateTime.of(billSearch.getYear(), 1, 1, 0, 0);
	            endDate = startDate.plusYears(1).minusNanos(1);
	        }

	        // Fetch by bill ID if provided
	        if (billSearch.getId() != null) {
	            return fetchById(billSearch.getId());
	        }

	        // Fetch by bill type if provided
	        if (billTypeId != null) {
	            fetchedBillIds = billRepository.findByBillTypeId(billTypeId)
	                                           .stream()
	                                           .map(billDTO::getId)
	                                           .collect(Collectors.toList());
	        }

	        // Perform the search
	        List<billDTO> billDTOs = billRepository.findBillModels(
	                employeeName,
	                employeeId,
	                billTypeId,
	                startDate,
	                endDate,
	                billTotal,
	                returnedBill,
	                fetchedBillIds.isEmpty() ? null : fetchedBillIds
	        ).stream()
	         .map(billDTOMapper::mapBillModelTOBillDTO)
	         .collect(Collectors.toList());

	        // Calculate total bill amount
	        Double total = Double.valueOf("%.2f".formatted(billDTOs.stream()
	                             .mapToDouble(billDTO::getBillTotal)
	                             .sum()));

	        // Fetch associated bill products and their additions
	        enrichBillDTOsWithProducts(billDTOs);

	        // Set response data
	        response.setListOfDTO(billDTOs);
	        response.setTotal(total);
	        response.setState(true);
	        response.setMessage("Data fetched successfully");

	    } catch (Exception e) {
	        response.setMessage("Error Occurred: " + e.getMessage());
	        response.setState(false);
	    }

	    return response;
	}
	private responseOperations<billDTO> fetchById(Long id) {
	    responseOperations<billDTO> response = new responseOperations<>();
	    Optional<billModel> findByIdRes = billRepository.findById(id);
	
	    if (findByIdRes.isPresent()) {
	        billDTO billD = billDTOMapper.mapBillModelTOBillDTO(findByIdRes.get());
	        enrichBillDTOWithProducts(billD);
	        response.setListOfDTO(Collections.singletonList(billD));
	        response.setState(true);
	        response.setMessage("Data fetched successfully");
	    } else {
	        response.setState(false);
	        response.setMessage("No data found for the provided ID");
	    }
	
	    return response;
	}
	private void enrichBillDTOWithProducts(billDTO billD) {
	    List<billProductDTO> billProducts = billProductServiceI.findByBillModelId(billD.getId())
	                                                           .stream()
	                                                           .map(billProductDTOMapper::mapBillProductToDTO)
	                                                           .collect(Collectors.toList());

	    billProducts.forEach(product -> product.setListOfAdds(BillProductsConstantsAddsServiceI.findByBillProductId(product.getId())));
	    billD.setBillProductModelList(billProducts);
	}
	private void enrichBillDTOsWithProducts(List<billDTO> billDTOs) {
	    billDTOs.forEach(this::enrichBillDTOWithProducts);
	}
	
	@Override
	public CustomJasperViewer<?> billsReport(ReportRequestProducts reportRequestForBillsReport) throws JRException, SQLException {
	    // Fetch the list of billDTO based on search criteria
	    responseOperations<billDTO> billDtos = findBySearchCriteria(reportRequestForBillsReport.getBillSearch());
	    
	    // Initialize the JRBeanCollectionDataSource
	    JRBeanCollectionDataSource dataSource = null;
	    if (billDtos.isState() && billDtos.getListOfDTO() != null && !billDtos.getListOfDTO().isEmpty()) {
	        dataSource = new JRBeanCollectionDataSource(billDtos.getListOfDTO());
	    }

	    if(dataSource!=null)
	    {
		    // Prepare the report request and parameters
		    reportRequest repRequest = reportRequestForBillsReport.getReportRequest();
		    repRequest.setDataSource(dataSource);
		    HashMap<String, Object> params = new HashMap<>();
		    
		    // Initialize total calculations
		    double total = 0.0;
		    double totalPayed = 0.0;
		    double totalRemained = 0.0;
		    
		    // Calculate totals
		    for (billDTO bill : billDtos.getListOfDTO()) {
		        total += bill.getBillTotal();
		        totalPayed += bill.getBillPayed();
		        totalRemained += bill.getBillRemained();
		    }

		    // Populate parameters for the report
		    params.put("Total", total);
		    params.put("Payed", totalPayed);
		    params.put("Remained", totalRemained);
		    repRequest.setPara(params);

		    // Generate the report using the main viewer service
		    CustomJasperViewer<?> customJasperForReturn = reportViewerService.mainViewerResponse(repRequest);
		    
		    // Create a new CustomJasperViewer for returning the result
		    CustomJasperViewer<billDTO> customDTO = new CustomJasperViewer<>();
		    customDTO.setHtmlContent(customJasperForReturn.getHtmlContent());
		    customDTO.setJasperViewer(customJasperForReturn.getJasperViewer());
		    customDTO.setListofReport(billDtos.getListOfDTO());
		    customDTO.setPdfContent(customJasperForReturn.getPdfContent());
		    
		    return customDTO;
	    }else
	    {
	    	return null;
	    }
	}
	
//	@Override
//	public CustomJasperViewer <?> billsReport(
//			ReportRequestProducts reportRequestForbillsReport
//			) throws JRException, SQLException
//	{
//		JRBeanCollectionDataSource dataSource=null;
//		responseOperations<billDTO> billdtos=findBySearchCriteria(
//				reportRequestForbillsReport
//				.getBillSearch());
//		if(billdtos.isState()&&billdtos.getListOfDTO()!=null)
//		{
//			dataSource=new JRBeanCollectionDataSource(billdtos.getListOfDTO());
//		}
//		
//		reportRequest repRequest=reportRequestForbillsReport.getReportRequest();
//		repRequest.setDataSource(dataSource);
//		HashMap<String,Object> params = new HashMap<String, Object>();
//		Double Total=0.0;
//		Double totalPayed=0.0;
//		Double totalRemaind=0.0;
//		for (billDTO bill: billdtos.getListOfDTO())
//		{
//			Total+=bill.getBillTotal();
//			totalPayed+=bill.getBillPayed();
//			totalRemaind+=bill.getBillRemained();
//		}
//		params.put("Total",Total);
//		params.put("Payed", totalPayed);
//		params.put("Remained", totalRemaind);
//		repRequest.setPara(params);
//		CustomJasperViewer<?> customJasperForReturn=reportViewerService.mainViewerResponse(repRequest);
//		CustomJasperViewer<billDTO> customDTO=new CustomJasperViewer<billDTO>();
//		customDTO.setHtmlContent(customJasperForReturn.getHtmlContent());
//		customDTO.setJasperViewer(customJasperForReturn.getJasperViewer());
//		customDTO.setListofReport(billdtos.getListOfDTO());
//		customDTO.setPdfContent(customJasperForReturn.getPdfContent());
//		return customDTO;		
//	}

	
	@Override
	public List<Long> findBillIdsBySearch(billSearch billSearch) {
	    try {
	        String employeeName = billSearch.getEmployeeName();
	        Long employeeId = billSearch.getEmployeeId();
	        Integer billTypeId = billSearch.getBillTypeId();
	        Integer billTotal = billSearch.getBillTotal();
	        Boolean returnedBill = billSearch.getReturnedBill(); 
	        
	        LocalDateTime startDate = null;
	        LocalDateTime endDate = null;

	        // Determine the date range based on the search criteria
	        if (billSearch.getDate() != null) {
	            startDate = billSearch.getDate().atStartOfDay();
	            endDate = startDate.plusDays(1).minusNanos(1);
	        } else if (billSearch.getMonth() != null && billSearch.getYear() != null) {
	            startDate = LocalDateTime.of(billSearch.getYear(), billSearch.getMonth(), 1, 0, 0);
	            endDate = startDate.plusMonths(1).minusNanos(1);
	        } else if (billSearch.getYear() != null) {
	            startDate = LocalDateTime.of(billSearch.getYear(), 1, 1, 0, 0);
	            endDate = startDate.plusYears(1).minusNanos(1);
	        }

	        // If a specific bill ID is provided, return it if found
	        if (billSearch.getId() != null) {
	            Optional<billModel> findByIdRes = billRepository.findById(billSearch.getId());
	            return findByIdRes.isPresent() ? Collections.singletonList(billSearch.getId()) : Collections.emptyList();
	        }

	        // Prepare the list of fetched bill IDs if filtering by billTypeId
	        List<Long> fetchedBillIds = new ArrayList<>();
	        if (billTypeId != null) {
	            List<billDTO> foundedByBillType = billRepository.findByBillTypeId(billTypeId);
	            fetchedBillIds = foundedByBillType.stream()
	                                              .map(billDTO::getId)
	                                              .collect(Collectors.toList());
	        }

	        // Fetch the bill IDs based on the search criteria
	        return billRepository.findBillModelIds(
	                (employeeName != null && !employeeName.isEmpty()) ? employeeName : null,
	                employeeId,
	                billTypeId,
	                startDate,
	                endDate,
	                billTotal,
	                returnedBill,
	                !fetchedBillIds.isEmpty() ? fetchedBillIds : null
	        );
	    } catch (Exception e) {
	        return Collections.emptyList();
	    }
	}


	@Override
	public int countBillsByDay(Long dayId) {
		return billRepository.countBillsByDay(dayId);
	}


}

package com.MO.Software.customer.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.customer.customerModel;
import com.MO.Software.customer.Service.customerServiceInterface;
import com.MO.Software.reportBase.reportRequest;
import com.MO.Software.reportBase.reportViewer;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/customer")
public class customerRestController {

	@Autowired
	private reportViewer reportViewer;
	
	@Autowired
	private customerServiceInterface customerServiceI;
	@RequestMapping("/add")
	public ResponseEntity<?> saveCustomer(@RequestBody customerModel customer)
	{
	   customerModel customerSaved=customerServiceI.save(customer);
	   if(customerSaved!=null)
	   {
		   return new ResponseEntity< >(customerSaved,HttpStatus.CREATED);
	   }else
	   {
		   return new ResponseEntity< >("Something Wrong",HttpStatus.BAD_REQUEST);
	   }
	}
	
	@RequestMapping("/report")
	public ResponseEntity<?> getAllCustomersReport(@RequestBody reportRequest reportRequest) throws JRException, FileNotFoundException
	{
		List<customerModel> findAllCustomers=customerServiceI.findAll();
		if(findAllCustomers!=null ||!findAllCustomers.isEmpty())
		{
			JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(findAllCustomers);
			reportViewer.viewJRBeanCollection(reportRequest.getReportFormat(), dataSource,
					ResourceUtils.getFile("classpath:customers.jrxml").getAbsolutePath(),
					"D:\\Programming\\Java\\Java Work Projects\\POS APPLICATIONS\\Spring",
					reportRequest.getFileDestinationName());
			return new ResponseEntity< >(findAllCustomers,HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No customers",HttpStatus.OK);
	
		}
	}
	
	@RequestMapping("/findAll")
	public ResponseEntity<?> getAllCustomers()
	{
		List<customerModel> findAll=customerServiceI.findAll();
		if(findAll.isEmpty())
		{
			return new ResponseEntity< >("No customers",HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >(findAll,HttpStatus.OK);
		}
	}
}

package com.MO.Software.Bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.Bill.DTO.billDTO;
import com.MO.Software.Bill.service.billServiceInterface;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.service.responseOperations;

@Service
@RequestMapping("/bill")
@RestController
public class billRestController {

	@Autowired
	private billServiceInterface billServiceI;
	
	@RequestMapping("/add")
	public ResponseEntity<?> saveBill(@RequestBody billDTO billdto)
	{
		return new ResponseEntity< >(billServiceI.saveBill(billdto),HttpStatus.CREATED);
	}
	
	public responseOperations<billDTO> saveBillMethod( billDTO billdto)
	{
		return billServiceI.saveBill(billdto);
	}
	
	@RequestMapping("/update")
	public ResponseEntity<?> updateBill(@RequestBody billDTO billdto)
	{
		return new ResponseEntity< >(billServiceI.updateBill(billdto),HttpStatus.CREATED);
	}
	
	public responseOperations<billDTO> updateBillMethod( billDTO billdto)
	{
		return billServiceI.updateBill(billdto);
	}
	
	@RequestMapping("/search")
	public ResponseEntity<?> searchBills(@RequestBody billSearch billSearch)
	{
		return new ResponseEntity< >(billServiceI.findBySearchCriteria(billSearch),HttpStatus.OK);
	}
	
	public responseOperations<billDTO> searchBillsMethod(@RequestBody billSearch billSearch)
	{
		return billServiceI.findBySearchCriteria(billSearch);
	}
	
}

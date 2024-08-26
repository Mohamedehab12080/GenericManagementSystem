package com.MO.Software.Bill.billType.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.Bill.billType.billType;
import com.MO.Software.Bill.billType.service.billTypeServiceInterface;

@RestController
@RequestMapping("/billType")
@Service
public class billTypeRestController {

	@Autowired
	private billTypeServiceInterface billTypeServiceI;
	
	@RequestMapping("/findAll")
	public ResponseEntity<?> findAll()
	{
		return new ResponseEntity< >(billTypeServiceI.findAll(),HttpStatus.OK);
	}
	
	public List<billType> findAllBillTypeMethod()
	{
		return billTypeServiceI.findAll();
	}
	
	
}

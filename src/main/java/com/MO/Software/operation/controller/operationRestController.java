package com.MO.Software.operation.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.operation.operationModel;
import com.MO.Software.operation.DTO.operationDTO;
import com.MO.Software.operation.DTO.operationDTOMapper;
import com.MO.Software.operation.service.operationServiceInterface;

@RestController
@Service
@RequestMapping("/operation")
public class operationRestController {

	@Autowired
	private operationServiceInterface operationServiceI;
	
	@RequestMapping("/findAllInPage/{pageId}")
	public ResponseEntity<?> findAllOperationsInPage(@PathVariable("pageId") Integer pageId)
	{
		List<operationDTO> ops=operationServiceI.findByPageId(pageId);
		if(!ops.isEmpty())
		{
			return new ResponseEntity< >(ops,HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No operations",HttpStatus.OK);
		}
	}
	
	public List<operationDTO> findAllOperationsInPageMethod( Integer pageId)
	{
		List<operationDTO> ops=operationServiceI.findByPageId(pageId);
		if(ops.isEmpty())
		{
			return ops;
		
		}else
		{
			return Collections.emptyList();
		}
	}
}

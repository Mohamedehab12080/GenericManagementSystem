package com.MO.Software.operation.pages.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.operation.DTO.operationDTO;
import com.MO.Software.operation.pages.pageModel;
import com.MO.Software.operation.pages.service.pageServiceInterface;
import com.MO.Software.operation.service.operationServiceInterface;

@RestController
@RequestMapping("/page")
@Service
public class pageRestController {

	@Autowired
	private pageServiceInterface pageServiceI;
	
	@Autowired
	private operationServiceInterface operationServiceI;
	
	@RequestMapping("/findAll")
	public ResponseEntity<?> findAllPages()
	{
		List<pageModel> pages=pageServiceI.findAll();
		List<fetchPagesResponse> response=new ArrayList<fetchPagesResponse>();
		if(pages!=null)
		{
			for(pageModel page: pages)
			{
				List<operationDTO> operationsList=operationServiceI.findByPageId(page.getId());
				fetchPagesResponse obj=new fetchPagesResponse();
				obj.setOperationsList(operationsList);
				obj.setPageId(page.getId());
				obj.setPageName(page.getName());
				response.add(obj);
			}
			return new ResponseEntity< >(response,HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Pages",HttpStatus.OK);
		}
	}
	
	public List<fetchPagesResponse> findAllPagesMethod()
	{
		List<pageModel> pages=pageServiceI.findAll();
		List<fetchPagesResponse> response=new ArrayList<fetchPagesResponse>();
		if(pages!=null)
		{
			for(pageModel page: pages)
			{
				List<operationDTO> operationsList=operationServiceI.findByPageId(page.getId());
				fetchPagesResponse obj=new fetchPagesResponse();
				obj.setOperationsList(operationsList);
				obj.setPageId(page.getId());
				obj.setPageName(page.getName());
				response.add(obj);
			}
			return response;
		}else
		{
			return Collections.emptyList();
		}
	}
}

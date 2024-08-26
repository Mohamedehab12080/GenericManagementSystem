package com.MO.Software.operation.pages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.operation.pages.pageModel;

@Service
public class pageServiceImpl 
extends baseServiceImpl<pageModel,Integer>
implements pageServiceInterface{

	@Autowired
	private pageRepository pageRepository; 
	
	@Override
	protected baseRepository<pageModel, Integer> getRepository() {
		return pageRepository;
	}

	@Override
	public void insertAllPages(List<pageModel> entities) {
		pageRepository.saveAll(entities);
	}

}

package com.MO.Software.DailyCosts.costsName.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.DailyCosts.costsName.costsNameModel;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class costsNameServiceImpl  
extends baseServiceImpl<costsNameModel,Long> 
implements costsNameServiceInterface{

	@Autowired 
	private costsNameRepository costsNameRepository;
	
	@Override
	protected baseRepository<costsNameModel, Long> getRepository() {
		return costsNameRepository;
	}

}

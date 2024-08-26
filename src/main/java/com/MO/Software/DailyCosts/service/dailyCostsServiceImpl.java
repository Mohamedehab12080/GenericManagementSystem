package com.MO.Software.DailyCosts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.DailyCosts.dailyCostsModel;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class dailyCostsServiceImpl 
extends baseServiceImpl<dailyCostsModel,Long>
implements dailyCostsServiceInterface{

	@Autowired
	private dailyCostsRepository dailyCostsRepository;
	
	@Override
	protected baseRepository<dailyCostsModel, Long> getRepository() {
		return dailyCostsRepository;
	}

}

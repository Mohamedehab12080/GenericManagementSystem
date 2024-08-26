package com.MO.Software.Day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Day.dayModel;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class dayServiceImpl  
extends baseServiceImpl<dayModel,Long>
implements dayServiceInterface{

	@Autowired
	private dayServiceRepository dayServiceRepository; 
	
	@Override
	protected baseRepository<dayModel, Long> getRepository() {
		return dayServiceRepository;
	}

}

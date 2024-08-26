package com.MO.Software.employee.jobType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.employee.jobType.jobTypeModel;

@Service
public class jobTypeServiceImpl 
extends baseServiceImpl<jobTypeModel, Long>
implements jobTypeServiceInterface{

	@Autowired
	private jobTypeRepository jobTypeRepository;
	@Override
	protected baseRepository<jobTypeModel, Long> getRepository() {
		return jobTypeRepository;
	}
	@Override
	public jobTypeModel findByName(String name) {
		return jobTypeRepository.findByName(name);
	}

}

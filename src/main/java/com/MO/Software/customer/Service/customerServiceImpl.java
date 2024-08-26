package com.MO.Software.customer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.customer.customerModel;

@Service
public class customerServiceImpl extends baseServiceImpl<customerModel,Long> implements customerServiceInterface{

	@Autowired
	private customerRepository customerRepository;
	
	@Override
	protected baseRepository<customerModel, Long> getRepository() {
		return customerRepository;
	}

}

package com.MO.Software.Bill.billType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billType.billType;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
@Service
public class billTypeServiceImpl extends baseServiceImpl<billType,Integer> implements billTypeServiceInterface{

	@Autowired
	private billTypeRepository billTypRepository;
	
	@Override
	protected baseRepository<billType, Integer> getRepository() {
		return billTypRepository;
	}

	@Override
	public billType findByName(String billTypeName) {
		return billTypRepository.findByName(billTypeName);
	}

	
}

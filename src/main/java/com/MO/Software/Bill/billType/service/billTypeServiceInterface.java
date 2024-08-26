package com.MO.Software.Bill.billType.service;

import com.MO.Software.Bill.billType.billType;
import com.MO.Software.base.baseServiceInterface;

public interface billTypeServiceInterface extends baseServiceInterface<billType,Integer>{

	billType findByName(String billTypeName);
	
}

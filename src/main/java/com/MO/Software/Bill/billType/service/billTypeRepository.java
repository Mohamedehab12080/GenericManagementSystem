package com.MO.Software.Bill.billType.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.Bill.billType.billType;
import com.MO.Software.base.baseRepository;

@Repository
public interface billTypeRepository  extends baseRepository<billType, Integer>{

	@Query("select bT from billType bT where bT.name=:billTypeName")
	billType findByName(String billTypeName);

}

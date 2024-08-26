package com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductsConstantsAddsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductConstantsAdds;
import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.DTO.BillProductConstantsAddsDTO;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class BillProductsConstantsAddsServiceImpl 
extends baseServiceImpl<BillProductConstantsAdds,Long> implements
BillProductsConstantsAddsServiceInterface {

	@Autowired
	private BillProductsConstantsAddsRepository BillProductsConstantsAddsRepository;
	
	@Override
	protected baseRepository<BillProductConstantsAdds, Long> getRepository() {
		return BillProductsConstantsAddsRepository;
	}

	@Override
	public List<BillProductConstantsAddsDTO> findByBillProductId(Long id) {
		return BillProductsConstantsAddsRepository.findByBillProductId(id);
	}

}

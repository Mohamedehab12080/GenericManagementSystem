package com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductsConstantsAddsService;

import java.util.List;

import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductConstantsAdds;
import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.DTO.BillProductConstantsAddsDTO;
import com.MO.Software.base.baseServiceInterface;

public interface BillProductsConstantsAddsServiceInterface extends
baseServiceInterface<BillProductConstantsAdds, Long>{

	List<BillProductConstantsAddsDTO> findByBillProductId(Long id);

}

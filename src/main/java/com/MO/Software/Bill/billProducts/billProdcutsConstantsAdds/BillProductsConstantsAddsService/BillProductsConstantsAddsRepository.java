package com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductsConstantsAddsService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.BillProductConstantsAdds;
import com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.DTO.BillProductConstantsAddsDTO;
import com.MO.Software.base.baseRepository;

@Repository
public interface BillProductsConstantsAddsRepository  extends baseRepository<BillProductConstantsAdds,Long>{

	
	@Query("SELECT new com.MO.Software.Bill.billProducts.billProdcutsConstantsAdds.DTO."
			+ "BillProductConstantsAddsDTO("
			+ "ad.id,"
			+ "ad.constantId,"
			+ "ad.billProductId,"
			+ "ad.constantName,"
			+ "ad.constantPrice) "
			+ "From BillProductConstantsAdds ad"
			+ " Where ad.billProductId=:billProductId")
	List<BillProductConstantsAddsDTO> findByBillProductId(@Param("billProductId") Long billProductId);

	
}

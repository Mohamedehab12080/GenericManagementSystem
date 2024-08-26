package com.MO.Software.product.productsConstantsAdds.productsConstantsAddsService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.product.productsConstantsAdds.ProductsConstantAdds;

@Repository
public interface ProductsConstantsAddsRepository 
extends baseRepository<ProductsConstantAdds,Long>{

	@Query("SELECT pc From ProductsConstantAdds pc where pc.ConstantsCategory.id=:categoryId")
	List<ProductsConstantAdds> findByCategoryId(@Param("categoryId") Long categoryId);

}

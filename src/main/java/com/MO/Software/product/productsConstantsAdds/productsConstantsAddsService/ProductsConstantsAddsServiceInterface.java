package com.MO.Software.product.productsConstantsAdds.productsConstantsAddsService;

import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.product.productsConstantsAdds.ProductsConstantAdds;
import com.MO.Software.product.productsConstantsAdds.productsConstantsAddsDTO.ProductsConstantsAddsDTO;

public interface ProductsConstantsAddsServiceInterface extends baseServiceInterface<ProductsConstantAdds,Long> {

	List<ProductsConstantsAddsDTO> findByCategoryId(Long categoryId);
}

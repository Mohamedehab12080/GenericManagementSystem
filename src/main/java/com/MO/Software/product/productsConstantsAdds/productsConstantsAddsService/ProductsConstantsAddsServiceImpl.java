package com.MO.Software.product.productsConstantsAdds.productsConstantsAddsService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.product.productsConstantsAdds.ProductsConstantAdds;
import com.MO.Software.product.productsConstantsAdds.productsConstantsAddsDTO.ProductsConstantsAddsDTO;
import com.MO.Software.product.productsConstantsAdds.productsConstantsAddsDTO.ProductsConstantsAddsDTOMapper;

@Service
public class ProductsConstantsAddsServiceImpl 
extends baseServiceImpl<ProductsConstantAdds,Long>
implements ProductsConstantsAddsServiceInterface{

	@Autowired
	private ProductsConstantsAddsRepository ProductsConstantsAddsRepository;
	
	@Override
	protected baseRepository<ProductsConstantAdds, Long> getRepository() {
		return ProductsConstantsAddsRepository;
	}

	@Override
	public List<ProductsConstantsAddsDTO> findByCategoryId(Long categoryId) {
		return ProductsConstantsAddsRepository
				.findByCategoryId(categoryId)
				.stream().map(
						ProductsConstantsAddsDTOMapper
						::mapProductsConstantsAddsToDTO)
				.collect(Collectors.toList());
	}

}

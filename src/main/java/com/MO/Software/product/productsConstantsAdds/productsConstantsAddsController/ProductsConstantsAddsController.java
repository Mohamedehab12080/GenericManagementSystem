package com.MO.Software.product.productsConstantsAdds.productsConstantsAddsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.product.productsConstantsAdds.productsConstantsAddsDTO.ProductsConstantsAddsDTO;
import com.MO.Software.product.productsConstantsAdds.productsConstantsAddsService.ProductsConstantsAddsServiceInterface;

@RestController
@RequestMapping("/api/ProductsConstants")
public class ProductsConstantsAddsController {

	@Autowired
	private ProductsConstantsAddsServiceInterface ProductsConstantsAddsService;
	
	@RequestMapping("/findByCategoryId/{categoryId}")
	public ResponseEntity<?> findByCategoryID(@PathVariable("categoryId") Long categoryId)
	{
		return new ResponseEntity< >(ProductsConstantsAddsService.findByCategoryId(categoryId),HttpStatus.OK);
	}
	
	public List<ProductsConstantsAddsDTO> findByCategoryIDMethod(Long categoryId)
	{
		return ProductsConstantsAddsService
				.findByCategoryId(categoryId);
	}
}

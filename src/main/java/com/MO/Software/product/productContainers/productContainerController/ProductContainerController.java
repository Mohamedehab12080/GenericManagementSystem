package com.MO.Software.product.productContainers.productContainerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO;
import com.MO.Software.product.productContainers.productContainerService.productContainerServiceInterface;
import com.MO.Software.product.service.responseOperations;

@RestController
@RequestMapping("/api/ProductContainer")
public class ProductContainerController {

	@Autowired
	private productContainerServiceInterface productContainerServiceI;
	
	@RequestMapping("/create")
	public ResponseEntity<?> createProductContainer(
			@RequestBody ProductContainerDTO productCotnainerDTO)
	{
		return new ResponseEntity< >(productContainerServiceI.insertProductContainer(productCotnainerDTO),HttpStatus.CREATED);
	}
	
	public responseOperations<ProductContainerDTO> createProductContainerMethod(ProductContainerDTO ProductContainerDTO){
		
		return productContainerServiceI.insertProductContainer(ProductContainerDTO);
	}
	
	@RequestMapping
	public ResponseEntity<?> findByProductId(@PathVariable("productId")Long productId)
	{
		return new ResponseEntity< >(productContainerServiceI.findByProductId(productId),HttpStatus.OK); 
	}
	
	public responseOperations<ProductContainerDTO> findByProductIdMethod(Long productId)
	{
		return productContainerServiceI.findByProductId(productId);
	}
}

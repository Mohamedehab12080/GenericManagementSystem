package com.MO.Software.product.productController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MO.Software.product.productModel;
import com.MO.Software.product.DTO.productDTO;
import com.MO.Software.product.DTO.productDTOMapper;
import com.MO.Software.product.service.productServiceInterface;
import com.MO.Software.product.service.responseOperations;

@Service
@RestController
@RequestMapping("/api/product")
public class productRestController {

	@Autowired
	private productServiceInterface productServiceI;
	

	@RequestMapping("/add")
	public ResponseEntity<?> insertProduct(@RequestBody productDTO productDto)
	{
		responseOperations <?> response =productServiceI.saveProduct(productDTOMapper.mapDTOToProductModel(productDto));
		if(response!=null)
		{
			return new ResponseEntity< >(response,HttpStatus.CREATED);
		}else
		{
			return new ResponseEntity< >("Somthing wrong!",HttpStatus.OK);
		}
	}
	
	/**
	 * @author BOBO
	 * @param productDto
	 * @return
	 */
	public responseOperations <?> insertProductMethod( productDTO productDto)
	{
		return productServiceI.saveProduct(productDTOMapper.mapDTOToProductModel(productDto));
		
	}
	
	
	@RequestMapping("/findByCategory/{categoryId}")
	public ResponseEntity<?> findAllProductsOfCategory(@PathVariable("categoryId") Long categoryId){
		List<productModel> founded=productServiceI.findProductModelByCategoryId(categoryId);
		if(founded!=null)
		{
			return new ResponseEntity< >(founded.stream().map(productDTOMapper::mapProductToDTO).collect(Collectors.toList()),HttpStatus.OK);
		}else
		{
			return new ResponseEntity< >("No Products",HttpStatus.OK);
		}
	}
	
	/**
	 * @author BOBO
	 * @param categoryId
	 * @return
	 */
	public	responseOperations<productDTO> findAllProductsOfCategoryMethod(Long categoryId){
		List<productModel> founded=productServiceI.findProductModelByCategoryId(categoryId);
		responseOperations<productDTO> response=new responseOperations<>();
		if(founded!=null)
		{
			response.setListOfDTO (founded.stream().map(productDTOMapper::mapProductToDTO).collect(Collectors.toList()));
			response.setState(true);
			return response;
		}else
		{
			response.setMessage("لا يوجد منتجات في هذا القسم");
			response.setState(false);
			return response;
		}
	}
	
}

package com.MO.Software.product.menuProduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.MO.Software.product.menuProduct.DTO.MenuProductCreateRequest;
import com.MO.Software.product.menuProduct.DTO.MenuProductDTO;
import com.MO.Software.product.menuProduct.menuProductService.MenuProductServiceInterface;
import com.MO.Software.product.service.responseOperations;

@RestController
@RequestMapping("/api/menuProduct")
public class MenuProductController {

	@Autowired
	private MenuProductServiceInterface MenuProductServiceI;
	
	@RequestMapping("/create")
	public ResponseEntity<?> createMenuProduct(@RequestBody MenuProductCreateRequest MenuProductCreateRequest)
	{
		return new ResponseEntity< >(MenuProductServiceI.createMenuProduct(MenuProductCreateRequest),HttpStatus.CREATED);
	}
	
	public responseOperations<MenuProductDTO> createMenuProductMethod(MenuProductCreateRequest MenuProductCreateRequest)
	{
		return MenuProductServiceI.createMenuProduct(MenuProductCreateRequest);
	}
}

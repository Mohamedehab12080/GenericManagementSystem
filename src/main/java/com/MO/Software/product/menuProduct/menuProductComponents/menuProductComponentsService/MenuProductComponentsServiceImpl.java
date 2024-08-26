package com.MO.Software.product.menuProduct.menuProductComponents.menuProductComponentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.product.menuProduct.menuProductComponents.MenuProductComponents;

@Service
public class MenuProductComponentsServiceImpl 
extends baseServiceImpl<MenuProductComponents,Long> implements MenuProductComponentsServiceInterface{

	@Autowired
	private MenuProductComponentsRepository MenuProductComponentsRepository;
	
	@Override
	protected baseRepository<MenuProductComponents, Long> getRepository() {
		return MenuProductComponentsRepository;
	}

}

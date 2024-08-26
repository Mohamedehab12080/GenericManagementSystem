package com.MO.Software.product.productsConstantsAdds.constantsCategory.constantsCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.product.productsConstantsAdds.constantsCategory.ConstantsCategory;

@Service
public class ConstantCategoryServiceImpl 
extends baseServiceImpl<ConstantsCategory,Long>
 implements ConstantCategoryServiceInterface{

	@Autowired
	private ConstantCategoryRepository ConstantCategoryRepository;
	
	@Override
	protected baseRepository<ConstantsCategory, Long> getRepository() {
		return ConstantCategoryRepository;
	}

}

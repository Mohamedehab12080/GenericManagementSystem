package com.MO.Software.product.service;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.Bill.billProducts.service.billProductServiceInterface;
import com.MO.Software.Bill.service.billServiceInterface;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.product.productModel;
import com.MO.Software.product.DTO.productDTO;
import com.MO.Software.product.DTO.productDTOMapper;
import com.MO.Software.place.storeProducts.storeProductService.ProductBatchServiceInterface;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class productServiceImpl
extends baseServiceImpl<productModel,Long>
implements productServiceInterface{

	@Autowired
	private productRepository productRepository;
	
	@Autowired
	private billProductServiceInterface billProductServiceI;
	
	@Autowired
	private  ProductBatchServiceInterface ProductBatchServiceI;
	
	@Autowired
	private billServiceInterface billServiceI; 
	@Override
	protected baseRepository<productModel, Long> getRepository() {
		return productRepository;
	}

	@Override
	public List<productModel> findProductModelByCategoryId(Long categoryId) {
		return productRepository.findByCategoryModelId(categoryId);
	}
	
	
	@Override
	public void deleteById(Long id)
	{
		
	}
	
	@Override
	public responseOperations<productDTO> findByName(String productName) {
		List<productModel> prodModel=productRepository.findByNameLike(productName);
		responseOperations<productDTO> response=new responseOperations<>();
		if(prodModel!=null)
		{
			response.setListOfDTO(prodModel.stream().map(productDTOMapper::mapProductToDTO).collect(Collectors.toList()));
			response.setMessage("Fetched");
			response.setState(true);
		}else
		{
			response.setMessage("No products");
			response.setState(false);
		}
		return response;
	}

	@Override
	public responseOperations <productDTO> saveProduct(productModel mapDTOToProductModel) {
	
		productModel founded=productRepository.findByName(mapDTOToProductModel.getName());
		responseOperations<productDTO> response=new responseOperations<>();
		if(founded!=null)
		{
			response.setMessage("موجود مسبقا");
			response.setState(false);
		}else
		{
			productModel Inserted=productRepository.save(mapDTOToProductModel);
			if(Inserted!=null)
			{
				mapDTOToProductModel.setId(Inserted.getId());
				response.setState(true);
				response.setMessage("تمت الاضافة");
				response.setDTOObject(productDTOMapper.mapProductToDTO(mapDTOToProductModel)); ;
			}
		}
		return response;
	}

	@Override
	public responseOperations <productDTO> updateProductAllData(Long productId,productDTO productDto) {
		Optional<productModel> founded=findById(productId);
		responseOperations <productDTO> response=new responseOperations<productDTO>();
		if(founded.isPresent())
		{
			productModel productModelInsert=founded.get();
			if(productDto.getBuyPrice()!=null)
			{
				productModelInsert.setBuyPrice(productDto.getBuyPrice());	
			}
			if(productDto.getSellPrice()!=null)
			{
				productModelInsert.setSellPrice(productDto.getSellPrice());
			}
			if(productDto.getName()!=null)
			{
				productModelInsert.setName(productDto.getName());
			}
			if(productDto.getGainPercentage()!=null)
			{
				productModelInsert.setGainPercentage(productDto.getGainPercentage());
			}
			if(productDto.getLowStockThreshold()!=null)
			{
				productModelInsert.setLowStockThreshold(productDto.getLowStockThreshold());
			}
			productRepository.save(productModelInsert);
			response.setMessage("تم التعديل");
			response.setState(true);
			productDTO dtoProduct=productDTOMapper.mapProductToDTO(productModelInsert);
			Double totalQ=ProductBatchServiceI.calculateTotalQuantity(productId);
			if(totalQ > productModelInsert.getLowStockThreshold())
			{
				dtoProduct.setState("Quantity is ok");
			}else if((totalQ-productModelInsert.getLowStockThreshold())<5)
			{
				dtoProduct.setState("its a "+(totalQ-productModelInsert.getLowStockThreshold())+" to reach the threshold !! ");
			}else
			{
				dtoProduct.setState("Quantity reached the threshold");
			}
			response.setDTOObject(dtoProduct);
		}else
		{
			response.setMessage("المنتج غير موجود!");
			response.setState(false);
		}
		return response;
	}
	
	 

	@Override
	public List<productDTO> findByCategoryModelIdAndBuyPrice(Long categoryModelId,Double buyPrice) {
		return productRepository.findByCategoryModelIdAndBuyPrice(categoryModelId,buyPrice)
				.stream().map(productDTOMapper::mapProductToDTO).collect(Collectors.toList());
	}

	@Override
	public List<productDTO> findByCategoryModelIdAndSellPrice(Long categoryModelId,Double sellPrice) {
		return productRepository.findByCategoryModelIdAndSellPrice(categoryModelId,sellPrice)
				.stream().map(productDTOMapper::mapProductToDTO).collect(Collectors.toList());
	}

	@Override
	public List<productDTO> findByCategoryModelIdAndGainPercentage(Long categoryModelId, Double gainPercentage) {
		return productRepository.findByCategoryModelIdAndGainPercentage(categoryModelId,gainPercentage)
				.stream().map(productDTOMapper::mapProductToDTO).collect(Collectors.toList());
	}
	
	/**
	 * @author BOBO
	 * @param billSearch
	 * @return Report (ProductSummaryDTO) products groub by category id and product id 
	 */
	@Override
	public List<ProductSummaryDTO> productReportwithBillSearch(billSearch billSearch)
	{
		return billProductServiceI.findByBillIds(billServiceI.findBillIdsBySearch(billSearch));
	}



}

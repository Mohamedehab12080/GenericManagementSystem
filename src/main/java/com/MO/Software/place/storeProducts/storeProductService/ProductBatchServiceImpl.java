	package com.MO.Software.place.storeProducts.storeProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.place.PlaceModel;
import com.MO.Software.place.service.PlaceServiceInterface;
import com.MO.Software.place.storeProducts.ProductBatchModel;
import com.MO.Software.place.storeProducts.storeProductsDTO.ProductBatchDTO;
import com.MO.Software.product.productModel;
import com.MO.Software.product.productContainers.ProductContainer;
import com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO;
import com.MO.Software.product.productContainers.productContainerService.productContainerServiceInterface;
import com.MO.Software.product.productContainers.productMoreThanContainer.StoreProductMoreThanContainer;
import com.MO.Software.product.productContainers.productMoreThanContainer.DTO.StoreProductMoreThanContainerDTO;
import com.MO.Software.product.productContainers.productMoreThanContainer.productMoreThanContainerService.ProductMoreThanContainerServiceInterface;
import com.MO.Software.product.service.responseOperations;

import jakarta.transaction.Transactional;

@Service
public class ProductBatchServiceImpl 
extends baseServiceImpl<ProductBatchModel,Long> 
implements ProductBatchServiceInterface 
{

	@Autowired
	private StoreProductRepository StoreProductRepository;
	
	@Autowired
	private ProductMoreThanContainerServiceInterface ProductMoreThanContainerServiceI;
	
	@Autowired
	private productContainerServiceInterface productContainerServiceI;

	@Autowired
	private PlaceServiceInterface placeServiceI;
	
	@Override
	protected baseRepository<ProductBatchModel, Long> getRepository() {
		return StoreProductRepository;
	}

	
	private ProductBatchDTO ToDTOForFirst(ProductBatchModel prod)
	{
		ProductBatchDTO dto=new ProductBatchDTO();
		dto.setId(prod.getId());
		dto.setExpirDate(prod.getExpirDate());
		dto.setReceivedDate(prod.getReceivedDate());
		PlaceModel placeModel=new PlaceModel();
		if(placeModel!=null)
		{
			dto.setPlaceId(placeModel.getId());
			dto.setPlaceName(placeModel.getName());
		}
		productModel productModel=new productModel();
		if(productModel!=null)
		{
			dto.setProductId(productModel.getId());
			dto.setProductName(productModel.getName());
		}
		dto.setSingleQuantity(prod.getQuantity());
		return dto;
	}
	@Override
	public ProductBatchDTO calculateNumberOfContainersFromSingle(Long StoreProductId) {
		ProductBatchDTO foundedDTO=StoreProductRepository.findProductBatchDTOById(StoreProductId);
		List<StoreProductMoreThanContainerDTO> StoreProductMoreThanContainerDTOList=new ArrayList<StoreProductMoreThanContainerDTO>();
		if(foundedDTO!=null)
		{
			responseOperations<ProductContainerDTO> responseProductContainer=productContainerServiceI
					.findByProductId(foundedDTO.getProductId());
			List<ProductContainerDTO>productContainerDTOList=null;
			if(responseProductContainer!=null)
			{
				if(responseProductContainer.getListOfDTO()!=null)
				{
					productContainerDTOList=responseProductContainer.getListOfDTO();
				}
			}
			
			if(productContainerDTOList!=null && productContainerDTOList.size()==1)
			{
				foundedDTO.setContainerQuantity(Math.ceil(Double.valueOf("%.2f".formatted(foundedDTO.getSingleQuantity()/productContainerDTOList.get(0).getProductContainerQuantity()))));
			}else
			{
				for(ProductContainerDTO prodContDTO:productContainerDTOList)
				{
					StoreProductMoreThanContainer prodMoreObj=ProductMoreThanContainerServiceI.findByStoreProductIdAndContainerName(StoreProductId,prodContDTO.getContainerName());
					if(prodMoreObj!=null)
					{
						StoreProductMoreThanContainerDTO dtoss=new StoreProductMoreThanContainerDTO();
						dtoss.setId(prodMoreObj.getId());
						dtoss.setStoreProductId(StoreProductId);
						dtoss.setContainerName(prodContDTO.getContainerName());
						Double quantityOfContainer=Math
								.ceil(
								Double
								.valueOf("%.2f"
										.formatted(
												foundedDTO
												.getSingleQuantity()/prodContDTO.getProductContainerQuantity())));
						dtoss.setQuantityOfProductContainer(quantityOfContainer);
						prodMoreObj.setQuantityOfProductContainer(quantityOfContainer);
						ProductMoreThanContainerServiceI.save(prodMoreObj);
						StoreProductMoreThanContainerDTOList.add(dtoss);
					}
				}
				foundedDTO.setContainerQuantity(0.0);
				foundedDTO.setStoreProductMoreThanContainerDTOList(StoreProductMoreThanContainerDTOList);
			}
		}
		return foundedDTO;
	}

	private ProductBatchDTO calculateContainerFromSingleForSearch(ProductBatchDTO foundedDTO)
	{
		List<StoreProductMoreThanContainerDTO> StoreProductMoreThanContainerDTOList=new ArrayList<StoreProductMoreThanContainerDTO>();
		if(foundedDTO!=null)
		{
			responseOperations<ProductContainerDTO> responseProductContainer=productContainerServiceI
					.findByProductId(foundedDTO.getProductId());
			List<ProductContainerDTO>productContainerDTOList=null;
			if(responseProductContainer!=null)
			{
				if(responseProductContainer.getListOfDTO()!=null)
				{
					productContainerDTOList=responseProductContainer.getListOfDTO();
				}
			}
			
			if(productContainerDTOList!=null && productContainerDTOList.size()==1)
			{
				foundedDTO.setContainerQuantity(Math.ceil(Double.valueOf("%.2f".formatted(foundedDTO.getSingleQuantity()/productContainerDTOList.get(0).getProductContainerQuantity()))));
			}else
			{
				for(ProductContainerDTO prodContDTO:productContainerDTOList)
				{
					StoreProductMoreThanContainer prodMoreObj=ProductMoreThanContainerServiceI.findByStoreProductIdAndContainerName(foundedDTO.getId(),prodContDTO.getContainerName());
					if(prodMoreObj!=null)
					{
						StoreProductMoreThanContainerDTO dtoss=new StoreProductMoreThanContainerDTO();
						dtoss.setId(prodMoreObj.getId());
						dtoss.setStoreProductId(foundedDTO.getId());
						dtoss.setContainerName(prodContDTO.getContainerName());
						Double quantityOfContainer=Math
								.ceil(
								Double
								.valueOf("%.2f"
										.formatted(
												foundedDTO
												.getSingleQuantity()/prodContDTO.getProductContainerQuantity())));
						dtoss.setQuantityOfProductContainer(quantityOfContainer);
						prodMoreObj.setQuantityOfProductContainer(quantityOfContainer);
						StoreProductMoreThanContainerDTOList.add(dtoss);
					}
				}
				foundedDTO.setContainerQuantity(0.0);
				foundedDTO.setStoreProductMoreThanContainerDTOList(StoreProductMoreThanContainerDTOList);
			}
		}
		return foundedDTO;

	}
	@Override
	@Transactional
	public responseOperations<ProductBatchDTO> createProductBatchProduct(ProductBatchDTO dto) {
		
		responseOperations<ProductBatchDTO> response=new responseOperations<>();
		
		try {
			if(dto.getProductId()==null)
			{
				response.setMessage("You can't leave product empty ");
				response.setState(false);
				return response;
			}else
			{
				if(dto.getPlaceId()!=null)
				{
					Optional<PlaceModel> optPlace=placeServiceI.findById(dto.getPlaceId());
					PlaceModel placeModelNew=new PlaceModel();
					if(optPlace.isPresent())
					{
						dto.setPlaceName(optPlace.get().getName());
						
					}else
					{
						placeModelNew.setName(dto.getPlaceName());
						placeModelNew=placeServiceI.save(placeModelNew);
						dto.setPlaceId(placeModelNew.getId());
					}
				}else
				{
					PlaceModel placeModelNew=new PlaceModel();
					placeModelNew.setName(dto.getPlaceName());
					placeModelNew=placeServiceI.save(placeModelNew);
					dto.setPlaceId(placeModelNew.getId());
				}
				PlaceModel placeModelNew=new PlaceModel();
				placeModelNew.setId(dto.getPlaceId());
				productModel productModel=new productModel();
				productModel.setId(dto.getProductId());
				ProductBatchModel storeProduct=new ProductBatchModel();
				storeProduct.setPlaceModel(placeModelNew);
				storeProduct.setProductModel(productModel);
				storeProduct.setQuantity(dto.getSingleQuantity());
				storeProduct.setReceivedDate(dto.getReceivedDate()!=null ? dto.getReceivedDate() : LocalDate.now());
				storeProduct.setExpirDate(dto.getExpirDate());
				storeProduct=StoreProductRepository.save(storeProduct);
				if(storeProduct.getId()!=null)
				{
					dto.setId(storeProduct.getId());
					if(dto.getProductContainerDTOList()!=null)
					{
						List<ProductContainerDTO> dtoProductContianerList=dto.getProductContainerDTOList();
						checkForProductContainerAndAddNew(dtoProductContianerList,dto);
					}else
					{
						List<ProductContainerDTO> listOfProductContainer=productContainerServiceI.findByProductId(dto.getProductId()).getListOfDTO();
						helperFunction(listOfProductContainer,dto);
					}
					response.setMessage("Store Product Created Successfully");
					response.setState(true);
					response.setDTOObject(dto);
				}else
				{
					response.setMessage("Something wrong in creating storeProduct");
					response.setState(true);
				}
				
			}
		} catch (Exception e) {
			response.setState(false);
			response.setMessage(""+e);
		}
		return response;
	}
	
	public List<ProductBatchDTO> searchProductBatch(ProductBatchSearch search) {
        Specification<ProductBatchModel> spec = Specification.where(null);

        try {
            // Filter by place ID if provided
            if (search.getPlaceId() != null) {
                spec = spec.and(ProductBatchSpecifications.hasPlaceId(search.getPlaceId()));
            }

            // Filter by product ID if provided
            if (search.getProductId() != null) {
                spec = spec.and(ProductBatchSpecifications.hasProductId(search.getProductId()));
            }

            // Filter by received date range if provided
            if (search.getReceivedDateStart() != null && search.getReceivedDateEnd() != null) {
                spec = spec.and(ProductBatchSpecifications.hasReceivedDateBetween(
                    search.getReceivedDateStart(), search.getReceivedDateEnd()));
            } else if (search.getReceivedDateStart() != null) {
                spec = spec.and(ProductBatchSpecifications.hasReceivedDateStart(search.getReceivedDateStart()));
            } else if (search.getReceivedDateEnd() != null) {
                spec = spec.and(ProductBatchSpecifications.hasReceivedDateEnd(search.getReceivedDateEnd()));
            }

            // Filter by expiry date range if provided
            if (search.getExpirDateStart() != null && search.getExpirDateEnd() != null) {
                spec = spec.and(ProductBatchSpecifications.hasExpirBetween(
                    search.getExpirDateStart(), search.getExpirDateEnd()));
            } else if (search.getExpirDateStart() != null) {
                spec = spec.and(ProductBatchSpecifications.hasExpirStart(search.getExpirDateStart()));
            } else if (search.getExpirDateEnd() != null) {
                spec = spec.and(ProductBatchSpecifications.hasExpirEnd(search.getExpirDateEnd()));
            }

            // Check if search specifies expired or non-expired
            if (search.isExpired()) {
                spec = spec.and(ProductBatchSpecifications.hasExpired());
            } else {
                spec = spec.and(ProductBatchSpecifications.hasNotExpired());
            }

            // Execute the query, convert each result to a DTO, and collect to list
            return StoreProductRepository.findAll(spec)
                .stream()
                .map(productBatchModel -> calculateContainerFromSingleForSearch(ToDTOForFirst(productBatchModel)))
                .collect(Collectors.toList());

        } catch (Exception e) {
            // Log the exception (logging is recommended for debugging purposes)
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
	
	private void checkForProductContainerAndAddNew(List<ProductContainerDTO> dtoProductContianerList, ProductBatchDTO dto)
	{
		if(dtoProductContianerList.size()==1)
		{
			ProductContainerDTO productContD=dtoProductContianerList.get(0);
			if(productContD.getId()!=null)
			{
				Optional<ProductContainer> findProductContainerById=productContainerServiceI.findById(productContD.getId());
				if(findProductContainerById.isPresent())
				{
					dto.setContainerQuantity(Math.ceil(Double.valueOf("%.2f".formatted(dto.getSingleQuantity()/findProductContainerById.get().getQuantity()))));
				}
			}else
			{
				if(productContD!=null)
				{
					productContD=productContainerServiceI.insertProductContainer(productContD).getDTOObject();	
					dto.setContainerQuantity(Math.ceil(Double.valueOf("%.2f".formatted(dto.getSingleQuantity()/productContD.getProductContainerQuantity()))));
				}
			}
		
		}else
		{
			
			List<StoreProductMoreThanContainerDTO>StoreProductMoreThanContainerDTOList=new ArrayList<StoreProductMoreThanContainerDTO>();
			for(ProductContainerDTO productContainerFromList:dtoProductContianerList)
			{
				if(productContainerFromList.getId()!=null) {
					Optional<ProductContainer> findProductContainerById=productContainerServiceI.findById(productContainerFromList.getId());
					if(findProductContainerById.isPresent())
					{
						
					}else
					{
						if(productContainerFromList!=null)
						{
							productContainerFromList.setId(null);
							productContainerFromList=productContainerServiceI.insertProductContainer(productContainerFromList).getDTOObject();
						}
					}
				}else
				{
					if(productContainerFromList!=null)
					{
						productContainerFromList=productContainerServiceI.insertProductContainer(productContainerFromList).getDTOObject();
					}
				}
				
				calculateTheQuantityOfContainersInTheListOfStoreProductMoreThanContainer(StoreProductMoreThanContainerDTOList, productContainerFromList, dto);

			}
		}
		
	}
	private void helperFunction(List<ProductContainerDTO> productContainerDTOList,ProductBatchDTO dto)
	{
		if(productContainerDTOList!=null)
		{
			if(productContainerDTOList.size()==1)
			{
				dto.setContainerQuantity(Math.ceil(Double.valueOf("%.2f".formatted(dto.getSingleQuantity()/productContainerDTOList.get(0).getProductContainerQuantity()))));
			}else
			{
				List<StoreProductMoreThanContainerDTO> StoreProductMoreThanContainerDTOList=new ArrayList<StoreProductMoreThanContainerDTO>();
				for(ProductContainerDTO prodContDTO:productContainerDTOList)
				{
					calculateTheQuantityOfContainersInTheListOfStoreProductMoreThanContainer(StoreProductMoreThanContainerDTOList,prodContDTO,dto);
				}
				dto.setStoreProductMoreThanContainerDTOList(StoreProductMoreThanContainerDTOList);
			}
			}
		}
	
	private void calculateTheQuantityOfContainersInTheListOfStoreProductMoreThanContainer(
			List<StoreProductMoreThanContainerDTO> StoreProductMoreThanContainerDTOList,
			ProductContainerDTO prodContDTO,
			ProductBatchDTO dto)
	{
		StoreProductMoreThanContainer prodMoreObj=new StoreProductMoreThanContainer();
		prodMoreObj.setContainerName(prodContDTO.getContainerName());
		prodMoreObj.setQuantityOfProductContainer(Math
				.ceil(
						Double
						.valueOf("%.2f"
								.formatted(
										dto
										.getSingleQuantity()/prodContDTO.getProductContainerQuantity()))));
		ProductBatchModel prodBatch=new ProductBatchModel();
		prodBatch.setId(dto.getId());
		prodMoreObj.setProductBatchModel(prodBatch);
		prodMoreObj= ProductMoreThanContainerServiceI.save(prodMoreObj);

		if(prodMoreObj!=null)
		{
			StoreProductMoreThanContainerDTO StoreProductMoreThanContainerDTO=new StoreProductMoreThanContainerDTO();
			StoreProductMoreThanContainerDTO.setContainerName(prodContDTO.getContainerName());
			StoreProductMoreThanContainerDTO.setQuantityOfProductContainer(Math
					.ceil(
							Double
							.valueOf("%.2f"
									.formatted(
											dto
											.getSingleQuantity()/prodContDTO.getProductContainerQuantity()))));
			StoreProductMoreThanContainerDTO.setStoreProductId(dto.getId());
			StoreProductMoreThanContainerDTO.setId(prodMoreObj.getId());
			StoreProductMoreThanContainerDTOList.add(StoreProductMoreThanContainerDTO);
		}

	}

	@Override
	public ProductBuyPriceAndSellAndQuantityAndIdRetrieve findProductQuantityByProductId(Long productId,List<Long> placeIds) {
		return StoreProductRepository.findSumQuantityAndProductNameAndProductModelBuyPriceAndProductModelSellPriceByProductModelId(productId,placeIds);
	}

	@Override
	public Double calculateTotalQuantity(Long productId) {
		return StoreProductRepository.findSumQuantityByProductId(productId);
	}


	@Override
	public List<InventoryIdAndName> findInventoryIdAndNameByProductId(Long productId) {
		return StoreProductRepository.findPlaceModelIdsAndPlaceModelNameByProductModelId(productId);
	}


	@Override
	public List<ProductBatchDTO> findProductBatchesWithCriteria(ProductBatchSearch productBatchSearch) {
		return StoreProductRepository.findProductBatchesWithCriteria(
				productBatchSearch.getPlaceId(),
				productBatchSearch.getProductId(),
				productBatchSearch.getReceivedDateStart(),
				productBatchSearch.getReceivedDateEnd(),
				productBatchSearch.getExpirDateStart(),
				productBatchSearch.getExpirDateEnd(),
				productBatchSearch.isExpired())
				.stream()
				.map(
						(ProductBatchDTO)->
						calculateContainerFromSingleForSearch(ProductBatchDTO))
				.collect(Collectors.toList());
	}
}

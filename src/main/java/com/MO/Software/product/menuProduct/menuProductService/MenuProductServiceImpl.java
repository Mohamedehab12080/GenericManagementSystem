package com.MO.Software.product.menuProduct.menuProductService;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billMenuProduct.billMenuProductService.BillMenuProductServiceInterface;
import com.MO.Software.Bill.billProducts.service.ProductSummaryDTO;
import com.MO.Software.Bill.service.billServiceInterface;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.category.menuCategory.MenuCategoryModel;
import com.MO.Software.category.menuCategory.menuCategoryService.MenuCategoryServiceInterface;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.offers.OfferModel;
import com.MO.Software.offers.offerService.offerSearch.OfferSearch;
import com.MO.Software.offers.offerService.offerSearch.OfferSpecification;
import com.MO.Software.place.storeProducts.storeProductService.ProductBatchServiceImpl;
import com.MO.Software.place.storeProducts.storeProductService.ProductBatchServiceInterface;
import com.MO.Software.place.storeProducts.storeProductService.ProductBuyPriceAndSellAndQuantityAndIdRetrieve;
import com.MO.Software.product.productModel;
import com.MO.Software.product.DTO.productDTO;
import com.MO.Software.product.menuProduct.MenuProductModel;
import com.MO.Software.product.menuProduct.DTO.MenuProductCreateRequest;
import com.MO.Software.product.menuProduct.DTO.MenuProductDTO;
import com.MO.Software.product.menuProduct.DTO.MenuProductDTOMapper;
import com.MO.Software.product.menuProduct.menuProductComponents.MenuProductComponents;
import com.MO.Software.product.menuProduct.menuProductComponents.DTO.MenuProductComponentsCreateRequest;
import com.MO.Software.product.menuProduct.menuProductComponents.DTO.MenuProductComponentsDTO;
import com.MO.Software.product.menuProduct.menuProductComponents.DTO.MenuProductComponentsDTOMapper;
import com.MO.Software.product.menuProduct.menuProductComponents.menuProductComponentsService.MenuProductComponentsServiceInterface;
import com.MO.Software.product.menuProduct.menuProductService.menuProductSearch.MenuProductSearch;
import com.MO.Software.product.menuProduct.menuProductService.menuProductSearch.MenuProductSpecification;
import com.MO.Software.product.service.productServiceInterface;
import com.MO.Software.product.service.responseOperations;

@Service
public class MenuProductServiceImpl extends baseServiceImpl<MenuProductModel, Long>
 implements MenuProductServiceInterface{

	@Autowired
	private MenuProductRepository	 MenuProductRepository;
	
	@Autowired
	private MenuProductComponentsServiceInterface MenuProductComponentsServiceI;
	
	@Autowired
	private productServiceInterface productServiceI;
	
	@Autowired
	private MenuCategoryServiceInterface MenuCategoryServiceI;
	
	@Autowired
	private ProductBatchServiceInterface ProductBatchServiceI;
	
	@Autowired
	private BillMenuProductServiceInterface BillMenuProductServiceI;
	
	@Autowired
	private billServiceInterface billServiceI;
	
	@Override
	protected baseRepository<MenuProductModel, Long> getRepository() {
		return MenuProductRepository;
	}

	@Override
	public responseOperations<MenuProductDTO> createMenuProduct(MenuProductCreateRequest cr) {
	    responseOperations<MenuProductDTO> response = new responseOperations<>();
	    StringBuilder strBuilder = new StringBuilder();

	    try {
	        // Check if the product already exists by exact name
	        MenuProductModel existingProduct = searchByExactProductName(cr.getProductName());
	        if (existingProduct != null) {
	            return buildErrorResponse(response, "The product already exists", existingProduct);
	        }

	        // Check if there are products with similar names
	        List<MenuProductModel> similarProducts = searchByProductName(cr.getProductName());
	        if (similarProducts != null && !similarProducts.isEmpty()) {
	            return buildSimilarProductsResponse(response, similarProducts);
	        }

	        // Handle category retrieval or creation
	        MenuCategoryModel categoryModel = getCategoryModel(cr, response);
	        if (categoryModel == null) {
	            return response;
	        }

	        // Create and save the new product
	        MenuProductModel newProduct = createNewProduct(cr, categoryModel);
	        newProduct = MenuProductRepository.save(newProduct);

	        // Process components
	        String componentWarning = processProductComponents(cr, newProduct, response);
	        if (!componentWarning.isEmpty()) {
	            strBuilder.append(componentWarning);
	        }

	        // Final validation and response setup
	        validateBuyPrice(cr.getBuyPrice(), response);
	        buildSuccessResponse(response, newProduct, strBuilder);

	    } catch (Exception e) {
	        response.setMessage("An error occurred: " + e.getMessage());
	        response.setState(false);
	    }
	    return response;
	}

	// Helper method to handle category retrieval or creation without using Optional
	private MenuCategoryModel getCategoryModel(MenuProductCreateRequest cr, responseOperations<MenuProductDTO> response) {
	    MenuCategoryModel categoryModel = null;

	    if (cr.getMenuCategoryId() != null) {
	        // Retrieve category by ID
	       
	        Optional<MenuCategoryModel> optMenCat=MenuCategoryServiceI.findById(cr.getMenuCategoryId());
	        if(optMenCat.isPresent())
	        {
	        	categoryModel=optMenCat.get();
	        	if (categoryModel == null && cr.getMenuCategoryName() != null) {
		            // If category not found by ID, create a new category with the given name
		            categoryModel = createNewCategory(cr.getMenuCategoryName(), response);
		        }
	        }else
	        {
	        	// Category not found by ID and no name provided to create a new one
	            response.setMessage("This Menu Category Not found for id: " + cr.getMenuCategoryId());
	            response.setState(false);
	            return null;
	        }
	        
	    } else if (cr.getMenuCategoryName() != null) {
	        // Retrieve category by exact name
	        categoryModel = MenuCategoryServiceI.findByExactCategoryName(cr.getMenuCategoryName());
	        if (categoryModel == null) {
	            // If category not found by name, create a new category
	            categoryModel = createNewCategory(cr.getMenuCategoryName(), response);
	        }
	    } else {
	        // If neither category ID nor name is provided, return an error response
	        response.setMessage("You can't leave the category empty.");
	        response.setState(false);
	        return null;
	    }

	    return categoryModel;
	}

	// Helper method to create a new category
	private MenuCategoryModel createNewCategory(String categoryName, responseOperations<MenuProductDTO> response) {
	    if (categoryName != null) {
	        MenuCategoryModel newCategory = new MenuCategoryModel();
	        newCategory.setCategoryName(categoryName);
	        return MenuCategoryServiceI.save(newCategory);
	    } else {
	        response.setMessage("Category name is required.");
	        response.setState(false);
	        return null;
	    }
	}


	// Helper method to create a new product
	private MenuProductModel createNewProduct(MenuProductCreateRequest cr, MenuCategoryModel categoryModel) {
	    MenuProductModel newProduct = new MenuProductModel();
	    newProduct.setProductName(cr.getProductName());
	    newProduct.setBuyPrice(cr.getBuyPrice());
	    newProduct.setSellPrice(cr.getSellPrice());
	    double gainedPercentage = ((cr.getSellPrice() - cr.getBuyPrice()) * cr.getBuyPrice()) / 100;
	    newProduct.setGainedPercentage(gainedPercentage);
	    newProduct.setMenuCategoryModel(categoryModel);
	    return newProduct;
	}

	// Helper method to process product components
	private String processProductComponents(MenuProductCreateRequest cr, MenuProductModel newProduct, responseOperations<MenuProductDTO> response) {
	    StringBuilder warningBuilder = new StringBuilder();
	    List<MenuProductComponentsDTO> componentDTOs = new ArrayList<>();
	    double sumOfBuyPrice = 0.0;
	    double countOfProductDependingOnComponents = 0.0;
	    int countOfComponents = 0;

	    List<MenuProductComponentsCreateRequest> components = cr.getMenuProductComponentsCreateRequestList();
	    if (components != null) {
	        for (MenuProductComponentsCreateRequest compCreate : components) {
	            ProductBuyPriceAndSellAndQuantityAndIdRetrieve retrievals = ProductBatchServiceI
	                    .findProductQuantityByProductId(compCreate.getProductId(), compCreate.getPlaceForConsumingId());
	            if (retrievals != null) {
	                sumOfBuyPrice += (retrievals.getBuyPrice() * compCreate.getQuantity());
	                countOfProductDependingOnComponents += (retrievals.getQuantity() / compCreate.getQuantity());
	            }
	            if (retrievals.getQuantity() < compCreate.getQuantity()) {
	                warningBuilder.append("Warning: Component ").append(retrievals.getProductName())
	                        .append(" not available for consuming. You can't make this product order until you replenish this component!\n");
	            }

	            // Save the component
	            MenuProductComponents component = new MenuProductComponents();
	            component.setQuantity(compCreate.getQuantity());
	           productModel prodM= new productModel();
	           prodM.setId(compCreate.getProductId());
	            component.setProductModel(prodM);
	            component.setMenuProductModel(newProduct);
	            MenuProductComponentsServiceI.save(component);
	            componentDTOs.add(MenuProductComponentsDTOMapper.mapMenuProductComponentsToDTO(component));

	            countOfComponents++;
	        }
	    }
	    double approxCount = Double.valueOf("%.2f".formatted(countOfProductDependingOnComponents / countOfComponents));
	    response.getDTOObject().setCount(approxCount);

	    return warningBuilder.toString();
	}

	// Helper method to validate buy price
	private void validateBuyPrice(Double sentBuyPrice, responseOperations<MenuProductDTO> response) {
	    double sumOfBuyPrice = response.getDTOObject().getBuyPrice();
	    if (sumOfBuyPrice > sentBuyPrice) {
	        response.setMessage("Warning: The real buy price of your product is higher than specified. Actual buy price: " + sumOfBuyPrice);
	    }
	}

	// Helper method to build success response
	private void buildSuccessResponse(responseOperations<MenuProductDTO> response, MenuProductModel newProduct, StringBuilder strBuilder) {
	    MenuProductDTO dto = MenuProductDTOMapper.mapMenuProductModelToDTO(newProduct);
	    response.setMessage("Created successfully with approximation of count is (" + dto.getCount() + ")\n" + strBuilder.toString());
	    response.setState(true);
	    response.setDTOObject(dto);
	}

	// Helper method to build error response if the product already exists
	private responseOperations<MenuProductDTO> buildErrorResponse(responseOperations<MenuProductDTO> response, String message, MenuProductModel product) {
	    response.setMessage(message);
	    response.setState(false);
	    response.setDTOObject(MenuProductDTOMapper.mapMenuProductModelToDTO(product));
	    return response;
	}

	// Helper method to build response with similar products
	private responseOperations<MenuProductDTO> buildSimilarProductsResponse(responseOperations<MenuProductDTO> response, List<MenuProductModel> similarProducts) {
	    response.setState(false);
	    response.setMessage("This Product seems to be predefined");
	    response.setListOfDTO(similarProducts.stream().map(MenuProductDTOMapper::mapMenuProductModelToDTO).collect(Collectors.toList()));
	    return response;
	}


	@Override
	public List<MenuProductModel> searchByProductName(String productName) {
		return MenuProductRepository.findByProductName(productName);
	}

	@Override
	public MenuProductModel searchByExactProductName(String productName) {
		return MenuProductRepository.findByProductNameDistinct(productName);
	}

	@Override
	public List<MenuProductModel> findProductModelByCategoryId(Long id) {
		return MenuProductRepository.findByMenuCategoryId(id);
	}

	@Override
	public List<MenuProductModel> searchMenuProduct(MenuProductSearch menuProductSearch) {
	    
	    Specification<MenuProductModel> spec = Specification.where(null);

	    if (menuProductSearch.getProductName() != null && !menuProductSearch.getProductName().isEmpty()) {
	        spec = spec.and(MenuProductSpecification.hasName(menuProductSearch.getProductName()));
	    }

	    if (menuProductSearch.getMinBuyPrice() != null || menuProductSearch.getMaxBuyPrice() != null) {
	        spec = spec.and(MenuProductSpecification.menuProductBuyPriceBetween(
	            menuProductSearch.getMinBuyPrice(),
	            menuProductSearch.getMaxBuyPrice()
	        ));
	    }

	    if (menuProductSearch.getMinSellPrice() != null || menuProductSearch.getMaxSellPrice() != null) {
	        spec = spec.and(MenuProductSpecification.menuProductSellPriceBetween(
	            menuProductSearch.getMinSellPrice(),
	            menuProductSearch.getMaxSellPrice()
	        ));
	    }

	    if (menuProductSearch.getMenuCategoryId() != null) {
	        spec = spec.and(MenuProductSpecification.hasCategoryId(menuProductSearch.getMenuCategoryId()));
	    }

	    return MenuProductRepository.findAll(spec);
	}



	private String processProductComponentsForUpdate(MenuProductUpdateRequest cr, MenuProductModel newProduct, responseOperations<MenuProductDTO> response) {
	    StringBuilder warningBuilder = new StringBuilder();
	    List<MenuProductComponentsDTO> componentDTOs = new ArrayList<>();
	    double sumOfBuyPrice = 0.0;
	    double countOfProductDependingOnComponents = 0.0;
	    int countOfComponents = 0;

	    List<MenuProductComponentsCreateRequest> components = cr.getMenuProductComponentsCreateRequestList();
	    if (components != null) {
	        for (MenuProductComponentsCreateRequest compCreate : components) {
	            ProductBuyPriceAndSellAndQuantityAndIdRetrieve retrievals = ProductBatchServiceI
	                    .findProductQuantityByProductId(compCreate.getProductId(), compCreate.getPlaceForConsumingId());
	            if (retrievals != null) {
	                sumOfBuyPrice += (retrievals.getBuyPrice() * compCreate.getQuantity());
	                countOfProductDependingOnComponents += (retrievals.getQuantity() / compCreate.getQuantity());
	            }
	            if (retrievals.getQuantity() < compCreate.getQuantity()) {
	                warningBuilder.append("Warning: Component ").append(retrievals.getProductName())
	                        .append(" not available for consuming. You can't make this product order until you replenish this component!\n");
	            }

	            // Save the component
	            Optional<MenuProductComponents> optMenProdComp=MenuProductComponentsServiceI.findById(compCreate.getMenuProductComponentId());
	            MenuProductComponents component=null;
	            MenuProductComponentsDTO componentDTO=null;
	            if(!optMenProdComp.isPresent())
	            {
	            	component= new MenuProductComponents();
		            component.setQuantity(compCreate.getQuantity());
		           productModel prodM= new productModel();
		           prodM.setId(compCreate.getProductId());
		            component.setProductModel(prodM);
		            component.setMenuProductModel(newProduct);
		            componentDTO= MenuProductComponentsDTOMapper.mapMenuProductComponentsToDTO(component);
		            component=MenuProductComponentsServiceI.save(component);
		            componentDTO.setId(component.getId());
		            componentDTOs.add(componentDTO);
		            countOfComponents++;

	            }else
	            {
	            	component=optMenProdComp.get();
	            	component.setQuantity(compCreate.getQuantity());
	            	componentDTO=MenuProductComponentsDTOMapper.mapMenuProductComponentsToDTO(component);
	            	MenuProductComponentsServiceI.save(component);
	            }
	            
	            if(componentDTO!=null)
	            {
	            	componentDTOs.add(componentDTO);
	            }
	         }
	    }
	    double approxCount = Double.valueOf("%.2f".formatted(countOfProductDependingOnComponents / countOfComponents));
	    response.getDTOObject().setCount(approxCount);

	    return warningBuilder.toString();
	}

	@Override
	public responseOperations<MenuProductDTO> updateProductAllData(MenuProductUpdateRequest menuProductUpdateRequest) {
		responseOperations<MenuProductDTO> response=new responseOperations<MenuProductDTO>();
		
		try {
			Optional<MenuProductModel> menProdModel=MenuProductRepository.findById(menuProductUpdateRequest.getMenuProductId());
			StringBuilder builder=new StringBuilder();
			if(!menProdModel.isPresent())
			{
				response.setState(false);
				response.setMessage("Menu Product For this id not found");
				return response;
			}else
			{
				MenuProductModel menProduct=menProdModel.get();
				if(menuProductUpdateRequest.getBuyPrice()!=null)
				{
					menProduct.setBuyPrice(menuProductUpdateRequest.getBuyPrice());
				}
				if(menuProductUpdateRequest.getSellPrice()!=null)
				{
					menProduct.setSellPrice(menuProductUpdateRequest.getSellPrice());
				}
				if(menuProductUpdateRequest.getGainPercentage()!=null)
				{
					menProduct.setGainedPercentage(menuProductUpdateRequest.getGainPercentage());
				}
				if(menuProductUpdateRequest.getProductName()!=null)
				{
					menProduct.setProductName(menuProductUpdateRequest.getProductName());
				}
				if(menuProductUpdateRequest.getComponentsToDelete()!=null && !menuProductUpdateRequest.getComponentsToDelete().isEmpty())
				{
					menuProductUpdateRequest.getComponentsToDelete()
                    .forEach(MenuProductRepository::deleteById);
				}
				if(menuProductUpdateRequest.getMenuProductComponentsCreateRequestList()!=null &&
						!menuProductUpdateRequest.getMenuProductComponentsCreateRequestList().isEmpty())
				{
					builder.append(processProductComponentsForUpdate(menuProductUpdateRequest,menProduct,response));
				}
				builder.append("/n Menu product updated successfully");
				response.setState(true);
				response.setMessage(builder.toString());
				response.setDTOObject(MenuProductDTOMapper.mapMenuProductModelToDTO(menProduct));
			} 
		} catch (Exception e) {
			response.setState(false);
			response.setMessage("Error in updating Menu Product: "+e);
		}
		return response;
	}

	
	@Override
	public List<ProductSummaryDTO> menuProductReportwithBillSearch(billSearch billSearch) {
		return  BillMenuProductServiceI.findByBillIds(billServiceI.findBillIdsBySearch(billSearch));
	}
}


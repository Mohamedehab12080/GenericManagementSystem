package com.MO.Software.product.productContainers.productContainerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.place.storeProducts.containers.Container;
import com.MO.Software.place.storeProducts.containers.containerService.ContainerServiceInterface;
import com.MO.Software.product.productModel;
import com.MO.Software.product.productContainers.ProductContainer;
import com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTO;
import com.MO.Software.product.productContainers.productContainerDTO.ProductContainerDTOMapper;
import com.MO.Software.product.service.productServiceInterface;
import com.MO.Software.product.service.responseOperations;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.transaction.Transactional;

@Service
public class ProductContainerServiceImpl 
extends baseServiceImpl<ProductContainer,Long>
 implements productContainerServiceInterface{

	@Autowired
	private ProductContainerRepository productContainerRepository;
	
	@Autowired
	private ContainerServiceInterface ContainerServiceI;
	@Autowired
	private productServiceInterface productServiceI;
	@Override
	protected baseRepository<ProductContainer, Long> getRepository() {
		return productContainerRepository;
	}

	@Override
	public responseOperations<ProductContainerDTO> findByProductId(Long productId) {
		responseOperations<ProductContainerDTO> response =new responseOperations<>();
		List<ProductContainerDTO> DtoList=productContainerRepository.findByProductId(productId);
		if(DtoList.isEmpty())
		{
			response.setState(false);
			response.setMessage("No Data For this request");
		}
		response.setState(true);
		response.setMessage("Data fetched");
		response.setListOfDTO(DtoList);
		return response;
	}

	@Override
	public List<Long> findProductIdByContainerId(Long containerId) {
		return productContainerRepository.findByContainerId(containerId);
	}

	@Override
	@Transactional
	public responseOperations<ProductContainerDTO> insertProductContainer(ProductContainerDTO dto) {
	    
		responseOperations<ProductContainerDTO> response = new responseOperations<>();
	    try {
	        if (dto.getProductId() == null || dto.getProductName() == null) {
	            response.setState(false);
	            response.setMessage("Product ID and name cannot be empty.");
	            return response;
	        }

	        Optional<productModel> productOpt = productServiceI.findById(dto.getProductId());
	        if (!productOpt.isPresent()) {
	            response.setState(false);
	            response.setMessage("Invalid product ID.");
	            return response;
	        }

	        if (dto.getContainerId() != null) {
	            ProductContainerDTO existingContainer = productContainerRepository.findByProductIdAndContainerId(dto.getProductId(), dto.getContainerId());
	            if (existingContainer != null) {
	                response.setState(false);
	                response.setMessage("This product container already exists.");
	                response.setDTOObject(existingContainer);
	                return response;
	            }
	        }

	        ProductContainer productContainerToAdd = ProductContainerDTOMapper.mapDTOToProductContainer(dto);

	        Container container = findOrCreateContainer(dto.getContainerId(),dto.getContainerName());
	        if (container == null) {
	            response.setState(false);
	            response.setMessage("Error in creating or finding the container.");
	            return response;
	        }

	        productContainerToAdd.setContainer(container);
	        ProductContainer savedContainer = productContainerRepository.save(productContainerToAdd);

	        if (savedContainer == null) {
	            response.setState(false);
	            response.setMessage("Error creating product container.");
	        } else {
	            dto.setId(savedContainer.getId());
	            response.setMessage("The product container was created successfully.");
	            response.setState(true);
	            response.setDTOObject(dto);
	        }

	    } catch (Exception e) {
	        response.setState(false);
	        response.setMessage("Error: " + e.getMessage());
	    }

	    return response;
	}

	private Container findOrCreateContainer(Long containerId,String containerName) {
	    if (containerId != null) {
	        return ContainerServiceI.findById(containerId).orElse(null);
	    }

	    if (containerName == null) {
	        return null;
	    }

	    Container newContainer = new Container();
	    newContainer.setName(containerName);
	    return ContainerServiceI.save(newContainer);
	}

}

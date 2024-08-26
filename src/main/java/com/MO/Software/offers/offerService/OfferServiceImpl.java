package com.MO.Software.offers.offerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.MO.Software.Bill.billOffers.billOffersService.BillOffersServiceInterface;
import com.MO.Software.Bill.billOffers.billOffersService.OfferSummaryDTO;
import com.MO.Software.Bill.service.billServiceInterface;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.employee.employeeService.billSearch;
import com.MO.Software.offers.OfferModel;
import com.MO.Software.offers.offerDTO.OfferDTO;
import com.MO.Software.offers.offerDTO.OfferDTOMapper;
import com.MO.Software.offers.offerService.offerSearch.OfferSearch;
import com.MO.Software.offers.offerService.offerSearch.OfferSpecification;
import com.MO.Software.offers.offersProducts.OfferProductsModel;
import com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTO;
import com.MO.Software.offers.offersProducts.offerProductsDTO.OfferProductsDTOMapper;
import com.MO.Software.offers.offersProducts.offerProductsService.OfferProductsServiceInterface;
import com.MO.Software.product.service.responseOperations;

import jakarta.transaction.Transactional;

@Service
public class OfferServiceImpl
extends baseServiceImpl<OfferModel,Long> 
implements OfferServiceInterface{

	@Autowired
	private OfferRepository OfferRepository;
	
	@Autowired
	private OfferProductsServiceInterface OfferProductsServiceI;
	
	@Autowired
	private billServiceInterface billServiceI;
	
	@Autowired
	private BillOffersServiceInterface BillOffersServiceI;
	
	@Override
	protected baseRepository<OfferModel, Long> getRepository() {
		return OfferRepository;
	}
	
	@Override
	public List<OfferModel> searchOffers(OfferSearch offerSearch) {
		
		Specification<OfferModel> spec = Specification.where(null);

        if (offerSearch.getName() != null) {
            spec = spec.and(OfferSpecification.hasName(offerSearch.getName()));
        }

        if (offerSearch.getStartDate() != null) {
            spec = spec.and(OfferSpecification.hasStartDate(offerSearch.getStartDate()));
        } else if (offerSearch.getStartYear() != null && offerSearch.getStartMonth() != null) {
            spec = spec.and(OfferSpecification.hasStartDateYearAndMonth(offerSearch.getStartYear(), offerSearch.getStartMonth()));
        } else if (offerSearch.getStartYear() != null) {
            spec = spec.and(OfferSpecification.hasStartDateYear(offerSearch.getStartYear()));
        }

        // Handle end date with varying levels of precision
        if (offerSearch.getEndDate() != null) {
            spec = spec.and(OfferSpecification.hasEndDate(offerSearch.getEndDate()));
        }

        if (offerSearch.getExpired() != null) {
            spec = spec.and(OfferSpecification.hasExpired(offerSearch.getExpired()));
        }

        return OfferRepository.findAll(spec);
    
	}
	
	@Override
	public List<OfferSummaryDTO> findSummaryOfSoldOffersDependOnBillsSearch(billSearch billSearch)
	{
		try {
			List<Long> billIds=billServiceI.findBillIdsBySearch(billSearch);
			if(billIds!=null)
			{
				return BillOffersServiceI.findOffersSummaryByBillModelIds(billIds);
			}else
			{
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<OfferSummaryDTO> findOffersSummaryByBillSearchAndOfferIds(
			billSearch billSearch,
			OfferSearch offerSearch)
	{
		try {
			List<Long> billIds=billServiceI.findBillIdsBySearch(billSearch);
			List<Long> offerIds=new ArrayList<Long>();
			List<OfferModel> findAllOffers=searchOffers(offerSearch);
			if(findAllOffers!=null)
			{
				for(OfferModel offer:findAllOffers)
				{
					offerIds.add(offer.getId());
				}
			}
			if(billIds!=null)
			{
				return BillOffersServiceI.findOffersSummaryByBillModelIdsAndOfferIds(billIds,offerIds);
			}else
			{
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	@Transactional
	@Override
	public responseOperations<OfferDTO> updateOffer(UpdateOfferRequest updateRequest) {
	    StringBuilder message = new StringBuilder();
	    responseOperations<OfferDTO> response = new responseOperations<>();

	    try {
	        OfferDTO offerDTO = updateRequest.getOfferDTO();
	        Optional<OfferModel> optionalOffer = findById(offerDTO.getId());

	        if (optionalOffer.isPresent()) {
	            OfferModel offer = optionalOffer.get();
	            OfferDTO oldOffer = OfferDTOMapper.mapOfferToDTO(offer);

	            handleProductsToDelete(updateRequest.getOfferProductsToDelete(), message);

	            List<OfferProductsDTO> updatedProductsList = updateOrAddProducts(
	                oldOffer.getOfferProductsDTOList(),
	                updateRequest.getOfferProductsDTOListToAdd(),
	                oldOffer.getId()
	            );

	            updateOfferDetails(offerDTO, oldOffer, updatedProductsList);

	            OfferModel updatedOffer = OfferRepository.save(OfferDTOMapper.mapDTOToOffer(oldOffer));
	            if (updatedOffer != null) {
	                response.setState(true);
	                response.setDTOObject(oldOffer);
	                message.append("تم التعديل علي العرض بنجاح");
	            } else {
	                response.setState(false);
	                message.append("حدث خطأ أثناء تحديث العرض.");
	            }

	        } else {
	            response.setState(false);
	            message.append("العرض غير موجود.");
	        }

	        response.setMessage(message.toString());
	    } catch (Exception e) {
	        response.setState(false);
	        response.setMessage("An exception occurred: " + e.getMessage());
	    }

	    return response;
	}

	private void handleProductsToDelete(List<Long> idsOfProductsToDelete, StringBuilder message) {
	    if (idsOfProductsToDelete != null) {
	        idsOfProductsToDelete.forEach(idToDelete -> {
	            Optional<OfferProductsModel> foundProduct = OfferProductsServiceI.findById(idToDelete);
	            if (foundProduct.isPresent()) {
	                OfferProductsServiceI.deleteById(idToDelete);
	            } else {
	                message.append("المنتج صاحب ال id (").append(idToDelete).append(") غير متوفر. ");
	            }
	        });
	    }
	}

	private List<OfferProductsDTO> updateOrAddProducts(List<OfferProductsDTO> existingProductsList, 
	                                                   List<OfferProductsDTO> productsToAdd, Long offerId) {
	    if (productsToAdd != null) {
	        productsToAdd.forEach(product -> {
	            product.setOfferId(offerId);
	            OfferProductsDTO existingProduct = OfferProductsServiceI.findByOfferIdAndProductId(offerId, product.getProductId());
	            
	            if (existingProduct != null) {
	                existingProduct.setQuantity(product.getQuantity());
	                replaceObjectById(existingProductsList, existingProduct);
	            } else {
	                OfferProductsModel createdProduct = OfferProductsServiceI.save(OfferProductsDTOMapper.mapDTOToOfferProducts(product));
	                if (createdProduct != null) {
	                    product.setId(createdProduct.getId());
	                    existingProductsList.add(product);
	                }
	            }
	        });
	    }
	    return existingProductsList;
	}

	private void updateOfferDetails(OfferDTO offerDTO, OfferDTO oldOffer, List<OfferProductsDTO> updatedProductsList) {
	    oldOffer.setOfferProductsDTOList(updatedProductsList);

	    if (offerDTO.getStartDate()!=null) {
	        oldOffer.setStartDate(offerDTO.getStartDate());
	    }
	    if (offerDTO.getName()!=null && !offerDTO.getName().isEmpty()) {
	        oldOffer.setName(offerDTO.getName());
	    }
	    if (offerDTO.getEndDate()!=null) {
	        oldOffer.setEndDate(offerDTO.getEndDate());
	    }
	    if (offerDTO.getOfferBuyPrice()!=null) {
	        oldOffer.setOfferBuyPrice(offerDTO.getOfferBuyPrice());
	    }
	    if (offerDTO.getOfferSellPrice()!=null) {
	        oldOffer.setOfferSellPrice(offerDTO.getOfferSellPrice());
	    }
	}

	private void replaceObjectById(List<OfferProductsDTO> offerProductsList, OfferProductsDTO newObject) {
	    for (int i = 0; i < offerProductsList.size(); i++) {
	        if (offerProductsList.get(i).getId().equals(newObject.getId())) {
	            offerProductsList.set(i, newObject);
	            return;
	        }
	    }
	    System.out.println("Object with ID " + newObject.getId() + " not found.");
	}

	@Transactional
	@Override
	public responseOperations<OfferDTO> createOffer(OfferDTO offerDTO)
	{
		responseOperations<OfferDTO>response=new responseOperations<OfferDTO>();
		List<OfferProductsDTO> offerProductsDTO=offerDTO.getOfferProductsDTOList();
		if(offerProductsDTO!=null)
		{
			OfferModel addedOffer=OfferRepository.save(OfferDTOMapper.mapDTOToOffer(offerDTO));
			if(addedOffer!=null)
			{
				offerDTO.setId(addedOffer.getId());
				for(OfferProductsDTO offerProd:offerProductsDTO)
				{
					offerProd.setOfferId(addedOffer.getId());
					
					OfferProductsModel savedOfferProduct=OfferProductsServiceI.save(
							OfferProductsDTOMapper
							.mapDTOToOfferProducts(offerProd));
					
					offerProd.setId(savedOfferProduct.getId());
				}
				offerDTO.setOfferProductsDTOList(offerProductsDTO);
				response.setState(true);
				response.setMessage("تم انشاء العرض بنجاح");
			}else
			{
				response.setState(false);
				response.setMessage("حدث خطأ");
			}
		}else
		{
			response.setState(false);
			response.setMessage("لا يوجد منتجات داخل العرض");
		}
		 response.setDTOObject(offerDTO);
		 return response;
	}

	

	@Override
	public void handleExpiredOffers() {
		List<OfferModel> offers = findAll();
        for (OfferModel offer : offers) {
            if (checkIfExpired(offer)) {
                offer.setExpired(true);
                OfferRepository.save(offer);
            }
        }
		
	}

	@Override
	public boolean checkIfExpired(OfferModel offer) {
        return offer.getEndDate().isBefore(LocalDate.now());
	}

	@Override
	public List<OfferModel> findAll() {
        return OfferRepository.findAll();
	}

	@Override
	public List<OfferModel> getExpiredOffers() {
        return OfferRepository.findExpired();
	}

	@Override
	public List<OfferModel> getLiveOffers() {
		return OfferRepository.findNotExpired();
	}

}

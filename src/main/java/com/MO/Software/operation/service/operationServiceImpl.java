package com.MO.Software.operation.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.operation.operationModel;
import com.MO.Software.operation.DTO.operationDTO;
import com.MO.Software.operation.DTO.operationDTOMapper;

@Service
public class operationServiceImpl extends baseServiceImpl<operationModel,Integer>
implements operationServiceInterface{

	@Autowired
	private operationRepository operationRepository;
	@Override
	protected baseRepository<operationModel, Integer> getRepository() {
		return operationRepository;
	}
	@Override
	public void insertAllOperations(List<operationModel> entities) {
		 operationRepository.saveAll(entities);
		
	}
	@Override
	public List<operationDTO> findByPageId(Integer pageId) {
		List<operationModel> opModel=operationRepository.findByPageModelId(pageId);
		if(opModel!=null)
		{
			return opModel.stream().map(operationDTOMapper::mapOperationModelToDTO).collect(Collectors.toList());
		}else
		{
			return Collections.emptyList();
		}
	}

}

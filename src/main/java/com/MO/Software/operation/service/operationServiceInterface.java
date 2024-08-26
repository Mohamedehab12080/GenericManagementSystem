package com.MO.Software.operation.service;

import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.operation.operationModel;
import com.MO.Software.operation.DTO.operationDTO;

public interface operationServiceInterface extends baseServiceInterface<operationModel,Integer>{

	void insertAllOperations(List<operationModel> entities);
	List<operationDTO> findByPageId(Integer pageId);
}

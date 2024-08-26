package com.MO.Software.operation.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.operation.operationModel;

@Repository
public interface operationRepository extends baseRepository<operationModel,Integer>{

	@Query("Select op from operationModel op where op.pageModel.id=:pageId")
	List<operationModel> findByPageModelId(Integer pageId);
}

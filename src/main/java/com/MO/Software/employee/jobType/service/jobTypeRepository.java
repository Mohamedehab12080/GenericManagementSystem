package com.MO.Software.employee.jobType.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.employee.jobType.jobTypeModel;

@Repository
public interface jobTypeRepository extends baseRepository<jobTypeModel,Long>{

	@Query("SELECT j from jobTypeModel j where j.name=:name")
	jobTypeModel findByName(String name);

}

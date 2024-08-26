package com.MO.Software.employee.jobType.service;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.employee.jobType.jobTypeModel;

public interface jobTypeServiceInterface extends baseServiceInterface<jobTypeModel,Long>{

	jobTypeModel findByName(String name);
}

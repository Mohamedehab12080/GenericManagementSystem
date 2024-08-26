package com.MO.Software.operation.pages.service;

import java.util.List;

import com.MO.Software.base.baseServiceInterface;
import com.MO.Software.operation.pages.pageModel;

public interface pageServiceInterface extends baseServiceInterface<pageModel,Integer> {

	void insertAllPages(List<pageModel> entities);
}

package com.MO.Software.place.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.place.PlaceModel;

@Service
public class PlaceServiceImpl 
extends baseServiceImpl<PlaceModel,Long>
 implements PlaceServiceInterface{

	@Autowired
	private PlaceRepository PlaceRepository; 
	
	@Override
	protected baseRepository<PlaceModel, Long> getRepository() {
		return PlaceRepository;
	}

}

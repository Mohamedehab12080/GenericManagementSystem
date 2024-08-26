package com.MO.Software.place.service;

import org.springframework.stereotype.Repository;

import com.MO.Software.base.baseRepository;
import com.MO.Software.place.PlaceModel;

@Repository
public interface PlaceRepository 
extends baseRepository<PlaceModel
, Long>{

}

package com.MO.Software.place.storeProducts.containers.containerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;
import com.MO.Software.place.storeProducts.containers.Container;

@Service
public class ContainerService
extends baseServiceImpl<Container, Long>
 implements ContainerServiceInterface
 {

	@Autowired
	private ContainerRepository ContainerRepository;
	
	@Override
	protected baseRepository<Container, Long> getRepository() {
		return ContainerRepository;
	}

	
}

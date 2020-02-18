package com.sparknetworks.filterhandler.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sparknetworks.filterhandler.services.FilterService;
import com.sparknetworks.model.FilterHandlerResponse;

@Component
public class FilterBusiness {
    
	@Autowired
	private FilterService service;
	
	public FilterHandlerResponse getAll() {
		service.getAll();
		return null;
		
	}
}

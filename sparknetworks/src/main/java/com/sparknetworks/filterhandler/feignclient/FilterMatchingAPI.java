package com.sparknetworks.filterhandler.feignclient;

import com.sparknetworks.model.FilterHandlerResponse;

public interface FilterMatchingAPI {
	
	FilterHandlerResponse getAll();
}

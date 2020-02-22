package com.sparknetworks.filterhandler.services;

import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

public interface FilterService {
	FilterHandlerResponse getAll();

	PersonDetailsModel login(LoginRequestModel request);

	FilterHandlerResponse getAllByFilter(FilterHandlerRequest request);
}

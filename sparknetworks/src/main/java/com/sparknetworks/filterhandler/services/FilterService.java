package com.sparknetworks.filterhandler.services;

import java.util.List;

import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

public interface FilterService {
	List<PersonDetailsModel> getAll();

	PersonDetailsModel login(LoginRequestModel request);
	
	 List<PersonDetailsModel> getAllByFilter(FilterHandlerRequest request);
}

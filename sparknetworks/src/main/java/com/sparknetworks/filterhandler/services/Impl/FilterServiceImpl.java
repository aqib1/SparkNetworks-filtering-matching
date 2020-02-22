package com.sparknetworks.filterhandler.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparknetworks.filterhandler.feignclient.FilterMatchingAPI;
import com.sparknetworks.filterhandler.services.FilterService;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private FilterMatchingAPI api;

	@Override
	public FilterHandlerResponse getAll() {
			return api.getAll();
	}

	@Override
	public PersonDetailsModel login(LoginRequestModel request) {
		return api.login(request);
	}

	@Override
	public FilterHandlerResponse getAllByFilter(FilterHandlerRequest request) {
		return api.filter(request);
	}

}

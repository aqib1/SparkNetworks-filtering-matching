package com.sparknetworks.filterhandler.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparknetworks.filterhandler.exceptions.DataNotFoundException;
import com.sparknetworks.filterhandler.feignclient.FilterMatchingAPI;
import com.sparknetworks.filterhandler.services.FilterService;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private FilterMatchingAPI api;

	@Override
	public List<PersonDetailsModel> getAll() {
		try {
			return api.getAll().getMatches();
		} catch (NullPointerException e) {
			throw new DataNotFoundException("Data not recieved from service", e);
		}
	}

	@Override
	public PersonDetailsModel login(LoginRequestModel request) {
		return api.login(request);
	}

	@Override
	public List<PersonDetailsModel> getAllByFilter(FilterHandlerRequest request) {
		return api.filter(request).getMatches();
	}

}

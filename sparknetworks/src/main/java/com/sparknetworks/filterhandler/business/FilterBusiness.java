package com.sparknetworks.filterhandler.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sparknetworks.filterhandler.services.FilterService;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

@Component
public class FilterBusiness {

	@Autowired
	private FilterService service;

	public PersonDetailsModel login(LoginRequestModel request) {
		return service.login(request);
	}

	public List<PersonDetailsModel> getAll() {
		return service.getAll();
	}
}

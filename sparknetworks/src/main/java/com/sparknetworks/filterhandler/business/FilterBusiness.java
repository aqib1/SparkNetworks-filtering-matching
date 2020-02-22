package com.sparknetworks.filterhandler.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sparknetworks.filterhandler.services.FilterService;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 19/02/2020
 */
@Component
public class FilterBusiness {

	@Autowired
	private FilterService service;

	/**
	 * @param request
	 * @return
	 */
	public FilterHandlerResponse getAllByFilter(FilterHandlerRequest request) {
		return service.getAllByFilter(request);
	}

	/**
	 * @param request
	 * @return
	 */
	public PersonDetailsModel login(LoginRequestModel request) {
		return service.login(request);
	}

	/**
	 * @return
	 */
	public FilterHandlerResponse getAll() {
		return service.getAll();
	}
}

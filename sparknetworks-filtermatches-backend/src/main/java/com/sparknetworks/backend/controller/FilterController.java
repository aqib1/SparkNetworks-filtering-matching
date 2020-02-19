package com.sparknetworks.backend.controller;

import static com.sparknetworks.backend.utils.Const.FILTER_URL;
import static com.sparknetworks.backend.utils.Const.LOGIN_URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparknetworks.backend.business.FilterBusiness;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

@RestController
@RequestMapping(FILTER_URL)
public class FilterController {

	private static final Logger logger = LoggerFactory.getLogger(FilterController.class);

	@Autowired
	private FilterBusiness business;

	@PostMapping(LOGIN_URL)
	public PersonDetailsModel login(LoginRequestModel request) {
		logger.info("Request recieved for filter with LoginRequestModel [" + request + "]");
		return business.login(request);
	}
	
	
	@PostMapping
	public FilterHandlerResponse filter(@RequestBody FilterHandlerRequest request) {
		logger.info("Request recieved for filter with filterHandlerRequest [" + request + "]");
		return business.filter(request);
	}

	@GetMapping
	public FilterHandlerResponse getAll() {
		logger.info("Request recieved for getting all person details");
		return business.getAll();
	}
}

package com.sparknetworks.backend.controller;

import static com.sparknetworks.backend.utils.Const.FILTER_URL;
import static com.sparknetworks.backend.utils.Const.LOGIN_URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sparknetworks.backend.business.FilterBusiness;
import com.sparknetworks.backend.exceptions.ServiceNotAvailableException;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 15/02/2020
 */
@RestController
@RequestMapping(FILTER_URL)
public class FilterController {

	private static final Logger logger = LoggerFactory.getLogger(FilterController.class);

	@Autowired
	private FilterBusiness business;

	/**
	 * @param request
	 * @return
	 */
	@PostMapping(LOGIN_URL)
	// In the case of error, or exception fallback method are produced.
	// As i am using Controller advice, but if you like to utilize circuit breaker
	// A generic template is provided
	// @HystrixCommand(fallbackMethod = "loginCircuitBreaker")
	public ResponseEntity<PersonDetailsModel> login(@RequestBody LoginRequestModel request) {
		logger.info("Request recieved for filter with LoginRequestModel [" + request + "]");
		return new ResponseEntity<>(business.login(request), HttpStatus.OK);
	}

	/**
	 * @param request
	 * @return
	 */
	@PostMapping
	// In the case of error, or exception fallback method are produced.
	// As i am using Controller advice, but if you like to utilize circuit breaker
	// A generic template is provided
	// @HystrixCommand(fallbackMethod = "filterCircuitBreaker")
	public ResponseEntity<FilterHandlerResponse> filter(@RequestBody FilterHandlerRequest request) {
		logger.info("Request recieved for filter with filterHandlerRequest [" + request + "]");
		return new ResponseEntity<>(business.filter(request), HttpStatus.OK);
	}

	/**
	 * @return
	 */
	@GetMapping
	// In the case of error, or exception fallback method are produced.
	// As i am using Controller advice, but if you like to utilize circuit breaker
	// A generic template is provided
	// @HystrixCommand(fallbackMethod = "getAllCircuitBreaker")
	public ResponseEntity<FilterHandlerResponse> getAll() {
		logger.info("Request recieved for getting all person details");
		return new ResponseEntity<>(business.getAll(), HttpStatus.OK);
	}

	public ResponseEntity<PersonDetailsModel> loginCircuitBreaker(@RequestBody LoginRequestModel request) {
		// Time sleep can use to await 
		throw new ServiceNotAvailableException("Service not available now, against request "
				+ request.getClass().getName() + " => { " + request + " }");
	}

	public ResponseEntity<FilterHandlerResponse> filterCircuitBreaker(@RequestBody FilterHandlerRequest request) {
		// Time sleep can use to await 
		throw new ServiceNotAvailableException(
				"Service not available now, against request " + request.getClass().getName()
						+ " => { Please check if filter form filled completely or contact service provider }");
	}

	public ResponseEntity<FilterHandlerResponse> getAllCircuitBreaker() {
		// Time sleep can use to await 
		throw new ServiceNotAvailableException("Service not available now.");
	}
}

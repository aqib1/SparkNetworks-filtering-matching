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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sparknetworks.backend.business.FilterBusiness;
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
	@HystrixCommand(fallbackMethod = "loginCircuitBreaker")
	public ResponseEntity<PersonDetailsModel> login(@RequestBody LoginRequestModel request) {
		logger.info("Request recieved for filter with LoginRequestModel [" + request + "]");
		return ResponseEntity.ok().body(business.login(request));
	}

	/**
	 * @param request
	 * @return
	 */
	@PostMapping
	@HystrixCommand(fallbackMethod = "filterCircuitBreaker")
	public ResponseEntity<FilterHandlerResponse> filter(@RequestBody FilterHandlerRequest request) {
		logger.info("Request recieved for filter with filterHandlerRequest [" + request + "]");
		return ResponseEntity.ok().body(business.filter(request));
	}

	/**
	 * @return
	 */
	@GetMapping
	@HystrixCommand(fallbackMethod = "getAllCircuitBreaker")
	public ResponseEntity<FilterHandlerResponse> getAll() {
		logger.info("Request recieved for getting all person details");
		return ResponseEntity.ok().body(business.getAll());
	}

	public ResponseEntity<PersonDetailsModel> loginCircuitBreaker(@RequestBody LoginRequestModel request) {
		return new ResponseEntity<>(null, HttpStatus.GONE);
	}

	public ResponseEntity<FilterHandlerResponse> filterCircuitBreaker(@RequestBody FilterHandlerRequest request) {
		return new ResponseEntity<>(null, HttpStatus.GONE);
	}

	public ResponseEntity<FilterHandlerResponse> getAllCircuitBreaker() {
		return new ResponseEntity<>(null, HttpStatus.GONE);
	}
}

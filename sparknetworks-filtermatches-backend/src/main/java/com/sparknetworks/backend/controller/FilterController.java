package com.sparknetworks.backend.controller;

import static com.sparknetworks.backend.utils.Const.FILTER_URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;

@RestController
@RequestMapping(FILTER_URL)
public class FilterController {

	private static final Logger logger = LoggerFactory.getLogger(FilterController.class);

	@PostMapping
	public FilterHandlerResponse filter(FilterHandlerRequest request) {
		logger.info("Request recieved for filter with filterHandlerRequest [" + request + "]");
		return null;
	}
}

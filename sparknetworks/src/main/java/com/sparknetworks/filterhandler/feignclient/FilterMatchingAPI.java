package com.sparknetworks.filterhandler.feignclient;

import static com.sparknetworks.filterhandler.utils.Const.SPARK_FILTER_MATCHER_BACKED_LOGIN;
import static com.sparknetworks.filterhandler.utils.Const.SPARK_FILTER_MATCHER_BACKEND;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

@FeignClient(SPARK_FILTER_MATCHER_BACKEND)
public interface FilterMatchingAPI {
	@GetMapping
	FilterHandlerResponse getAll();

	@PostMapping(SPARK_FILTER_MATCHER_BACKED_LOGIN)
	PersonDetailsModel login(@RequestBody LoginRequestModel request);
}

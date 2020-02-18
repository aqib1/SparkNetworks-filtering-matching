package com.sparknetworks.filterhandler.feignclient;

import static com.sparknetworks.filterhandler.utils.Const.SPARK_FILTER_MATCHER_BACKEND;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.sparknetworks.model.FilterHandlerResponse;

@FeignClient(SPARK_FILTER_MATCHER_BACKEND)
public interface FilterMatchingAPI {
	@GetMapping("/filter")
	FilterHandlerResponse getAll();
}

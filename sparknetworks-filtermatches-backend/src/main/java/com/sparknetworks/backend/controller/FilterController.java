package com.sparknetworks.backend.controller;

import static com.sparknetworks.backend.utils.Const.FILTER_URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FILTER_URL)
public class FilterController {

	@GetMapping("/")
	public String test() {
		
		return "test";
	}
}

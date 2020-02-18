package com.sparknetworks.filterhandler.controller;

import static com.sparknetworks.filterhandler.utils.Const.MAIN_PAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sparknetworks.filterhandler.business.FilterBusiness;

@Controller
public class FilterController {

	@Autowired
	private FilterBusiness business;

	@GetMapping("/")
	public String main() {
		business.getAll();
		return MAIN_PAGE;
	}

}

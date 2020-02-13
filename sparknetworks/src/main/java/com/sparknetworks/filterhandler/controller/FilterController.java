package com.sparknetworks.filterhandler.controller;

import static com.sparknetworks.filterhandler.utils.Const.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilterController {

	@GetMapping("/")
	public String main() {
		return MAIN_PAGE;
	}
}

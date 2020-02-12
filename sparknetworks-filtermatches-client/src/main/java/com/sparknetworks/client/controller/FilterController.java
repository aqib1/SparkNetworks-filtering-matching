package com.sparknetworks.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilterController {

	@GetMapping("/t")
	public String home() {
		return "test";
	}
}

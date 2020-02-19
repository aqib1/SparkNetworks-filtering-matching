package com.sparknetworks.filterhandler.controller;

import static com.sparknetworks.filterhandler.utils.Const.HOME_PAGE_URL;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_OP_URL;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_PAGE;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_PAGE_URL;
import static com.sparknetworks.filterhandler.utils.Const.MAIN_PAGE;
import static com.sparknetworks.filterhandler.utils.Const.PERSON_DETAILS_LIST_KEY;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sparknetworks.filterhandler.business.FilterBusiness;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

@Controller
public class FilterController {

	@Autowired
	private FilterBusiness business;
	
	@GetMapping(LOGIN_PAGE_URL)
	public String login(Model model) {
		model.addAttribute("loginModel" ,new LoginRequestModel());
		return LOGIN_PAGE;
	}
	
	@PostMapping(LOGIN_OP_URL)
	public ModelAndView loginOperation(@ModelAttribute("loginModel") LoginRequestModel request) {
		PersonDetailsModel user = business.login(request);
		ModelAndView modelAndView = new ModelAndView(LOGIN_PAGE);
		if(Objects.isNull(user)) {
			
		}
		return null;
	}
	
	@GetMapping(HOME_PAGE_URL)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView(MAIN_PAGE);
		modelAndView.addObject(PERSON_DETAILS_LIST_KEY, business.getAll());
		return modelAndView;
	}
	

}

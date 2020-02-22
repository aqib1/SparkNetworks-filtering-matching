package com.sparknetworks.filterhandler.controller;

import static com.sparknetworks.filterhandler.utils.Const.ERROR_ATTR_UNAUTH;
import static com.sparknetworks.filterhandler.utils.Const.FILTER_HANDLER_REQUEST_ATTRIBUTE;
import static com.sparknetworks.filterhandler.utils.Const.FILTER_URL;
import static com.sparknetworks.filterhandler.utils.Const.HOME_PAGE_URL;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_MODEL_ATTRIBUTE;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_OP_URL;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_PAGE;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_PAGE_URL;
import static com.sparknetworks.filterhandler.utils.Const.MAIN_PAGE;
import static com.sparknetworks.filterhandler.utils.Const.PERSON_DETAILS_LIST_KEY;
import static com.sparknetworks.filterhandler.utils.Const.REDIRECT_HOME;
import static com.sparknetworks.filterhandler.utils.Const.USER_SESSION;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sparknetworks.filterhandler.business.FilterBusiness;
import com.sparknetworks.filterhandler.utils.Helper;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

@Controller
public class FilterController {

	@Autowired
	private FilterBusiness business;

	@GetMapping(value = LOGIN_PAGE_URL)
	public String login(@RequestParam(name = ERROR_ATTR_UNAUTH, required = false) String attr, Model model) {
		if (!Helper.getInstance().isNullOrEmptyString(attr)) {
			model.addAttribute(ERROR_ATTR_UNAUTH, attr);
		}
		model.addAttribute(LOGIN_MODEL_ATTRIBUTE, new LoginRequestModel());
		return LOGIN_PAGE;
	}

	@PostMapping(LOGIN_OP_URL)
	public String loginOperation(@ModelAttribute(LOGIN_MODEL_ATTRIBUTE) LoginRequestModel request,
			HttpServletRequest httpRequest, Model model) {
		PersonDetailsModel response = business.login(request);
		httpRequest.getSession().setAttribute(USER_SESSION, response);
		return REDIRECT_HOME;
	}

	@GetMapping(HOME_PAGE_URL)
	public ModelAndView home(@RequestParam(name = ERROR_ATTR_UNAUTH, required = false) String attr) {
		ModelAndView modelAndView = new ModelAndView(MAIN_PAGE);
		if (!Helper.getInstance().isNullOrEmptyString(attr)) {
			modelAndView.addObject(ERROR_ATTR_UNAUTH, attr);
		}
		modelAndView.addObject(FILTER_HANDLER_REQUEST_ATTRIBUTE, new FilterHandlerRequest());
		modelAndView.addObject(PERSON_DETAILS_LIST_KEY, business.getAll().getMatches());
		return modelAndView;
	}

	@PostMapping(FILTER_URL)
	public ModelAndView filter(@ModelAttribute(FILTER_HANDLER_REQUEST_ATTRIBUTE) FilterHandlerRequest request,
			HttpServletRequest httpRequest) {
		ModelAndView modelAndView = new ModelAndView(MAIN_PAGE);
		request.setUser((PersonDetailsModel) httpRequest.getSession().getAttribute(USER_SESSION));
		modelAndView.addObject(PERSON_DETAILS_LIST_KEY, business.getAllByFilter(request).getMatches());
		return modelAndView;
	}

}

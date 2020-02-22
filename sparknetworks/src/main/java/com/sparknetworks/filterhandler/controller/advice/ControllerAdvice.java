package com.sparknetworks.filterhandler.controller.advice;

import static com.sparknetworks.filterhandler.utils.Const.ERROR_ATTR_UNAUTH;
import static com.sparknetworks.filterhandler.utils.Const.FILTER_URL;
import static com.sparknetworks.filterhandler.utils.Const.HOME_PAGE_URL;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_OP_URL;
import static com.sparknetworks.filterhandler.utils.Const.LOGIN_PAGE_URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.view.RedirectView;

import feign.FeignException;

@RestControllerAdvice
public class ControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

	/**
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(value = { FeignException.class })
	public RedirectView handleFeignStatusException(FeignException e, HttpServletResponse response,
			HttpServletRequest request, Model model) {
		logger.error("Feign exception occurs!! while sending request");
		String url = redirectedUrl(request.getRequestURL().toString());
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl(url);
		response.setStatus(e.status());
		model.addAttribute(ERROR_ATTR_UNAUTH, new JSONObject(e.contentUTF8()).toMap().toString());
		return rv;
	}

	private String redirectedUrl(String url) {
		logger.info("formation of redirect url from give {} url", url);
		String requestedURL = url.substring(url.lastIndexOf('/'));
		String redirectUrl = LOGIN_PAGE_URL;
		if (requestedURL.equals(LOGIN_OP_URL)) {
			redirectUrl = LOGIN_PAGE_URL;
		} else if (requestedURL.equals(FILTER_URL)) {
			redirectUrl = HOME_PAGE_URL;
		}
		return redirectUrl;
	}
}

package com.sparknetworks.filterhandler.business;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sparknetworks.filterhandler.exceptions.InvalidRequestException;
import com.sparknetworks.filterhandler.services.FilterService;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 19/02/2020
 */
@Component
public class FilterBusiness {

	@Autowired
	private FilterService service;

	/**
	 * @param request
	 * @return
	 */
	public List<PersonDetailsModel> getAllByFilter(FilterHandlerRequest request) {
		validateFilterHandlerRequest(request);
		return service.getAllByFilter(request);
	}

	/**
	 * @param request
	 * @return
	 */
	public PersonDetailsModel login(LoginRequestModel request) {
		validateLoginRequetModel(request);
		return service.login(request);
	}

	/**
	 * @param request
	 */
	private void validateLoginRequetModel(LoginRequestModel request) {
		if (Objects.isNull(request))
			throw new InvalidRequestException("Request can not be null");
		if (Objects.isNull(request.getName()))
			throw new InvalidRequestException("Request [name] can not be null");
		if (Objects.isNull(request.getPassword()))
			throw new InvalidRequestException("Request [password] can not be null");

	}

	/**
	 * @return
	 */
	public List<PersonDetailsModel> getAll() {
		return service.getAll();
	}

	/**
	 * @param request
	 */
	private void validateFilterHandlerRequest(FilterHandlerRequest request) {
		if (Objects.isNull(request))
			throw new InvalidRequestException("Request can not be null");
		if (Objects.isNull(request.getHasPhoto()))
			throw new InvalidRequestException("Request has-photo filter can not be null");
		if (Objects.isNull(request.getInContact()))
			throw new InvalidRequestException("Request in-contact filter can not be null");
		if (Objects.isNull(request.getFavorite()))
			throw new InvalidRequestException("Request favorite filter can not be null");
		if (Objects.isNull(request.getCompatibility()))
			throw new InvalidRequestException("Request compatibility can not be null");
		if (Objects.isNull(request.getCompatibility().getTo()) || Objects.isNull(request.getCompatibility().getFrom()))
			throw new InvalidRequestException("Request compatibility (to | from) can not be null");
		if (Objects.isNull(request.getAge()))
			throw new InvalidRequestException("Request age can not be null");
		if (Objects.isNull(request.getAge().getTo()) || Objects.isNull(request.getAge().getFrom()))
			throw new InvalidRequestException("Request age (to | from) can not be null");
		if (Objects.isNull(request.getHeight()))
			throw new InvalidRequestException("Request height can not be null");
		if (Objects.isNull(request.getHeight().getFrom()) || Objects.isNull(request.getHeight().getTo()))
			throw new InvalidRequestException("Request height (to | from) can not be null");
		if (Objects.isNull(request.getDistance()))
			throw new InvalidRequestException("Request distance can not be null");
		if (Objects.isNull(request.getDistance().getFrom()) || Objects.isNull(request.getDistance().getTo()))
			throw new InvalidRequestException("Request distance (to | from) can not be null");
		if (Objects.isNull(request.getUser()))
			throw new InvalidRequestException("Request user (session) can not be null");
	}

}

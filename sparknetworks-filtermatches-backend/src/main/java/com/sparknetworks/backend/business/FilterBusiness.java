package com.sparknetworks.backend.business;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.backend.exceptions.DataNotFoundException;
import com.sparknetworks.backend.exceptions.InvalidRequestException;
import com.sparknetworks.backend.mapper.PersonDetailsModelMapper;
import com.sparknetworks.backend.service.FilterService;
import com.sparknetworks.backend.utils.Utils;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 16/02/2020
 *
 */
@Component
public class FilterBusiness {

	private static final Logger logger = LoggerFactory.getLogger(FilterBusiness.class);
	@Autowired
	private FilterService filterService;

	@Autowired
	private PersonDetailsModelMapper mapper;

	public PersonDetailsModel login(LoginRequestModel request) {
		logger.info("Request recieved for filter with LoginRequestModel [" + request + "]");
		validateLoginRequetModel(request);
		PersonDetailsEntity entity = filterService.login(request);
		if (Objects.isNull(entity))
			return null;
		return mapper.personDetailsEntityToPersonDetailsModel(entity);
	}

	private void validateLoginRequetModel(LoginRequestModel request) {
		if (Objects.isNull(request))
			throw new InvalidRequestException("Request can not be null");
		if (Objects.isNull(request.getName()))
			throw new InvalidRequestException("Request [name] can not be null");
		if (Objects.isNull(request.getPassword()))
			throw new InvalidRequestException("Request [password] can not be null");

	}

	/**
	 * @param request
	 * @return
	 */
	public FilterHandlerResponse filter(FilterHandlerRequest request) {
		validateFilterHandlerRequest(request);
		List<PersonDetailsEntity> data = filterService.filterDetails(request);
		if (Utils.isEmpty(data)) {
			throw new DataNotFoundException("Data not found in person details table");
		}
		return new FilterHandlerResponse().matches(mapper.personDetailsEntityListToPersonDetailsModelList(data));
	}

	/**
	 * @return
	 */
	public FilterHandlerResponse getAll() {
		List<PersonDetailsEntity> data = filterService.findAll();
		if (Utils.isEmpty(data)) {
			throw new DataNotFoundException("Data not found in person details table");
		}
		return new FilterHandlerResponse().matches(mapper.personDetailsEntityListToPersonDetailsModelList(data));
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

	}
}

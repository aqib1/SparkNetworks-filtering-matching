package com.sparknetworks.backend.business;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.sparknetworks.backend.exceptions.InvalidRequestException;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;

@Component
public class FilterBusiness {

	public FilterHandlerResponse filter(FilterHandlerRequest request) {
		validateFilterHandlerRequest(request);
		return null;
	}

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

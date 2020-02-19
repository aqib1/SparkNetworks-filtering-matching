package com.sparknetworks.backend.service;

import java.util.List;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

public interface FilterService {
	List<PersonDetailsEntity> filterDetails(FilterHandlerRequest request);

	List<PersonDetailsEntity> findAll();

	PersonDetailsEntity login(LoginRequestModel request);
}

package com.sparknetworks.backend.service;
import java.util.List;

import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.PersonDetailsModel;

public interface FilterService {
	List<PersonDetailsModel> filterDetails(FilterHandlerRequest request);
	
	List<PersonDetailsModel> findAll();
}

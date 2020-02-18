package com.sparknetworks.filterhandler.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparknetworks.filterhandler.feignclient.FilterMatchingAPI;
import com.sparknetworks.filterhandler.services.FilterService;
import com.sparknetworks.model.PersonDetailsModel;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired
	private FilterMatchingAPI api;
	@Override
	public List<PersonDetailsModel> getAll() {
		System.out.println(api.getAll());
		return null;
	}

}

package com.sparknetworks.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.model.PersonDetailsModel;

@Mapper(componentModel = "spring")
public interface PersonDetailsModelMapper {

	PersonDetailsModel personDetailsEntityToPersonDetailsModel(PersonDetailsEntity personDetailsEntity);

	List<PersonDetailsModel> personDetailsEntityListToPersonDetailsModelList(
			List<PersonDetailsEntity> personDetailsEntityList);
}

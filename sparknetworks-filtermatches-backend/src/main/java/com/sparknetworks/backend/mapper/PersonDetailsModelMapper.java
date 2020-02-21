package com.sparknetworks.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.model.PersonDetailsModel;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 19/02/2020
 */
@Mapper(componentModel = "spring")
public interface PersonDetailsModelMapper {

	PersonDetailsModel personDetailsEntityToPersonDetailsModel(PersonDetailsEntity personDetailsEntity);

	List<PersonDetailsModel> personDetailsEntityListToPersonDetailsModelList(
			List<PersonDetailsEntity> personDetailsEntityList);
}

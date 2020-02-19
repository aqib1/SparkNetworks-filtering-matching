package com.sparknetworks.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sparknetworks.backend.entities.PersonDetailsEntity;

public interface PersonDetailsRepository
		extends JpaRepository<PersonDetailsEntity, Integer>, JpaSpecificationExecutor<PersonDetailsEntity> {

	PersonDetailsEntity findByDisplayNameAndPassword(String displayName, String password);
}

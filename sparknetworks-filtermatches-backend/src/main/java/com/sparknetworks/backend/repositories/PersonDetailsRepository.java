package com.sparknetworks.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sparknetworks.backend.entities.PersonDetailsEntity;

/**
 * @author AQIB JAVED
 * @since 19/02/2020
 * @version 1.0
 *
 */
public interface PersonDetailsRepository
		extends JpaRepository<PersonDetailsEntity, Integer>, JpaSpecificationExecutor<PersonDetailsEntity> {

	PersonDetailsEntity findByDisplayNameAndPassword(String displayName, String password);
}

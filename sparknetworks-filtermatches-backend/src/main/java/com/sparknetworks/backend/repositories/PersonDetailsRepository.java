package com.sparknetworks.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparknetworks.backend.entities.PersonDetailsEntity;

public interface PersonDetailsRepository extends JpaRepository<PersonDetailsEntity, Integer> {

}

package com.sparknetworks.backend.service.Impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.backend.repositories.PersonDetailsRepository;
import com.sparknetworks.backend.repositories.specifications.PersonDetailsSpecs;
import com.sparknetworks.backend.service.FilterService;
import com.sparknetworks.backend.utils.Utils;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.LoginRequestModel;

/**
 * ========= Thread safety information =======
 * <p>
 * To make it thread-safe we will use synchronization
 * <p>
 * Synchronization can be acquired on method level (Coarse grain locking
 * mechanism) but this will make our method slow as no thread else can enter to
 * other methods (in database term we can say highest level of isolation) we
 * will use fine grain locking mechanism separately for read mechanism and
 * writing mechanism
 * </p>
 * <p>
 * I am using java 1.8 StampedLock @see {@link StampedLock} <br>
 * <strong> Reason of using StampedLock is one of its feature optimistic locking
 * in this lock as per documentation said, we do not need to apply full-fledged
 * read lock every time, some time lock is not held by any write operation, we
 * use tryOptimisticRead to check if the lock is hold by write operation and
 * then check result with validate method. </strong> <br>
 * Java 1.8 StampedLock is much more efficient and fast as compared to
 * ReentrantLock specially optimistic locking which make synchronization
 * overhead very slow. You can also use ReentrantLock but it very slow as
 * compared to new java 1.8 stamped lock
 * </p>
 * 
 * @author AQIB JAVED
 * @version 1.0
 * @since 02/16/2020
 * 
 */

@Service
public class FilterServiceImpl implements FilterService {

	private static final Logger logger = LoggerFactory.getLogger(FilterServiceImpl.class);
	private StampedLock stampedLock = new StampedLock();
	@Autowired
	private PersonDetailsRepository repository;

	@Override
	public PersonDetailsEntity login(LoginRequestModel request) {
		logger.info("Request recieved for filter with LoginRequestModel [" + request + "]");
		// return zero if it acquire by a write lock (exclusive locked)
		long stamp = stampedLock.tryOptimisticRead();
		// Synchronization overhead is very low if validate() succeeds
		// Always return true if stamp is non zero (as not acquired by write lock)
		if (stampedLock.validate(stamp))
			return getPersonDetailsByNameAndPassword(request);
		// Only in the case when write lock is acquired we need to apply read lock
		stamp = stampedLock.readLock();
		try {
			return getPersonDetailsByNameAndPassword(request);
		} finally {
			stampedLock.unlockRead(stamp);
		}
	}

	private PersonDetailsEntity getPersonDetailsByNameAndPassword(LoginRequestModel request) {
		return repository.findByDisplayNameAndPassword(request.getName(), request.getPassword());
	}

	@Override
	public List<PersonDetailsEntity> filterDetails(FilterHandlerRequest request) {
		long stamp = stampedLock.tryOptimisticRead();
		request.getCompatibility().setTo(request.getCompatibility().getTo() / 100);
		request.getCompatibility().setFrom(request.getCompatibility().getFrom() / 100);
		// return zero if it acquire by a write lock (exclusive locked)
		// Synchronization overhead is very low if validate() succeeds
		// Always return true if stamp is non zero (as not acquired by write lock)
		if (stampedLock.validate(stamp))
			return getFilterDetails(request);
		// Only in the case when write lock is acquired we need to apply read lock
		stamp = stampedLock.readLock();
		try {
			return getFilterDetails(request);
		} finally {
			stampedLock.unlockRead(stamp);
		}
	}

	private List<PersonDetailsEntity> getFilterDetails(FilterHandlerRequest request) {
		List<PersonDetailsEntity> listOfDetailsEntities = repository
				.findAll(PersonDetailsSpecs.getPersonDetailsByFilter(request)).stream().filter(d -> {
					double distanceKm = Utils.distance(request.getUser().getCity().getLat(), d.getCity().getLat(),
							request.getUser().getCity().getLon(), d.getCity().getLon());
					return request.getDistance().getFrom() <= distanceKm && distanceKm <= request.getDistance().getTo();
				}).collect(Collectors.toList());
		return !request.getStrictType() ? listOfDetailsEntities
				: getListOfDetailsEntitiesStrictType(listOfDetailsEntities, request.getReligions());
	}

	private List<PersonDetailsEntity> getListOfDetailsEntitiesStrictType(
			List<PersonDetailsEntity> listOfDetailsEntities, List<String> religions) {
		Collections.sort(listOfDetailsEntities, Comparator.comparing(item -> religions.indexOf(item.getReligion())));
		return listOfDetailsEntities;
	}

	@Override
	public List<PersonDetailsEntity> findAll() {
		// return zero if it acquire by a write lock (exclusive locked)
		long stamp = stampedLock.tryOptimisticRead();
		// Synchronization overhead is very low if validate() succeeds
		// Always return true if stamp is non zero (as not acquired by write lock)
		if (stampedLock.validate(stamp))
			return findAllPersons();
		// Only in the case when write lock is acquired we need to apply read lock
		stamp = stampedLock.readLock();
		try {
			return findAllPersons();
		} finally {
			stampedLock.unlockRead(stamp);
		}
	}

	private List<PersonDetailsEntity> findAllPersons() {
		return repository.findAll();
	}

}

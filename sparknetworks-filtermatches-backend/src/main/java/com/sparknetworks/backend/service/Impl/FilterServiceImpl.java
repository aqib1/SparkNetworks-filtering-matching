package com.sparknetworks.backend.service.Impl;

import java.util.List;
import java.util.concurrent.locks.StampedLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.backend.repositories.PersonDetailsRepository;
import com.sparknetworks.backend.service.FilterService;
import com.sparknetworks.model.FilterHandlerRequest;

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

	private StampedLock stampedLock = new StampedLock();
	@Autowired
	private PersonDetailsRepository repository;

	@Override
	public List<PersonDetailsEntity> filterDetails(FilterHandlerRequest request) {

		return null;
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

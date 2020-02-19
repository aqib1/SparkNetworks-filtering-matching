package com.sparknetworks.backend.repositories.specifications;

import static com.sparknetworks.backend.utils.Const.PERSON_DETAILS_COL_AGE;
import static com.sparknetworks.backend.utils.Const.PERSON_DETAILS_COL_COMPATIBILITY;
import static com.sparknetworks.backend.utils.Const.PERSON_DETAILS_COL_CONTACTS;
import static com.sparknetworks.backend.utils.Const.PERSON_DETAILS_COL_FAVORITE;
import static com.sparknetworks.backend.utils.Const.PERSON_DETAILS_COL_HEIGHT;
import static com.sparknetworks.backend.utils.Const.PERSON_DETAILS_COL_MAINPHOTO;

import org.springframework.data.jpa.domain.Specification;

import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.model.Age;
import com.sparknetworks.model.Compatibility;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.Height;

public class PersonDetailsSpecs {

	public static Specification<PersonDetailsEntity> getPersonDetailsByAge(Age age) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(PERSON_DETAILS_COL_AGE),
				age.getFrom(), age.getTo());

	}

	public static Specification<PersonDetailsEntity> getPersonDetailsByHasPhoto(boolean hasPhoto) {
		return (root, query, criteriaBuilder) -> hasPhoto
				? criteriaBuilder.isNotNull(root.get(PERSON_DETAILS_COL_MAINPHOTO))
				: criteriaBuilder.isNull(root.get(PERSON_DETAILS_COL_MAINPHOTO));
	}

	public static Specification<PersonDetailsEntity> getPersonDetailsByInContact(boolean inContact) {
		return (root, query, criteriaBuilder) -> inContact
				? criteriaBuilder.greaterThan(root.get(PERSON_DETAILS_COL_CONTACTS), 0)
				: criteriaBuilder.equal(root.get(PERSON_DETAILS_COL_CONTACTS), 0);
	}

	public static Specification<PersonDetailsEntity> getPersonDetailsByFavorite(boolean favorite) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(PERSON_DETAILS_COL_FAVORITE), favorite);
	}

	public static Specification<PersonDetailsEntity> getPersonDetailsByCompatibility(Compatibility compatibility) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(PERSON_DETAILS_COL_COMPATIBILITY),
				compatibility.getFrom(), compatibility.getTo());
	}

	public static Specification<PersonDetailsEntity> getPersonDetailsByHeight(Height height) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(PERSON_DETAILS_COL_HEIGHT),
				height.getFrom(), height.getTo());
	}
	
	public static Specification<PersonDetailsEntity> getPersonDetailsByFilter(FilterHandlerRequest request) {
		return Specification.where(getPersonDetailsByHasPhoto(request.getHasPhoto()))
				.and(getPersonDetailsByInContact(request.getInContact()))
				.and(getPersonDetailsByFavorite(request.getFavorite()))
				.and(getPersonDetailsByCompatibility(request.getCompatibility()))
				.and(getPersonDetailsByAge(request.getAge()))
				.and(getPersonDetailsByHeight(request.getHeight()));
	}
	
	private PersonDetailsSpecs() {

	}
}

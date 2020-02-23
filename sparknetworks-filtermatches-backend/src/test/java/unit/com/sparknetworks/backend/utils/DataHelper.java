package unit.com.sparknetworks.backend.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sparknetworks.backend.entities.CityEntity;
import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.model.Age;
import com.sparknetworks.model.City;
import com.sparknetworks.model.Compatibility;
import com.sparknetworks.model.Distance;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.Height;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;

public class DataHelper {

	public static ResponseEntity<PersonDetailsModel> getLoginFilterController() {
		return new ResponseEntity<>(getPersonDetailsModel(), HttpStatus.OK);
	}
	
	public static ResponseEntity<FilterHandlerResponse> getAllFilterController(){
		return new ResponseEntity<FilterHandlerResponse>(getFilterHandlerResponse(), HttpStatus.OK);
	}

	public static PersonDetailsModel getPersonDetailsModel() {
		return new PersonDetailsModel().displayName("caloria").password("ca123").age(22).jobTitle("SE").heightInCm(121l)
				.city(new City().name("LHR").lat(3.1223).lon(12.111)).mainPhoto("img.png").compatibilityScore(2.1)
				.contactsExchanged(2).favourite(true).religion("Islam");
	}

	public static LoginRequestModel getLoginRequestModel() {
		return new LoginRequestModel().name("caloria").password("ca123");
	}

	public static FilterHandlerResponse getFilterHandlerResponse() {
		return new FilterHandlerResponse().matches(Arrays.asList(getPersonDetailsModel()));
	}

	public static List<PersonDetailsEntity> getPersonDetailsEntityList() {
		return Arrays.asList(getPersonDetailsEntity());
	}

	public static PersonDetailsEntity getPersonDetailsEntity() {
		PersonDetailsEntity personDetails = new PersonDetailsEntity();
		personDetails.setId(1);
		personDetails.setDisplayName("tekxe");
		personDetails.setPassword("12aqw1");
		personDetails.setAge(12);
		personDetails.setJobTitle("SE");
		personDetails.setHeightInCm(155);
		CityEntity ce = new CityEntity();
		ce.setName("LHR");
		ce.setLat(2.3);
		ce.setLon(33.1);
		personDetails.setCity(ce);
		personDetails.setMainPhoto("img.png");
		personDetails.setCompatibilityScore(2.3);
		personDetails.setContactsExchanged(2);
		personDetails.setFavourite(true);
		personDetails.setReligion("T");
		return personDetails;
	}

	public static FilterHandlerRequest getFilterHandlerRequest() {
		return new FilterHandlerRequest().hasPhoto(true).inContact(true).favorite(true)
				.compatibility(new Compatibility().from(1.1).to(2.1)).age(new Age().from(22).to(32))
				.height(new Height().from(123).to(156)).distance(new Distance().from(12.1).to(22.1))
				.user(getPersonDetailsModel());
	}

	private DataHelper() {

	}
}

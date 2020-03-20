package unit.com.sparknetworks.backend.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import com.sparknetworks.backend.entities.CityEntity;
import com.sparknetworks.backend.entities.PersonDetailsEntity;
import com.sparknetworks.backend.exceptions.DataNotFoundException;
import com.sparknetworks.backend.exceptions.InvalidLoginCredException;
import com.sparknetworks.backend.exceptions.InvalidRequestException;
import com.sparknetworks.backend.exceptions.ServiceNotAvailableException;
import com.sparknetworks.model.Age;
import com.sparknetworks.model.City;
import com.sparknetworks.model.Compatibility;
import com.sparknetworks.model.Distance;
import com.sparknetworks.model.FilterHandlerRequest;
import com.sparknetworks.model.FilterHandlerResponse;
import com.sparknetworks.model.Height;
import com.sparknetworks.model.LoginRequestModel;
import com.sparknetworks.model.PersonDetailsModel;
import com.sparknetworks.model.ResponseError;

/**
 * @author AQIB JAVED
 *
 */
public class DataHelper {

	public static final WebRequest TEST_WEB_REQUEST = null;
	public static final RuntimeException TEST_RUNTIME_EXC = new RuntimeException();

	public static ResponseEntity<ResponseError> getHandleServiceNotAvailableException() {
		return new ResponseEntity<>(new ResponseError().createdAt("02/23/2020")
				.detailedMessage(ServiceNotAvailableException.class.getName()).errorCode(HttpStatus.GONE.value())
				.exceptionName(ServiceNotAvailableException.class.getName()).errorMessage("Error - Message"),
				HttpStatus.GONE);
	}
	
	
	
	public static ResponseEntity<ResponseError> getHandleInvalidLoginCredException() {
		return new ResponseEntity<>(
				new ResponseError().createdAt("02/23/2020").detailedMessage(InvalidLoginCredException.class.getName())
						.errorCode(HttpStatus.EXPECTATION_FAILED.value())
						.exceptionName(InvalidLoginCredException.class.getName()).errorMessage("Error - Message"),
				HttpStatus.EXPECTATION_FAILED);
	}

	public static ResponseEntity<ResponseError> getDataNotFoundException() {
		return new ResponseEntity<>(
				new ResponseError().createdAt("02/23/2020").detailedMessage(DataNotFoundException.class.getName())
						.errorCode(HttpStatus.EXPECTATION_FAILED.value())
						.exceptionName(DataNotFoundException.class.getName()).errorMessage("Error - Message"),
				HttpStatus.EXPECTATION_FAILED);
	}

	public static ResponseEntity<ResponseError> getHandleInvalidRequestException() {
		return new ResponseEntity<>(
				new ResponseError().createdAt("02/23/2020").detailedMessage(InvalidRequestException.class.getName())
						.errorCode(HttpStatus.BAD_REQUEST.value())
						.exceptionName(InvalidRequestException.class.getName()).errorMessage("Error - Message"),
				HttpStatus.BAD_REQUEST);
	}

	
	public static ResponseEntity<PersonDetailsModel> getLoginFilterResponseController() {
		return new ResponseEntity<>(getPersonDetailsModel(), HttpStatus.OK);
	}

	public static ResponseEntity<FilterHandlerResponse> getAllFilterResponseController() {
		return new ResponseEntity<FilterHandlerResponse>(getFilterHandlerResponse(), HttpStatus.OK);
	}

	public static PersonDetailsModel getPersonDetailsModel() {
		return new PersonDetailsModel().displayName("caloria").password("ca123").age(22).jobTitle("SE").heightInCm(121l)
				.city(new City().name("LHR").lat(51.509865).lon(-1.548567)).mainPhoto("img.png").compatibilityScore(2.1)
				.contactsExchanged(2).favourite(true).religion("Islam");
	}
	
	public static PersonDetailsModel getPersonDetailsModel1() {
		return new PersonDetailsModel().displayName("aqib").password("aj123").age(27).jobTitle("SE").heightInCm(121l)
				.city(new City().name("LHR").lat(51.509865).lon(-1.548567)).mainPhoto("img.png").compatibilityScore(2.1)
				.contactsExchanged(2).favourite(true).religion("Islam");
	}
	
	public static PersonDetailsModel getPersonDetailsModel2() {
		return new PersonDetailsModel().displayName("Tim").password("ti123").age(28).jobTitle("SE").heightInCm(121l)
				.city(new City().name("LHR").lat(51.509865).lon(-1.548567)).mainPhoto("img.png").compatibilityScore(2.1)
				.contactsExchanged(2).favourite(true).religion("Judaism");
	}
	
	public static PersonDetailsModel getPersonDetailsModel3() {
		return new PersonDetailsModel().displayName("Luke").password("lu123").age(28).jobTitle("SE").heightInCm(121l)
				.city(new City().name("LHR").lat(51.509865).lon(-1.548567)).mainPhoto("img.png").compatibilityScore(2.1)
				.contactsExchanged(2).favourite(true).religion("Hinduism");
	}
	
	public static LoginRequestModel getLoginRequestModel() {
		return new LoginRequestModel().name("caloria").password("ca123");
	}

	public static List<PersonDetailsModel> getListPersonDetailsModel() {
		return Arrays.asList(getPersonDetailsModel());
	}

	public static FilterHandlerResponse getFilterHandlerResponse() {
		return new FilterHandlerResponse().matches(Arrays.asList(getPersonDetailsModel()));
	}
	
	public static FilterHandlerResponse getFilterHandlerResponseForListOfReligions() {
		return new FilterHandlerResponse().matches(Arrays.asList(getPersonDetailsModel(), getPersonDetailsModel1()));
	}
	
	public static FilterHandlerResponse getFilterHandlerResponseForStrictType() {
		return new FilterHandlerResponse().matches(Arrays.asList(getPersonDetailsModel3(), getPersonDetailsModel2()));
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
		ce.setLat(51.509865);
		ce.setLon(-1.548567);
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
				.height(new Height().from(123).to(156)).distance(new Distance().from(0.0).to(750.0))
				.user(getPersonDetailsModel())
				.religions(Arrays.asList("Christ","Isl"))
				.strictType(false);
	}
	
	public static FilterHandlerRequest getFilterHandlerRequestForStrictType() {
		return new FilterHandlerRequest().hasPhoto(true).inContact(true).favorite(true)
				.compatibility(new Compatibility().from(1.1).to(2.1)).age(new Age().from(22).to(32))
				.height(new Height().from(123).to(156)).distance(new Distance().from(0.0).to(750.0))
				.user(getPersonDetailsModel())
				.religions(Arrays.asList("Christ","Isl"))
				.strictType(true);
	}

	private DataHelper() {

	}
}

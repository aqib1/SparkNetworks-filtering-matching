package unit.com.sparknetworks.backend.utils;

import java.util.Arrays;

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

	public static FilterHandlerRequest getFilterHandlerRequest() {
		return new FilterHandlerRequest().hasPhoto(true).inContact(true).favorite(true)
				.compatibility(new Compatibility().from(1.1).to(2.1)).age(new Age().from(22).to(32))
				.height(new Height().from(123).to(156)).distance(new Distance().from(12.1).to(22.1))
				.user(getPersonDetailsModel());
	}

	private DataHelper() {

	}
}

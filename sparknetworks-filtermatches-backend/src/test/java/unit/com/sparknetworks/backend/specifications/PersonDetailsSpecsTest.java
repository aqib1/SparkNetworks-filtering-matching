package unit.com.sparknetworks.backend.specifications;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sparknetworks.backend.repositories.specifications.PersonDetailsSpecs;

public class PersonDetailsSpecsTest {

	@Before
	public void init() {
		
	}
	
	@Test
	public void checkFilterByReligionSpecs() throws NoSuchMethodException, SecurityException {
		String methodName = "getPersonDetailsByListOfReligion";
		Class<?> c = PersonDetailsSpecs.class;
		Method method = c.getDeclaredMethod(methodName, List.class);
		Assert.assertNotNull(method);
	}
}

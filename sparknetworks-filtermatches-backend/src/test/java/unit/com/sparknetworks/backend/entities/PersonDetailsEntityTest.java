package unit.com.sparknetworks.backend.entities;

import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.sparknetworks.backend.entities.PersonDetailsEntity;

/**
 * @author AQIB JAVED
 *
 */
public class PersonDetailsEntityTest {

	@Test
	public void testGetterSetter() {
		PojoClass pojoClass = PojoClassFactory.getPojoClass(PersonDetailsEntity.class);
		Validator validator = ValidatorBuilder.create().with(new SetterMustExistRule()).with(new GetterMustExistRule())
				.with(new SetterTester()).with(new GetterTester()).build();
		validator.validate(pojoClass);
	}
}

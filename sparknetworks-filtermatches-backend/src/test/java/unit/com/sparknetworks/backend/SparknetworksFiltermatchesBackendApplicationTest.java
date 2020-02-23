package unit.com.sparknetworks.backend;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import com.sparknetworks.backend.SparknetworksFiltermatchesBackendApplication;

/**
 * @author AQIB JAVED
 *
 */
public class SparknetworksFiltermatchesBackendApplicationTest {
	/**
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void contextLoads() throws NoSuchMethodException, SecurityException {
		String methodName = "main";
		Class<?> c = SparknetworksFiltermatchesBackendApplication.class;
		Method method = c.getDeclaredMethod(methodName, String[].class);
		Assert.assertNotNull(method);
	}
}

package unit.com.sparknetworks.backend.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.junit.Assert;
import org.junit.Test;

import com.sparknetworks.backend.aop.LoggingAspect;

public class LoggingAspectTest {
	/**
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void contextLoads() throws NoSuchMethodException, SecurityException {
		String methodName = "allMethod";
		Class<?> c = LoggingAspect.class;
		Method method = c.getDeclaredMethod(methodName);
		Assert.assertNotNull(method);
		methodName = "logStartOfMethod";
		method = c.getDeclaredMethod(methodName, JoinPoint.class);
		Assert.assertNotNull(method);
		methodName = "logEndOfMethod";
		method = c.getDeclaredMethod(methodName, JoinPoint.class);
		Assert.assertNotNull(method);
	}
}

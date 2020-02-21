package com.sparknetworks.backend.aop;

import static com.sparknetworks.backend.utils.Const.SPARK_COMPONENT_SCAN_PATH;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 19/02/2020
 */
@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("within(" + SPARK_COMPONENT_SCAN_PATH + ".*.*)")
	protected void allMethod() {
	}

	@Before("allMethod()")
	public void logStartOfMethod(JoinPoint joinPoint) {
		logger.info("Inside method [" + joinPoint.getSignature().getName() + "] @ " + LocalDateTime.now().toString());
	}

	@After("allMethod()")
	public void logEndOfMethod(JoinPoint joinPoint) {
		logger.info("Outside method [" + joinPoint.getSignature().getName() + "]  @ " + LocalDateTime.now().toString());
	}
}

package com.sparknetworks.backend.utils;

import java.util.List;
import java.util.Objects;

/**
 * @author AQIB JAVED
 * @version 1.0
 * @since 17/02/2020
 *
 */
public class Utils {
	
	
	/**
	 * @param <T>
	 * @param li
	 * @return
	 */
	public static <T> boolean isEmpty (List<T> li) {
		return Objects.isNull(li) || li.isEmpty();
	}
	
	
	private Utils() {
		
	}

}

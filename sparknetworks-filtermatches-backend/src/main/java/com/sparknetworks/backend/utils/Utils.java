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
	public static <T> boolean isEmpty(List<T> li) {
		return Objects.isNull(li) || li.isEmpty();
	}

	/**
	 * @param lat1
	 * @param lat2
	 * @param lon1
	 * @param lon2
	 * @return
	 */
	public static double distance(double lat1, double lat2, double lon1, double lon2) {
		// The math module contains a function
		// named toRadians which converts from
		// degrees to radiant.
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		// Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers. Use 3956
		// for miles
		double r = 6371;

		// calculate the result
		return (c * r);
	}

	private Utils() {

	}

}

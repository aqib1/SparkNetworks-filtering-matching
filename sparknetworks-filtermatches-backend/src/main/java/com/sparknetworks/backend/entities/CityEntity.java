package com.sparknetworks.backend.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CityEntity {

	@Column(name = "city_name")
	private String name;

	@Column(name = "latitude")
	private Double lat;

	@Column(name = "longitude")
	private Double lon;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "CityEntity [name=" + name + ", lat=" + lat + ", lon=" + lon + "]";
	}

}

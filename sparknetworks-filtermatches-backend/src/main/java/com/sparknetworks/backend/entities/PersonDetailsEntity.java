package com.sparknetworks.backend.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sparknetworks.model.City;

@Entity
public class PersonDetailsEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "age")
	private Integer age;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "height_in_cm")
	private Long heightInCm;

	@Embedded
	private City city;

	@Column(name = "main_photo")
	private String mainPhoto;

	@Column(name = "contacts_exchanged")
	private Integer contactsExchanged;

	@Column(name = "favourite")
	private Boolean favourite;

	@Column(name = "religion")
	private String religion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Long getHeightInCm() {
		return heightInCm;
	}

	public void setHeightInCm(Long heightInCm) {
		this.heightInCm = heightInCm;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getMainPhoto() {
		return mainPhoto;
	}

	public void setMainPhoto(String mainPhoto) {
		this.mainPhoto = mainPhoto;
	}

	public Integer getContactsExchanged() {
		return contactsExchanged;
	}

	public void setContactsExchanged(Integer contactsExchanged) {
		this.contactsExchanged = contactsExchanged;
	}

	public Boolean getFavourite() {
		return favourite;
	}

	public void setFavourite(Boolean favourite) {
		this.favourite = favourite;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	@Override
	public String toString() {
		return "PersonDetailsEntity [id=" + id + ", displayName=" + displayName + ", age=" + age + ", jobTitle="
				+ jobTitle + ", heightInCm=" + heightInCm + ", city=" + city + ", mainPhoto=" + mainPhoto
				+ ", contactsExchanged=" + contactsExchanged + ", favourite=" + favourite + ", religion=" + religion
				+ "]";
	}

}

package edu.usm.cos375.model;

import java.util.Date;
/*
 * Individual class represents a single individual in the initial census. 
 * 
 * NOTE: Membership, residency, pregnancy, relationship, and membership episodes, will need to be added once implemented. 
 */

public class Individual {
	private long id;		//For purposes of temporary in memory storage
	private Date dob;
	private String dobAspect;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private int age;
	private String phoneNumber;
	private String otherPhoneNumber;
	private String languagePreference;
	private String pointOfContactName;
	private String pointOfContactPhoneNumber;
	private String nationality;

	public Individual() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDobAspect() {
		return dobAspect;
	}

	public void setDobAspect(String dobAspect) {
		this.dobAspect = dobAspect;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOtherPhoneNumber() {
		return otherPhoneNumber;
	}

	public void setOtherPhoneNumber(String otherPhoneNumber) {
		this.otherPhoneNumber = otherPhoneNumber;
	}

	public String getLanguagePreference() {
		return languagePreference;
	}

	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}

	public String getPointOfContactName() {
		return pointOfContactName;
	}

	public void setPointOfContactName(String pointOfContactName) {
		this.pointOfContactName = pointOfContactName;
	}

	public String getPointOfContactPhoneNumber() {
		return pointOfContactPhoneNumber;
	}

	public void setPointOfContactPhoneNumber(String pointOfContactPhoneNumber) {
		this.pointOfContactPhoneNumber = pointOfContactPhoneNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
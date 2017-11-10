package edu.usm.cos375.model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import javax.validation.constraints.*;
import javax.persistence.*;

/*
 * Individual class represents a single individual in the initial census. 
 * 
 * TODO: Membership, residency, pregnancy, relationship, and membership episodes, will need to be added once implemented. 
 * TODO: Implement additional validation.
 */

public class Individual {
	private long id;		//For purposes of temporary in memory storage
	
	@Past
	private Date dob;
	private String dobAspect;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String middleName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String gender;
	private Individual mother;
	private Individual father;
	private int age;
	private String ageUnits;
	private String phoneNumber;
	private String otherPhoneNumber;
	private String languagePreference;
	private String pointOfContactName;
	private String pointOfContactPhoneNumber;
	private String dip;
	private String membershipStatus;
	private String nationality;
	private Set <Residency> residencies = new HashSet<>();
	private Set<Relationship> relationshipA = new HashSet<>();
	private Set<Relationship> relationshipB = new HashSet<>();
	private Set<Membership> memberships = new HashSet<>();
	
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
	
	public Individual getMother() {
		return mother;
	}

	public void setMother(Individual mother) {
		this.mother = mother;
	}

	public Individual getFather() {
		return father;
	}

	public void setFather(Individual father) {
		this.father = father;
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
	
	public Set<Residency> getResidencies() {
		return residencies;
	}

	public void setResidencies(Set<Residency> residencies) {
		this.residencies = residencies;
	}

	public Set<Relationship> getRelationshipA() {
		return relationshipA;
	}

	public void setRelationshipA(Set<Relationship> relationshipA) {
		this.relationshipA = relationshipA;
	}

	public Set<Relationship> getRelationshipB() {
		return relationshipB;
	}

	public void setRelationshipB(Set<Relationship> relationshipB) {
		this.relationshipB = relationshipB;
	}

	public Set<Membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(Set<Membership> membership) {
		this.memberships = membership;
	}

	public String getAgeUnits() {
		return ageUnits;
	}

	public void setAgeUnits(String ageUnits) {
		this.ageUnits = ageUnits;
	}

	public String getDip() {
		return dip;
	}

	public void setDip(String dip) {
		this.dip = dip;
	}

	public String getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}	
}
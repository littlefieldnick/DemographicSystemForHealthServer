package edu.usm.cos375.model;

import java.util.Calendar;

public class Relationship {
	//TODO: Implement services, repository, and controller. Add validation
	
	Individual individualA;
	Individual individualB;
	
	String aIsToB;
	
	Calendar startDate;
	Calendar endDate;
	
	String endType;

	public Individual getIndividualA() {
		return individualA;
	}

	public void setIndividualA(Individual individualA) {
		this.individualA = individualA;
	}

	public Individual getIndividualB() {
		return individualB;
	}

	public void setIndividualB(Individual individualB) {
		this.individualB = individualB;
	}

	public String getaIsToB() {
		return aIsToB;
	}

	public void setaIsToB(String aIsToB) {
		this.aIsToB = aIsToB;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public String getEndType() {
		return endType;
	}

	public void setEndType(String endType) {
		this.endType = endType;
	}
	
}

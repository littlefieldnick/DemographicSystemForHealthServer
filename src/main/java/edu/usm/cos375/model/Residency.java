package edu.usm.cos375.model;

import java.util.Calendar;

//TODO: Implement services, repository, and controller.

public class Residency {
	Individual individual;
	//Location location; //Leave commented out until implemented
	
	Calendar startDate;
	Calendar endDate;
	
	String startType;
	String endType;
	
	public Individual getIndividual() {
		return individual;
	}
	
	public void setIndividual(Individual individual) {
		this.individual = individual;
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
	
	public String getStartType() {
		return startType;
	}
	
	public void setStartType(String startType) {
		this.startType = startType;
	}
	
	public String getEndType() {
		return endType;
	}
	
	public void setEndType(String endType) {
		this.endType = endType;
	}
	
	
}

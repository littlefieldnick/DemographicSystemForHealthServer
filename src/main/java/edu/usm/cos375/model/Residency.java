package edu.usm.cos375.model;

import java.util.Calendar;

public class Residency
{
	private Long uuid;
	private Individual individual;
	private Location location;
	private Calendar startDate;
	private Calendar endDate;
	private String startType;
	private String endType;
	
	public Long getUuid()
	{
		return this.uuid;
	}
	
	public void setUuid(long uuid)
	{
		this.uuid = uuid;
	}
	
	public Individual getIndividual()
	{
		return individual;
	}
	
	public void setIndividual(Individual individual)
	{
		this.individual = individual;
	}
	
	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public Calendar getStartDate()
	{
		return startDate;
	}
	
	public void setStartDate(Calendar startDate)
	{
		this.startDate = startDate;
	}
	
	public Calendar getEndDate()
	{
		return endDate;
	}
	
	public void setEndDate(Calendar endDate)
	{
		this.endDate = endDate;
	}
	
	public String getStartType()
	{
		return startType;
	}
	
	public void setStartType(String startType)
	{
		this.startType = startType;
	}
	
	public String getEndType()
	{
		return endType;
	}
	
	public void setEndType(String endType)
	{
		this.endType = endType;
	}
}

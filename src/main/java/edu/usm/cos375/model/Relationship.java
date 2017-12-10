package edu.usm.cos375.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="relationship")
public class Relationship
{
	//TODO: Implement services, repository, and controller. Add validation
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	Individual individualA;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	Individual individualB;
	
	String aIsToB;
	
	Calendar startDate;
	Calendar endDate;
	
	String endType;

	public Individual getIndividualA()
	{
		return individualA;
	}

	public void setIndividualA(Individual individualA)
	{
		this.individualA = individualA;
	}

	public Individual getIndividualB()
	{
		return individualB;
	}

	public void setIndividualB(Individual individualB)
	{
		this.individualB = individualB;
	}

	public String getaIsToB()
	{
		return aIsToB;
	}

	public void setaIsToB(String aIsToB)
	{
		this.aIsToB = aIsToB;
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

	public String getEndType()
	{
		return endType;
	}

	public void setEndType(String endType)
	{
		this.endType = endType;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return this.id;
	}
}

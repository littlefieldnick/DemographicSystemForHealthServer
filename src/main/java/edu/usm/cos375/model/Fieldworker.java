package edu.usm.cos375.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.usm.cos375.model.constraint.CheckFieldNotBlank;

@Entity
@Table(name="fieldworker")
public class Fieldworker
{
	private static final long serialVersionUID = -2635197895396416285L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	long id;
	
	@NotNull
	@CheckFieldNotBlank
	@Size(min=1)
	String extId;
	
	@NotNull
	@CheckFieldNotBlank
	String firstName;
	
	@NotNull
	@CheckFieldNotBlank
	String lastName;
	
	
	public String getExtId()
	{
		return extId;
	}
	
	public void setExtId(String extId)
	{
		this.extId = extId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
}

package edu.usm.cos375.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="fieldworker")
public class Fieldworker extends AuditableEntity
{
	private static final long serialVersionUID = -2635197895396416285L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	long id;
	
	String extId;
	String firstName;
	String lastName;
	String password;
	String confirmPassword;
	
	@NotNull
	String passwordHash;

	int idPrefix;
	
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
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getConfirmPassword()
	{
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	
	public String getPasswordHash()
	{
		return passwordHash;
	}
	
	public void setPasswordHash(String passwordHash)
	{
		this.passwordHash = passwordHash;
	}
	public int getIdPrefix()
	{
		return idPrefix;
	}
	
	public void setIdPrefix(int idPrefix)
	{
		this.idPrefix = idPrefix;
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

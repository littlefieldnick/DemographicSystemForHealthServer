package edu.usm.cos375.model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/*
 * Individual class represents a single individual in the initial census. 
 * 
 * TODO: Membership, residency, pregnancy, relationship, and membership episodes, will need to be added once implemented. 
 * TODO: Implement additional validation.
 */

@Entity
@Table(name="individual")
public class Individual
{
	private static final long serialVersionUID = -424712868173326154L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; // For purposes of temporary in memory storage
	
	private String extId;
	
	@Past
	private Date dob;
	private String dobAspect;
	
	@NotNull
	private String firstName;
	
	private String middleName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String gender;

	
	@Column
	private int age;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String otherPhoneNumber;
	
	@Column
	private String languagePreference;
	
	@Column
	private String pointOfContactName;
	
	@Column
	private String pointOfContactPhoneNumber;
	
	@Column
	private String dip;

	@Column
	private String nationality;
	

	@OneToMany(mappedBy="individualA",cascade=CascadeType.ALL)
	private Set<Relationship> relationshipA = new HashSet<>();
	
	@OneToMany(mappedBy="individualB",cascade=CascadeType.ALL)
	private Set<Relationship> relationshipB = new HashSet<>();
	
	@OneToMany(mappedBy="individual",cascade=CascadeType.ALL)
	private Set<Membership> memberships = new HashSet<>();
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public String getDobAspect()
	{
		return dobAspect;
	}

	public void setDobAspect(String dobAspect)
	{
		this.dobAspect = dobAspect;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}
	

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getOtherPhoneNumber()
	{
		return otherPhoneNumber;
	}

	public void setOtherPhoneNumber(String otherPhoneNumber)
	{
		this.otherPhoneNumber = otherPhoneNumber;
	}

	public String getLanguagePreference()
	{
		return languagePreference;
	}

	public void setLanguagePreference(String languagePreference)
	{
		this.languagePreference = languagePreference;
	}

	public String getPointOfContactName()
	{
		return pointOfContactName;
	}

	public void setPointOfContactName(String pointOfContactName)
	{
		this.pointOfContactName = pointOfContactName;
	}

	public String getPointOfContactPhoneNumber()
	{
		return pointOfContactPhoneNumber;
	}

	public void setPointOfContactPhoneNumber(String pointOfContactPhoneNumber)
	{
		this.pointOfContactPhoneNumber = pointOfContactPhoneNumber;
	}

	public String getNationality()
	{
		return nationality;
	}

	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	

	public Set<Relationship> getRelationshipA()
	{
		return relationshipA;
	}

	public void setRelationshipA(Set<Relationship> relationshipA)
	{
		this.relationshipA = relationshipA;
	}

	public Set<Relationship> getRelationshipB()
	{
		return relationshipB;
	}

	public void setRelationshipB(Set<Relationship> relationshipB)
	{
		this.relationshipB = relationshipB;
	}

	public Set<Membership> getMemberships()
	{
		return memberships;
	}

	public void setMemberships(Set<Membership> membership)
	{
		this.memberships = membership;
	}

	public String getDip()
	{
		return dip;
	}

	public void setDip(String dip)
	{
		this.dip = dip;
	}

	public String getExtId() {
		return extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
	}
}
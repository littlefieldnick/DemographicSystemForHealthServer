package edu.usm.cos375.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="location")
public class Location implements Serializable
{
	private static final long serialVersionUID = -7109179128929477921L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	long uuid;
	
	@NotNull
	private String extId;
	
	@NotNull
	private String locationName;
	
	
	private LocationHierarchy locationHierarchy = new LocationHierarchy(); // contains the Location's hierarchical level
	
	private String locationType; // Urban, Rural, etc.
	
	@NotNull
	private String latitude;
	
	@NotNull
	private String longitude;
	
	public long getUuid()
	{
		return uuid;
	}

	public void setUuid(long uuid)
	{
		this.uuid = uuid;
	}

	public String getExtId()
	{
		return extId;
	}

	public void setExtId(String extId)
	{
		this.extId = extId;
	}

	public String getLocationName()
	{
		return locationName;
	}

	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}

	public LocationHierarchy getLocationHierarchy()
	{
		return locationHierarchy;
	}

	public void setLocationHierarchy(LocationHierarchy locationHierarchy)
	{
		this.locationHierarchy = locationHierarchy;
	}
	
	public String getLocationType()
	{
		return locationType;
	}

	public void setLocationType(String locationType)
	{
		this.locationType = locationType;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}
}
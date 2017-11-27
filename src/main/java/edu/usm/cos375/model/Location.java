package edu.usm.cos375.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location implements Serializable
{
	private static final long serialVersionUID = -7109179128929477921L;
	
	private Long uuid;
	private String extId;
	private String locationName;
	private String locationType;
	private String latitude;
	private String longitude;
	private String accuracy;
	private String altitude;
	private Integer buildingNumber;
	private Integer floorNumber;
	private String provinceName;
	private String regionName;
	private String sectorName;
	private String districtName;
	private String subDistrictName;
	private String localityName;
	private String mapAreaName;
	private String communityName;
	private String communityCode;
	private String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getUuid()
	{
		return uuid;
	}

	public void setUuid(Long uuid)
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

	public String getAccuracy()
	{
		return accuracy;
	}

	public void setAccuracy(String accuracy)
	{
		this.accuracy = accuracy;
	}

	public String getAltitude()
	{
		return altitude;
	}

	public void setAltitude(String altitude)
	{
		this.altitude = altitude;
	}

	public Integer getBuildingNumber()
	{
		return buildingNumber;
	}

	public void setBuildingNumber(Integer buildingNumber)
	{
		this.buildingNumber = buildingNumber;
	}

	public Integer getFloorNumber()
	{
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber)
	{
		this.floorNumber = floorNumber;
	}

	public String getProvinceName()
	{
		return provinceName;
	}

	public void setProvinceName(String provinceName)
	{
		this.provinceName = provinceName;
	}

	public String getRegionName()
	{
		return regionName;
	}

	public void setRegionName(String regionName)
	{
		this.regionName = regionName;
	}

	public String getSectorName()
	{
		return sectorName;
	}

	public void setSectorName(String sectorName)
	{
		this.sectorName = sectorName;
	}

	public String getDistrictName()
	{
		return districtName;
	}

	public void setDistrictName(String districtName)
	{
		this.districtName = districtName;
	}

	public String getSubDistrictName()
	{
		return subDistrictName;
	}

	public void setSubDistrictName(String subDistrictName)
	{
		this.subDistrictName = subDistrictName;
	}

	public String getLocalityName()
	{
		return localityName;
	}

	public void setLocalityName(String localityName)
	{
		this.localityName = localityName;
	}

	public String getMapAreaName()
	{
		return mapAreaName;
	}

	public void setMapAreaName(String mapAreaName)
	{
		this.mapAreaName = mapAreaName;
	}

	public String getCommunityName()
	{
		return communityName;
	}

	public void setCommunityName(String communityName)
	{
		this.communityName = communityName;
	}

	public String getCommunityCode()
	{
		return communityCode;
	}

	public void setCommunityCode(String communityCode)
	{
		this.communityCode = communityCode;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}

package edu.usm.cos375.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.usm.cos375.model.Location;
import edu.usm.cos375.repository.LocationRepository;

@Repository
public class InMemoryLocationRepository implements LocationRepository
{
	private static volatile long LOCATION_SEQUENCE = 1L;

	private static final List<Location> locationDatabase = 
			new ArrayList<>(Arrays.asList(

					buildLocation("ExID1", "Name1", "LocationType1", "25", "50",
							"11", "50", 11, 50, "ProvinceName1", "RegionName1",
							"SectorName1", "DistrictName1", "SubDistrictName1", "LocalityName1", "MapAreaName1", 
							"CommunityName1", "CommunityCode1", "Description1"),

					buildLocation("ExID2", "Name2", "LocationType2", "50", "25",
							"11", "50", 11, 50, "ProvinceName2", "RegionName2",
							"SectorName2", "DistrictName2", "SubDistrictName2", "LocalityName2", "MapAreaName2", 
							"CommunityName2", "CommunityCode2", "Description2"),

					buildLocation("ExID3", "Name3", "LocationType3", "-90", "180",
							"11", "50", 11, 50, "ProvinceName3", "RegionName3",
							"SectorName3", "DistrictName3", "SubDistrictName3", "LocalityName3", "MapAreaName3", 
							"CommunityName3", "CommunityCode3", "Description3"),

					buildLocation("ExID4", "Name4", "LocationType4", "90", "-180",
							"11", "50", 11, 50, "ProvinceName4", "RegionName4",
							"SectorName4", "DistrictName4", "SubDistrictName4", "LocalityName4", "MapAreaName4", 
							"CommunityName4", "CommunityCode4", "Description4")
					));

	public static Location buildLocation(String extId, String locationName, String locationType, String latitude, String longitude,
			String accuracy, String altitude, Integer buildingNumber, Integer floorNumber, String provinceName, String regionName,
			String sectorName, String districtName, String subDistrictName, String localityName, String mapAreaName, 
			String communityName, String communityCode, String description)
	{
		Location l = new Location();

		l.setUuid(getNextLocationId());
		l.setExtId(extId);
		l.setLocationName(locationName);
		l.setLocationType(locationType);
		l.setLatitude(latitude);
		l.setLongitude(longitude);
		l.setAccuracy(accuracy);
		l.setAltitude(altitude);
		l.setBuildingNumber(buildingNumber);
		l.setFloorNumber(floorNumber);
		l.setProvinceName(provinceName);
		l.setRegionName(regionName);
		l.setSectorName(sectorName);
		l.setDistrictName(districtName);
		l.setSubDistrictName(subDistrictName);
		l.setLocalityName(localityName);
		l.setMapAreaName(mapAreaName);
		l.setCommunityName(communityName);
		l.setCommunityCode(communityCode);
		l.setDescription(description);

		return l;
	}

	@Override
	public void create(Location l)
	{
		l.setUuid(getNextLocationId());
		locationDatabase.add(l);
	}

	@Override
	public Location read(Long id)
	{
		Location location = locationDatabase.stream()
				.filter(l -> l.getUuid() == id) // filtering on the id
				.findFirst()  // finds the first and only instance of the location
				.orElse(null); // or return null if the location is not present 

		return location;
	}

	@Override
	public void update(Location l)
	{
		delete(l.getUuid());
		locationDatabase.add(l);
	}

	@Override
	public void delete(Long id)
	{
		locationDatabase.removeIf(l -> l.getUuid() == id);
	}

	@Override
	public List<Location> getAllLocations()
	{
		return locationDatabase;
	}

	private static synchronized long getNextLocationId()
	{
		return LOCATION_SEQUENCE++;
	}
}
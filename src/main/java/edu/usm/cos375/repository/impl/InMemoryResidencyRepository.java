package edu.usm.cos375.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.model.Location;
import edu.usm.cos375.model.Residency;
import edu.usm.cos375.repository.ResidencyRepository;

@Repository
public class InMemoryResidencyRepository implements ResidencyRepository
{	
	private static volatile long RESIDENCY_SEQUENCE = 1L;

	private static final List<Residency> residencyDatabase = buildInMemoryDatabase();

	public static List<Residency> buildInMemoryDatabase()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(1969, 7, 2);

		Individual individual1 = buildIndividual(cal.getTime(), "John", "", "Smith", "male", 48, "607-777-9980", "English",
				"American", "Jane Smith", "607-777-9981");
		Individual individual2 = buildIndividual(cal.getTime(), "John", "", "Smith", "male", 48, "607-777-9980", "English",
				"American", "Jane Smith", "607-777-9981");
		Individual individual3  = buildIndividual(cal.getTime(), "John", "", "Smith", "male", 48, "607-777-9980", "English",
				"American", "Jane Smith", "607-777-9981");
		Individual individual4 = buildIndividual(cal.getTime(), "John", "", "Smith", "male", 48, "607-777-9980", "English",
				"American", "Jane Smith", "607-777-9981");

		Location location1 = buildLocation("ExID1", "Name1", "LocationType1", "25", "50",
				"11", "50", 11, 50, "ProvinceName1", "RegionName1",
				"SectorName1", "DistrictName1", "SubDistrictName1", "LocalityName1", "MapAreaName1", 
				"CommunityName1", "CommunityCode1", "Description1");
		Location location2 = buildLocation("ExID2", "Name2", "LocationType2", "50", "25",
				"11", "50", 11, 50, "ProvinceName2", "RegionName2",
				"SectorName2", "DistrictName2", "SubDistrictName2", "LocalityName2", "MapAreaName2", 
				"CommunityName2", "CommunityCode2", "Description2");
		Location location3 = buildLocation("ExID3", "Name3", "LocationType3", "-90", "180",
				"11", "50", 11, 50, "ProvinceName3", "RegionName3",
				"SectorName3", "DistrictName3", "SubDistrictName3", "LocalityName3", "MapAreaName3", 
				"CommunityName3", "CommunityCode3", "Description3");
		Location location4 = buildLocation("ExID4", "Name4", "LocationType4", "90", "-180",
				"11", "50", 11, 50, "ProvinceName4", "RegionName4",
				"SectorName4", "DistrictName4", "SubDistrictName4", "LocalityName4", "MapAreaName4", 
				"CommunityName4", "CommunityCode4", "Description4");

		List<Residency> database = new ArrayList<>(Arrays.asList(
				buildResidency(getNextResidencyId(), individual1, location1, Calendar.getInstance(), Calendar.getInstance(), "startType1", "endType1"),
				buildResidency(getNextResidencyId(), individual2, location2, Calendar.getInstance(), Calendar.getInstance(), "startType1", "endType1"),
				buildResidency(getNextResidencyId(), individual3, location3, Calendar.getInstance(), Calendar.getInstance(), "startType1", "endType1"),
				buildResidency(getNextResidencyId(), individual4, location4, Calendar.getInstance(), Calendar.getInstance(), "startType1", "endType1")
				));

		return database;
	}

	public static Residency buildResidency(Long uuid, Individual individual, Location location, Calendar startDate, Calendar endDate, String startType, String endType)
	{
		Residency r = new Residency();

		r.setUuid(uuid);
		r.setIndividual(individual);
		r.setLocation(location);
		r.setStartDate(startDate);
		r.setEndDate(endDate);
		r.setStartType(startType);
		r.setEndType(endType);

		return r;
	}

	public static Location buildLocation(String extId, String locationName, String locationType, String latitude, String longitude,
			String accuracy, String altitude, Integer buildingNumber, Integer floorNumber, String provinceName, String regionName,
			String sectorName, String districtName, String subDistrictName, String localityName, String mapAreaName, 
			String communityName, String communityCode, String description)
	{
		Location l = new Location();

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

	public static Individual buildIndividual(Date dob, String firstName, String middleName, String lastName, String gender, int age, 
			String phoneNumber, String languagePref, String nationality, String pointOfContactName, String pointOfContactPhoneNumber)
	{
		Individual i = new Individual();
		i.setDob(dob);
		i.setFirstName(firstName);
		i.setMiddleName(middleName);
		i.setLastName(lastName);
		i.setGender(gender);
		i.setAge(age);
		i.setPhoneNumber(phoneNumber);
		i.setLanguagePreference(languagePref);
		i.setNationality(nationality);
		i.setPointOfContactName(pointOfContactName);
		i.setPointOfContactPhoneNumber(pointOfContactPhoneNumber);

		return i;
	}

	@Override
	public void create(Residency r)
	{
		r.setUuid(getNextResidencyId());
		residencyDatabase.add(r);
	}

	@Override
	public Residency read(Long id)
	{
		Residency residency = residencyDatabase.stream()
				.filter(r -> r.getUuid() == id) // filtering on the id
				.findFirst()  // finds the first and only instance of the location
				.orElse(null); // or return null if the location is not present 

		return residency;
	}

	@Override
	public void update(Residency r)
	{
		delete(r.getUuid());
		residencyDatabase.add(r);
	}

	@Override
	public void delete(Long id)
	{
		residencyDatabase.removeIf(l -> l.getUuid() == id);
	}

	@Override
	public List<Residency> getAllResidencies()
	{
		return residencyDatabase;
	}

	private static synchronized long getNextResidencyId()
	{
		return RESIDENCY_SEQUENCE++;
	}
}
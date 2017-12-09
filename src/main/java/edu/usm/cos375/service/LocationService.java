package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.Location;

public interface LocationService 
{
	void create(Location l);
	Location read(Long id);
	Location getByExtId(String extId);
	void update(Location l);
	void delete(Long id);
	List<Location> getAllLocations();
	boolean exists(Location location);
}

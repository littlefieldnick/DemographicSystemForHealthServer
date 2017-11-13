package edu.usm.cos375.repository;

import java.util.List;

import edu.usm.cos375.model.Location;

public interface LocationRepository 
{
	public void create(Location l);
	public Location read(Long id);
	public void update(Location l);
	public void delete(Long id);
	public List<Location> getAllLocations();
}

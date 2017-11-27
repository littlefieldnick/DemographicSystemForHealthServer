package edu.usm.cos375.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usm.cos375.model.Location;
import edu.usm.cos375.repository.LocationRepository;
import edu.usm.cos375.service.LocationService;

@Service
public class DefaultLocationService implements LocationService
{
	@Inject
	@Autowired
	LocationRepository repository;

	@Override
	public void create(Location l)
	{
		repository.save(l);
	}

	@Override
	public Location read(Long id)
	{
		return repository.findOne(id);
	}

	@Override
	public void update(Location l)
	{
		repository.save(l);
	}

	@Override
	public void delete(Long id)
	{
		repository.delete(id);
	}

	@Override
	public List<Location> getAllLocations()
	{
		List<Location> list = new ArrayList<Location>();
		Iterable<Location> locations = (List<Location>) repository.findAll();
		locations.forEach(list::add);
		list.sort((l1, l2) -> l1.getLocationName().compareTo(l2.getLocationName()));
		return list;
	}

	@Override
	public boolean exists(Location l)
	{
		return this.getAllLocations().stream()
				.anyMatch(location -> location.equals(l));
	}
}

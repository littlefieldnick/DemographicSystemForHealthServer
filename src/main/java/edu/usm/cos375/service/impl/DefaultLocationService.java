package edu.usm.cos375.service.impl;

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
	@Autowired
	LocationRepository repository;

	@Override
	public void create(Location l)
	{
		repository.create(l);
	}

	@Override
	public Location read(Long id)
	{
		return repository.read(id);
	}

	@Override
	public void update(Location l)
	{
		repository.update(l);
	}

	@Override
	public void delete(Long id)
	{
		repository.delete(id);
	}

	@Override
	public List<Location> getAllLocations()
	{
		List <Location> list = repository.getAllLocations();
		list.sort((l1, l2) -> l1.getLocationName().compareTo(l2.getLocationName()));
		return list;
	}

	@Override
	public boolean exists(Location l)
	{
		return repository.getAllLocations().stream()
				.anyMatch(location -> location.equals(l));
	}
}

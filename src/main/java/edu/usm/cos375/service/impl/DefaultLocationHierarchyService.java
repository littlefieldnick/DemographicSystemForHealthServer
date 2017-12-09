package edu.usm.cos375.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usm.cos375.model.LocationHierarchy;
import edu.usm.cos375.repository.LocationHierarchyRepository;
import edu.usm.cos375.service.LocationHierarchyService;

@Service
public class DefaultLocationHierarchyService implements LocationHierarchyService
{
	@Autowired
	LocationHierarchyRepository repository;

	@Override
	public void create(LocationHierarchy lh)
	{
		repository.save(lh);
	}

	@Override
	public LocationHierarchy read(Long id)
	{
		return repository.findOne(id);
	}

	@Override
	public void update(LocationHierarchy lh)
	{
		repository.save(lh);
	}

	@Override
	public void delete(Long id)
	{
		repository.delete(id);
	}

	@Override
	public List<LocationHierarchy> getAllHierarchies()
	{
		List<LocationHierarchy> list = new ArrayList<LocationHierarchy>();
		Iterable<LocationHierarchy> hierarchies = repository.findAll();
		hierarchies.forEach(list::add);
		list.sort((lh1, lh2) -> lh1.getLevel().getKeyIdentifier().compareTo(lh2.getLevel().getKeyIdentifier()));
		return list;
	}

	@Override
	public boolean exists(LocationHierarchy lh)
	{
		return this.getAllHierarchies().stream()
				.anyMatch(hierarchy -> hierarchy.equals(lh));
	}
}

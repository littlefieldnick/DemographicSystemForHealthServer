package edu.usm.cos375.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usm.cos375.model.LocationHierarchyLevel;
import edu.usm.cos375.repository.LocationHierarchyLevelRepository;
import edu.usm.cos375.service.LocationHierarchyLevelService;

@Service
public class DefaultLocationHierarchyLevelService implements LocationHierarchyLevelService{

	@Autowired LocationHierarchyLevelRepository repository;
	
	@Override
	public LocationHierarchyLevel read(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void create(LocationHierarchyLevel level) {
		repository.save(level);
	}

	@Override
	public void update(LocationHierarchyLevel level) {
		repository.save(level);
		
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
		
	}

	@Override
	public List<LocationHierarchyLevel> getAllLevels() {
		List<LocationHierarchyLevel> list = new ArrayList<LocationHierarchyLevel>();
		Iterable<LocationHierarchyLevel> levels = repository.findAll();
		levels.forEach(list::add);
		list.sort((lh1, lh2) -> lh1.getKeyIdentifier().compareTo(lh2.getKeyIdentifier()));
		return list;
	}

	@Override
	public LocationHierarchyLevel findByKeyIdentifier(Integer identifier) {
		return repository.findByKeyIdentifier(identifier);
	}

	@Override
	public boolean exists(LocationHierarchyLevel level) {
		return this.getAllLevels().stream()
					.anyMatch(hierarchy -> hierarchy.equals(level));
		
	}

}

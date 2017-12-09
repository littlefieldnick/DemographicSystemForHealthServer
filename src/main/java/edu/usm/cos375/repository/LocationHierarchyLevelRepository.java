package edu.usm.cos375.repository;

import org.springframework.data.repository.CrudRepository;

import edu.usm.cos375.model.LocationHierarchyLevel;


public interface LocationHierarchyLevelRepository extends CrudRepository<LocationHierarchyLevel, Long>
{
	LocationHierarchyLevel findByName(String name);
}

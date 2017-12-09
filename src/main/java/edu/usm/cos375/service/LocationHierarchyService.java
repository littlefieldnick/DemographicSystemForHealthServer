package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.LocationHierarchy;

public interface LocationHierarchyService
{
	LocationHierarchy read(Long id);
    void create(LocationHierarchy hierarchy);
    void update(LocationHierarchy hierarchy);
    void delete(Long id);
    List<LocationHierarchy> getAllHierarchies();
    LocationHierarchy findByName(String name);
    boolean exists(LocationHierarchy hierarchy);
}

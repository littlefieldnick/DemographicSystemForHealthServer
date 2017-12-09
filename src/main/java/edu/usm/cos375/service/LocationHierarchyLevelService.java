package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.LocationHierarchy;
import edu.usm.cos375.model.LocationHierarchyLevel;

public interface LocationHierarchyLevelService {
	LocationHierarchyLevel read(Long id);
    void create(LocationHierarchyLevel level);
    void update(LocationHierarchyLevel level);
    void delete(Long id);
    List<LocationHierarchyLevel> getAllLevels();
    LocationHierarchyLevel findByName(String name);
    boolean exists(LocationHierarchyLevel level);
}

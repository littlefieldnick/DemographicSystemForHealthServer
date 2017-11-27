package edu.usm.cos375.repository;

import edu.usm.cos375.model.Location;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLocationRepositoryMock implements LocationRepository {
    public String n;

    @Override
    public void create(Location l) {
        n = "test";
    }

    @Override
    public Location read(Long id) {
        return null;
    }

    @Override
    public void update(Location l) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Location> getAllLocations() {
        return null;
    }
}

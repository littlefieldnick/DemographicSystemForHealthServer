package edu.usm.cos375.repository;

import org.springframework.data.repository.CrudRepository;

import edu.usm.cos375.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long>
{
}

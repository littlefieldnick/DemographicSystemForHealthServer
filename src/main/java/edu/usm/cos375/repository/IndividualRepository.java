package edu.usm.cos375.repository;

import org.springframework.data.repository.CrudRepository;

import edu.usm.cos375.model.Individual;

public interface IndividualRepository extends CrudRepository<Individual, Long>
{
}

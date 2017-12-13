package edu.usm.cos375.repository;

import org.springframework.data.repository.CrudRepository;

import edu.usm.cos375.model.Individual;

import java.util.List;

public interface IndividualRepository extends CrudRepository<Individual, Long>
{
	Individual findByExtId(String extId);
	List<Individual> findByFirstNameAndLastName(String firstName, String lastName);

}

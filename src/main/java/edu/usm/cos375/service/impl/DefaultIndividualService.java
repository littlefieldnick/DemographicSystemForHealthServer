package edu.usm.cos375.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.repository.IndividualRepository;
import edu.usm.cos375.service.IndividualService;

@Service
public class DefaultIndividualService implements IndividualService
{
	@Autowired 
	IndividualRepository repository;

	@Override
	public List<Individual> findByFirstNameAndLastName(String firstName, String lastName)
	{
		return this.repository.findByFirstNameAndLastName(firstName, lastName);
	}


	@Override
	public List<Individual> getAllIndividuals()
	{
		List<Individual> all = new ArrayList<Individual>();
		Iterable<Individual> individuals = repository.findAll();
		individuals.forEach(all::add);
		all.sort((i1, i2) -> i1.getLastName().compareTo(i2.getLastName()));
		return all;
	}

	@Override
	public Individual getIndividual(long id)
	{
		Individual individual = this.repository.findOne(id);
		return individual;
	}

	@Override
	public void update(Individual individual)
	{
		this.repository.save(individual);		
	}
	
	public void remove(long id)
	{
		this.repository.delete(id);
	}

	@Override
	public void add(Individual individual)
	{
		repository.save(individual);
	}
	
	public boolean contains(long id)
	{
		return this.repository.exists(id);
	}

	@Override
	public Individual findByExtId(String extId) {
		return this.repository.findByExtId(extId);
	}
}

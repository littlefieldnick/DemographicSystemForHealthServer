package edu.usm.cos375.repositories;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.repositories.interfaces.IndividualRepository;

@Repository
public class InMemoryIndividualRepository implements IndividualRepository {

	private volatile long INDIVIDUAL_ID_SEQUENCE = 1L;



	private final Map<Long, Individual> individualDatabase = new LinkedHashMap<>();


	@Override
	public List<Individual> getAll() {
		return new ArrayList<>(this.individualDatabase.values());
	}

	@Override
	public Individual get(long id) {
		return this.individualDatabase.get(id);
	}

	@Override
	public void add(Individual individual) {
		individual.setId(this.getNextIndividualId());
		this.individualDatabase.put(individual.getId(), individual);

	}

	@Override
	public void update(Individual individual) {
		this.individualDatabase.put(individual.getId(), individual);	
	}

	private synchronized long getNextIndividualId()
	{
		return this.INDIVIDUAL_ID_SEQUENCE++;
	}

}

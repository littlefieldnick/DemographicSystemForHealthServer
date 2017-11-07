package edu.usm.cos375.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import javax.inject.Inject;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.repository.IndividualRepository;
import edu.usm.cos375.service.IndividualService;

@Service
public class DefaultIndividualService implements IndividualService {

	@Inject IndividualRepository individualRepository;
	
	@Override
	public List<Individual> getAllIndividuals() {
		return this.individualRepository.getAll();
	}

	@Override
	public Individual getIndividual(long id) {
		Individual individual = this.individualRepository.get(id);
		return individual;
	}

	@Override
	public void update(Individual individual) {
		if(individualRepository.get(individual.getId()) != null) {
			this.individualRepository.update(individual);
		}
		
	}
	
	public void remove(long id) {
		this.individualRepository.delete(id);
	}

	@Override
	public void add(Individual individual) {
		if(individualRepository.contains(individual.getId())) {
			individualRepository.update(individual);
		} else {
			individualRepository.add(individual);
		}
	}
	
	public boolean contains(long id) {
		return this.individualRepository.contains(id);
	}

}

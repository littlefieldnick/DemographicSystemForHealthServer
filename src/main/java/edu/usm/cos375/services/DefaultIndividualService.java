package edu.usm.cos375.services;

import java.util.List;

import org.springframework.stereotype.Service;
import javax.inject.Inject;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.repositories.interfaces.IndividualRepository;
import edu.usm.cos375.services.interfaces.IndividualService;

@Service
public class DefaultIndividualService implements IndividualService {

	@Inject IndividualRepository individualRepository;
	
	@Override
	public List<Individual> getAllIndividuals() {
		return this.individualRepository.getAll();
	}

	@Override
	public Individual getIndividual(long id) {
		return this.getIndividual(id);
	}

	@Override
	public void save(Individual individual) {
		if(individual.getId() < 1) {
			this.individualRepository.add(individual);
		} else {
			this.individualRepository.update(individual);
		}
		
	}
	
	public void remove(long id) {
		this.individualRepository.delete(id);
	}

}

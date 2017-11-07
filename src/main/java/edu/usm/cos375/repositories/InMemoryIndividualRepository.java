package edu.usm.cos375.repositories;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	public InMemoryIndividualRepository(){
		loadStoredData();
	}
	

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

	@Override
	public void delete(long id) {
		this.individualDatabase.remove(id);
	}
	
	public void loadStoredData() {
		Individual individual = new Individual();
		
		individual.setDob(new Date());
		individual.setFirstName("Nick");
		individual.setMiddleName("Gerald");
		individual.setLastName("Littlefield");
		individual.setGender("male");
		individual.setAge(22);
		individual.setPhoneNumber("207-239-9999");
		individual.setLanguagePreference("English");
		individual.setNationality("American");
		
		this.add(individual);
	}

}

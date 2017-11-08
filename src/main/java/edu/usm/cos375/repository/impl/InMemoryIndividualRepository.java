package edu.usm.cos375.repository.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.repository.IndividualRepository;

@Repository
public class InMemoryIndividualRepository implements IndividualRepository {

	private volatile long INDIVIDUAL_ID_SEQUENCE = 1L;

	private static final Map<Long, Individual> individualDatabase = new LinkedHashMap<>();

	public InMemoryIndividualRepository(){
		loadStoredData();	//Load static data
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
		
		individual = new Individual();
		
		individual.setDob(new Date());
		individual.setFirstName("John");
		individual.setMiddleName("");
		individual.setLastName("Smith");
		individual.setGender("male");
		individual.setAge(48);
		individual.setPhoneNumber("607-777-9980");
		individual.setLanguagePreference("English");
		individual.setNationality("American");
		individual.setPointOfContactName("Jane Smith");
		individual.setPointOfContactPhoneNumber("607-777-9981");
		
		this.add(individual);
		
		individual = new Individual();
		individual.setDob(new Date());
		individual.setFirstName("Jane");
		individual.setMiddleName("Elizabeth");
		individual.setLastName("Smith");
		individual.setGender("female");
		individual.setAge(52);
		individual.setPhoneNumber("607-777-9981");
		individual.setOtherPhoneNumber("607-767-9976");
		individual.setLanguagePreference("English");
		individual.setNationality("American");
		individual.setPointOfContactName("John Smith");
		individual.setPointOfContactPhoneNumber("607-777-9980");
		
		this.add(individual);
	}


	@Override
	public boolean contains(long id) {
		if(individualDatabase.containsKey(id))
			return true;
		
		return false;
	}

}

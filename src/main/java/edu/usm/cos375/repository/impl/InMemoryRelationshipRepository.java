package edu.usm.cos375.repository.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.usm.cos375.model.Individual;
import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.repository.RelationshipRepository;

@Repository
public class InMemoryRelationshipRepository implements RelationshipRepository {
	private static volatile long RELATIONSHIP_ID_SEQUENCE = 1L;

	private final static Map<Long, Relationship> relationshipDatabase = new LinkedHashMap<>();
	
	
	static {
		Individual individual = new Individual();
		Calendar cal = Calendar.getInstance();
		cal.set(1969, 7, 2);
		individual.setDob(cal.getTime());
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
				
		Individual individual2 = new Individual();
		cal = Calendar.getInstance();
		cal.set(1965, 10, 19);
		individual2.setDob(cal.getTime());
		individual2.setFirstName("Jane");
		individual2.setMiddleName("Elizabeth");
		individual2.setLastName("Smith");
		individual2.setGender("female");
		individual2.setAge(52);
		individual2.setPhoneNumber("607-777-9981");
		individual2.setOtherPhoneNumber("607-767-9976");
		individual2.setLanguagePreference("English");
		individual2.setNationality("American");
		individual2.setPointOfContactName("John Smith");
		individual2.setPointOfContactPhoneNumber("607-777-9980");
		
		Relationship r = new Relationship();
		r.setId(RELATIONSHIP_ID_SEQUENCE);
		r.setIndividualA(individual);
		r.setIndividualB(individual2);
		r.setStartDate(null);
		r.setaIsToB("Married");
		
		relationshipDatabase.put(RELATIONSHIP_ID_SEQUENCE, r);
		
		getNextRelationshipId();
		r = new Relationship();
		r.setId(RELATIONSHIP_ID_SEQUENCE);
		r.setIndividualA(individual2);
		r.setIndividualB(individual);
		r.setStartDate(null);
		r.setaIsToB("Married");
		relationshipDatabase.put(RELATIONSHIP_ID_SEQUENCE, r);
	}

	@Override
	public List<Relationship> getAll() {
		return new ArrayList<>(relationshipDatabase.values());
	}

	@Override
	public Relationship get(long id) {
		return relationshipDatabase.get(id);
	}

	@Override
	public boolean contains(long id) {
		if(relationshipDatabase.containsKey(id))
			return true;
		
		return false;
	}

	@Override
	public void add(Relationship r) {
		r.setId(getNextRelationshipId());
		relationshipDatabase.put(r.getId(), r);
	}

	@Override
	public void update(Relationship r) {
		relationshipDatabase.put(r.getId(), r);	
		
	}

	@Override
	public void delete(long id) {
		relationshipDatabase.remove(id);	
		
	}
	
	
	private static synchronized long getNextRelationshipId()
	{
		return RELATIONSHIP_ID_SEQUENCE++;
	}
}

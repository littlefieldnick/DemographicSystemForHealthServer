package edu.usm.cos375.repository.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.repository.RelationshipRepository;
import edu.usm.cos375.service.impl.DefaultIndividualService;

public class InMemoryRelationshipRepository implements RelationshipRepository {
	private static volatile long RELATIONSHIP_ID_SEQUENCE = 1L;

	private final static Map<Long, Relationship> relationshipDatabase = new LinkedHashMap<>();
	
	static {
		DefaultIndividualService service = new DefaultIndividualService();
		Relationship r = new Relationship();
		r.setId(RELATIONSHIP_ID_SEQUENCE);
		r.setIndividualA(service.getIndividual(1));
		r.setIndividualB(service.getIndividual(2));
		r.setStartDate(null);
		r.setaIsToB("Married");
		
		relationshipDatabase.put(RELATIONSHIP_ID_SEQUENCE, r);
		
		getNextRelationshipId();
		r = new Relationship();
		r.setId(RELATIONSHIP_ID_SEQUENCE);
		r.setIndividualA(service.getIndividual(2));
		r.setIndividualB(service.getIndividual(1));
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
		r.setId(this.getNextRelationshipId());
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

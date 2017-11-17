package edu.usm.cos375.repository.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.repository.RelationshipRepository;

public class InMemoryRelationshipRepository implements RelationshipRepository {
	private volatile long RELATIONSHIP_ID_SEQUENCE = 1L;

	private final Map<Long, Relationship> relationshipDatabase = new LinkedHashMap<>();
	
	static {
		
	}

	@Override
	public List<Relationship> getAll() {
		return new ArrayList<>(this.relationshipDatabase.values());
	}

	@Override
	public Relationship get(long id) {
		return this.relationshipDatabase.get(id);
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
		this.relationshipDatabase.put(r.getId(), r);

		
	}

	@Override
	public void update(Relationship r) {
		this.relationshipDatabase.put(r.getId(), r);	
		
	}

	@Override
	public void delete(long id) {
		this.relationshipDatabase.remove(id);	
		
	}
	
	private synchronized long getNextRelationshipId()
	{
		return this.RELATIONSHIP_ID_SEQUENCE++;
	}
}

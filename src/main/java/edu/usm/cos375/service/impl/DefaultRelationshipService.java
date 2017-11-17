package edu.usm.cos375.service.impl;

import javax.inject.Inject;

import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.repository.RelationshipRepository;
import edu.usm.cos375.service.RelationshipService;
import java.util.*;
public class DefaultRelationshipService implements RelationshipService{

	@Inject RelationshipRepository relationshipRepository;
	
	@Override
	public void create(Relationship r) {
		if(relationshipRepository.contains(r.getId())) {
			relationshipRepository.update(r);
		} else {
			relationshipRepository.add(r);
		}
		
	}

	@Override
	public Relationship read(long id) {
		Relationship r = this.relationshipRepository.get(id);
		return r;		
	}

	@Override
	public List<Relationship> readAll() {
		List<Relationship> all = this.relationshipRepository.getAll();
		all.sort((i1, i2) -> i1.getId().compareTo(i2.getId()));
		return all;
		
	}

	@Override
	public void update(long id, Relationship r) {
		if(relationshipRepository.get(id) != null) {
			this.relationshipRepository.update(r);
		}
		
	}

	@Override
	public void remove(long id) {
		this.relationshipRepository.delete(id);
		
	}

}

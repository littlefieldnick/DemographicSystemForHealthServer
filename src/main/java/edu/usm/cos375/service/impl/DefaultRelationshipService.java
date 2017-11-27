package edu.usm.cos375.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.repository.RelationshipRepository;
import edu.usm.cos375.service.RelationshipService;

@Service
public class DefaultRelationshipService implements RelationshipService
{
	@Autowired 
	RelationshipRepository repository;
	
	@Override
	public void create(Relationship r)
	{
		repository.save(r);
	}

	@Override
	public Relationship read(long id)
	{
		Relationship r = this.repository.findOne(id);
		return r;		
	}

	@Override
	public List<Relationship> readAll()
	{
		List<Relationship> all = new ArrayList<Relationship>();
		Iterable<Relationship> relationships = this.repository.findAll();
		relationships.forEach(all::add);
		all.sort((i1, i2) -> i1.getId().compareTo(i2.getId()));
		return all;
	}

	@Override
	public void update(long id, Relationship r)
	{
		this.repository.save(r);
	}

	@Override
	public void remove(long id)
	{
		this.repository.delete(id);
	}
}

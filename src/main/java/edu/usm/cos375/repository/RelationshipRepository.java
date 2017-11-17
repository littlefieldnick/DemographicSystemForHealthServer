package edu.usm.cos375.repository;

import java.util.List;

import edu.usm.cos375.model.Relationship;

public interface RelationshipRepository {
	List<Relationship> getAll();
	Relationship get(long id);
	boolean contains(long id);
	void add(Relationship r);
	void update(Relationship r);
	void delete(long id);
}

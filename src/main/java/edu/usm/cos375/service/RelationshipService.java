package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.Relationship;

public interface RelationshipService
{
	void create(Relationship r);
    Relationship read(long id);
    List<Relationship> readAll();
    void update(long id, Relationship r);
    void remove(long id);
}

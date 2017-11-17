package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.model.Individual;

public interface RelationshipService
{
    void create(Relationship r);
    void read(long id);
    void readAll();
    void update(long id, Relationship r);
    void remove(long id);
}

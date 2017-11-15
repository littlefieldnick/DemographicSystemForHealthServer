package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.Relationship;
import edu.usm.cos375.model.Individual;

public interface RelationshipService
{
    List<Relationship> getAllIndividuals();
    Relationship getRelationshipA(Individual individualA);
    void add(Individual individual);
    void update(Individual individual);
    void remove(long id);
}

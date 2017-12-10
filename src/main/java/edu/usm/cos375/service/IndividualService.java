package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.Individual;

public interface IndividualService
{
    List<Individual> getAllIndividuals();
    Individual getIndividual(long id);
    Individual findByExtId(String extId);
    void add(Individual individual);
    void update(Individual individual);
    void remove(long id);
}

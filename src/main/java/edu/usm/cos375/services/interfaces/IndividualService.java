package edu.usm.cos375.services.interfaces;

import java.util.List;

import edu.usm.cos375.model.Individual;

public interface IndividualService
{
    List<Individual> getAllIndividuals();
    Individual getIndividual(long id);
    void save(Individual individual);
}

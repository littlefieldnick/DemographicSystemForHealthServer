package edu.usm.cos375.repository;

import java.util.List;
import edu.usm.cos375.model.Individual;

public interface IndividualRepository {
    List<Individual> getAll();
    Individual get(long id);
    boolean contains(long id);
    void add(Individual individual);
    void update(Individual individual);
    void delete(long id);
}

package edu.usm.cos375.repository;

import java.util.List;

import edu.usm.cos375.model.Fieldworker;

public interface FieldworkerRepository {
	List<Fieldworker> getAll();
	Fieldworker get(long id);
	boolean contains(long id);
	void add(Fieldworker fieldworker);
	void update(Fieldworker fieldworker);
	void delete(long id);
}

package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.Fieldworker;

public interface FieldworkerService
{
	List<Fieldworker> getAllFieldworkers();
	Fieldworker getFieldworker(long id);
	void add(Fieldworker fieldworker);
	void update(Fieldworker fieldworker);
	void remove(long id);
}

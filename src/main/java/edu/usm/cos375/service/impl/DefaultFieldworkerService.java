package edu.usm.cos375.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usm.cos375.model.Fieldworker;
import edu.usm.cos375.model.Individual;
import edu.usm.cos375.repository.FieldworkerRepository;
import edu.usm.cos375.service.FieldworkerService;

@Service
public class DefaultFieldworkerService implements FieldworkerService {

	@Autowired 
	FieldworkerRepository repository;
	
	@Override
	public List<Fieldworker> getAllFieldworkers() 
	{
		Iterable<Fieldworker> allFieldworkers = this.repository.findAll();
		List<Fieldworker> all = new ArrayList<Fieldworker>();
		allFieldworkers.forEach(all::add);
		all.sort((f1, f2) -> f1.getLastName().compareTo(f2.getLastName()));
		return all;
	}

	@Override
	public Fieldworker getFieldworker(long id) 
	{
		Fieldworker f = this.repository.findOne(id);
		return f;
	}

	@Override
	public void add(Fieldworker fieldworker) 
	{
		repository.save(fieldworker);
		
		
	}

	@Override
	public void update(Fieldworker fieldworker) 
	{
		repository.save(fieldworker);
		
	}

	@Override
	public void remove(long id) 
	{
		this.repository.delete(id);
		
	}

}

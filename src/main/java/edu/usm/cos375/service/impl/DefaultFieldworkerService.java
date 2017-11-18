package edu.usm.cos375.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.usm.cos375.model.Fieldworker;
import edu.usm.cos375.model.Individual;
import edu.usm.cos375.repository.FieldworkerRepository;
import edu.usm.cos375.service.FieldworkerService;

@Service
public class DefaultFieldworkerService implements FieldworkerService {

	@Inject FieldworkerRepository fieldworkerRepository;
	
	@Override
	public List<Fieldworker> getAllFieldworkers() 
	{
		List<Fieldworker> all = this.fieldworkerRepository.getAll();
		all.sort((f1, f2) -> f1.getLastName().compareTo(f2.getLastName()));
		return all;
	}

	@Override
	public Fieldworker getFieldworker(long id) 
	{
		Fieldworker f = this.fieldworkerRepository.get(id);
		return f;
	}

	@Override
	public void add(Fieldworker fieldworker) 
	{
		if(fieldworkerRepository.contains(fieldworker.getId())) {
			fieldworkerRepository.update(fieldworker);
		} else {
			fieldworkerRepository.add(fieldworker);
		}
		
	}

	@Override
	public void update(Fieldworker fieldworker) 
	{
		if(fieldworkerRepository.get(fieldworker.getId()) != null) {
			this.fieldworkerRepository.update(fieldworker);
		}
		
	}

	@Override
	public void remove(long id) 
	{
		this.fieldworkerRepository.delete(id);
		
	}

}

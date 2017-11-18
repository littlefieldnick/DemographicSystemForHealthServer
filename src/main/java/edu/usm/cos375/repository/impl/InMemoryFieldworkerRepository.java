package edu.usm.cos375.repository.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.usm.cos375.model.Fieldworker;
import edu.usm.cos375.repository.FieldworkerRepository;

@Repository
public class InMemoryFieldworkerRepository implements FieldworkerRepository{

	private static volatile long FIELDWORKER_ID_SEQUENCE = 1L;

	private final static Map<Long, Fieldworker> fieldworkerDatabase = new LinkedHashMap<>();
	
	@Override
	public List<Fieldworker> getAll() {
		return new ArrayList<>(fieldworkerDatabase.values());
	}

	@Override
	public Fieldworker get(long id) {
		return fieldworkerDatabase.get(id);
	}

	@Override
	public boolean contains(long id) {
		if(fieldworkerDatabase.containsKey(id))
			return true;
		
		return false;
	}

	@Override
	public void add(Fieldworker fieldworker) {
		fieldworker.setId(getNextFieldworkerId());
		fieldworkerDatabase.put(fieldworker.getId(), fieldworker);
		
	}

	@Override
	public void update(Fieldworker fieldworker) {
		fieldworkerDatabase.put(fieldworker.getId(), fieldworker);
		
	}

	@Override
	public void delete(long id) {
		fieldworkerDatabase.remove(id);
		
	}
	
	private static synchronized long getNextFieldworkerId()
	{
		return FIELDWORKER_ID_SEQUENCE++;
	}

}

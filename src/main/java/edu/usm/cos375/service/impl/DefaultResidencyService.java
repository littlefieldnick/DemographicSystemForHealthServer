package edu.usm.cos375.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.usm.cos375.model.Residency;
import edu.usm.cos375.repository.ResidencyRepository;
import edu.usm.cos375.service.ResidencyService;

@Service
public class DefaultResidencyService implements ResidencyService
{
	@Inject
	ResidencyRepository repository;

	@Override
	public void create(Residency r)
	{
		repository.create(r);
	}

	@Override
	public Residency read(Long id)
	{
		return repository.read(id);
	}

	@Override
	public void update(Residency r)
	{
		repository.update(r);
	}

	@Override
	public void delete(Long id)
	{
		repository.delete(id);
	}

	@Override
	public List<Residency> getAllResidencies()
	{
		List <Residency> list = repository.getAllResidencies();
		list.sort((r1, r2) -> r1.getLocation().getLocationName()
				.compareTo(r2.getLocation().getLocationName()));
		return list;
	}

	@Override
	public boolean exists(Residency r)
	{
		return repository.getAllResidencies().stream()
				.anyMatch(residency -> residency.equals(r));
	}
}

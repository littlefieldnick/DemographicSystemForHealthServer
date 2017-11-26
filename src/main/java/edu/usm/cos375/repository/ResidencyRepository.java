package edu.usm.cos375.repository;

import java.util.List;

import edu.usm.cos375.model.Residency;

public interface ResidencyRepository 
{
	public void create(Residency r);
	public Residency read(Long id);
	public void update(Residency l);
	public void delete(Long id);
	public List<Residency> getAllResidencies();
}

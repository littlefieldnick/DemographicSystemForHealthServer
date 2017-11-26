package edu.usm.cos375.service;

import java.util.List;

import edu.usm.cos375.model.Residency;

public interface ResidencyService 
{
	void create(Residency r);
	Residency read(Long id);
	void update(Residency r);
	void delete(Long id);
	List<Residency> getAllResidencies();
	boolean exists(Residency residency);
}

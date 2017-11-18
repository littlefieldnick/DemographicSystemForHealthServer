package edu.usm.cos375.controller;
import edu.usm.cos375.model.*;
import edu.usm.cos375.service.IndividualService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.inject.Inject;
import java.util.List;


@Controller
@RequestMapping("/individuals")
public class IndividualController {

	@Inject IndividualService individualService;

	//Get all the current individuals
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Individual> getAll(){
		return individualService.getAllIndividuals();
	}

	//Find an individual by their id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Individual get(@PathVariable("id") long id) {
		return individualService.getIndividual(id);
	}


	//Add an individual 
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void create(@RequestBody Individual individual) {
		if(individualService.getIndividual(individual.getId()) != null) {
			individualService.update(individual);
		} else {
			individualService.add(individual);
		}
	}


	//Update an existing user
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Individual update(@PathVariable int id, @RequestBody Individual individual){
		Individual updateIndividual = individualService.getIndividual(id);
		
		if(updateIndividual == null) {
			return null;
		}
		
		individualService.update(individual);
		
		return individualService.getIndividual(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable("id") long id) {
		individualService.remove(id);
	}
}

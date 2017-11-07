package edu.usm.cos375.controller;
import edu.usm.cos375.services.interfaces.*;
import edu.usm.cos375.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("individuals")
public class IndividualController {

	@Inject IndividualService individualService;

	//Get all the current individuals
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Individual>> getAll(){
		List<Individual> individuals = individualService.getAllIndividuals();
		if(individuals == null|| individuals.isEmpty()) {
			return new ResponseEntity<List<Individual>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Individual>>(individuals, HttpStatus.OK);
	}

	//Find an individual by their id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Individual> get(@PathVariable("id") int id){
		Individual individual = individualService.getIndividual(id);

		if(individual == null) {
			return new ResponseEntity<Individual>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Individual>(individual, HttpStatus.OK);
	}

	//Add an individual 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Individual individual, UriComponentsBuilder ucBuilder){
		if(individualService.getIndividual(individual.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		individualService.save(individual);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(individual.getId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//Update an existing user
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Individual> update(@PathVariable int id, @RequestBody Individual individual){
		Individual updateIndividual = individualService.getIndividual(id);

		if(updateIndividual == null) {
			return new ResponseEntity<Individual>(HttpStatus.NOT_FOUND);
		}

		individualService.save(individual);
		updateIndividual = individualService.getIndividual(id);

		return new ResponseEntity<Individual>(updateIndividual, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		Individual individual = individualService.getIndividual(id);
		if (individual == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		individualService.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}



}

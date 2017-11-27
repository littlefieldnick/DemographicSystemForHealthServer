package edu.usm.cos375.controller;
import edu.usm.cos375.annotation.RestEndpoint;
import edu.usm.cos375.exception.ResourceNotFoundException;
import edu.usm.cos375.model.*;
import edu.usm.cos375.service.IndividualService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestEndpoint
@RequestMapping("/individuals")
public class IndividualController {

	@Autowired 
	IndividualService individualService;

	//Get all the current individuals
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Individual>> getAll(){
		List<Individual> individuals = individualService.getAllIndividuals();
		if(individuals == null || individuals.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		return new ResponseEntity<List<Individual>>(individuals, HttpStatus.OK);
	}

	//Find an individual by their id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Individual> get(@PathVariable("id") long id){
        Individual individual = individualService.getIndividual(id);

        if (individual == null){
        		throw new ResourceNotFoundException();
        }

        return new ResponseEntity<Individual>(individual, HttpStatus.OK);
    }

	//Add an individual 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Individual individual, UriComponentsBuilder ucBuilder){
		individualService.add(individual);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/individuals/{id}").buildAndExpand(individual.getId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//Update an existing user
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Individual> update(@PathVariable int id, @RequestBody Individual individual){
		Individual updateIndividual = individualService.getIndividual(id);

		if(updateIndividual == null) {
			throw new ResourceNotFoundException();
		}

		individualService.update(individual);
		updateIndividual = individualService.getIndividual((long) id);

		return new ResponseEntity<Individual>(updateIndividual, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") long id){
		Individual individual = individualService.getIndividual(id);
		if (individual == null){
			throw new ResourceNotFoundException();
		}

		individualService.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}



}

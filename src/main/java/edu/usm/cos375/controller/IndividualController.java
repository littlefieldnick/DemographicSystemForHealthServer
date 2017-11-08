package edu.usm.cos375.controller;
import edu.usm.cos375.model.*;
import edu.usm.cos375.service.IndividualService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/individuals")
public class IndividualController {

	@Inject IndividualService individualService;

	//Get all the current individuals
	@RequestMapping(method = RequestMethod.GET)
	public List<Individual> getAll(){
		return individualService.getAllIndividuals();
	}
	
//	public ResponseEntity<List<Individual>> getAll(){
//		List<Individual> individuals = individualService.getAllIndividuals();
//		if(individuals == null || individuals.isEmpty()) {
//			return new ResponseEntity<List<Individual>>(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<Individual>>(individuals, HttpStatus.OK);
//	}

	//Find an individual by their id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Individual get(@PathVariable("id") long id) {
		return individualService.getIndividual(id);
	}
	
//    public ResponseEntity<Individual> get(@PathVariable("id") long id){
//        Individual individual = individualService.getIndividual(id);
//
//        if (individual == null){
//            return new ResponseEntity<Individual>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<Individual>(individual, HttpStatus.OK);
//    }

	//Add an individual 
	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody Individual individual) {
		if(individualService.getIndividual(individual.getId()) != null) {
			individualService.update(individual);
		} else {
			individualService.add(individual);
		}
	}
//	public ResponseEntity<Void> create(@RequestBody Individual individual, UriComponentsBuilder ucBuilder){
//		if(individualService.getIndividual(individual.getId()) != null) {
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//
//		individualService.add(individual);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/individuals/{id}").buildAndExpand(individual.getId()).toUri());
//
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}

	//Update an existing user
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Individual update(@PathVariable int id, @RequestBody Individual individual){
		Individual updateIndividual = individualService.getIndividual(id);
		
		if(updateIndividual == null) {
			return null;
		}
		
		individualService.update(individual);
		
		return individualService.getIndividual(id);
	}
//	public ResponseEntity<Individual> update(@PathVariable int id, @RequestBody Individual individual){
//		Individual updateIndividual = individualService.getIndividual(id);
//
//		if(updateIndividual == null) {
//			return new ResponseEntity<Individual>(HttpStatus.NOT_FOUND);
//		}
//
//		
//		individualService.update(individual);
//		updateIndividual = individualService.getIndividual((long) id);
//
//		return new ResponseEntity<Individual>(updateIndividual, HttpStatus.OK);
//	}

	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id) {
		individualService.remove(id);
	}
	
//	public ResponseEntity<Void> delete(@PathVariable("id") long id){
//		Individual individual = individualService.getIndividual(id);
//		if (individual == null){
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}
//
//		individualService.remove(id);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}



}
